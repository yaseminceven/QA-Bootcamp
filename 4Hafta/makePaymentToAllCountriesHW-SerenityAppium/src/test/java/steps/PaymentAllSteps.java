package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import questions.RemainingBalance;
import tasks.LoginToEriBank;
import tasks.MakePaymentAll;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PaymentAllSteps {
    public static int initialBalance = 100;
    public static int newBalance;

    @Managed(driver = "Appium")
    public WebDriver MobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user can open the application and login to app")
    public void userCanOpenTheApplicationAndLoginToApp() {
        actor.can(BrowseTheWeb.with(MobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @When("user makes a payment with {string} amount to {string} {string} to the each country")
    public void userMakesAPaymentWithAmountToToTheEachCountry(String amount, String phone, String name) {
        actor.attemptsTo(MakePaymentAll.pay(amount,phone,name));
    }

    @Then("user should see balance is reduced by {string}  for each country")
    public void userShouldSeeBalanceIsReducedByForEachCountry(String amount) {
        newBalance=initialBalance-(16*(Integer.parseInt(amount)));
        actor.should(
                seeThat(RemainingBalance.balance(),Matchers.is("Your balance is: "+Integer.toString(newBalance)+".00$"))
        );
    }


}

