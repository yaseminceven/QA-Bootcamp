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
import tasks.MakePayment;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PaymentSteps {

    public static int initialBalance = 100;
    public static int newBalance;

    @Managed(driver = "Appium")
    public static WebDriver MobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user can open the application and login")
    public void userCanOpenTheApplication() {
        actor.can(BrowseTheWeb.with(MobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @When("user makes a payment with {string} amount to {string} {string} {string}")
    public void userMakesAPaymentForAmountToCountry(String amount,String phone,String name,String country) {
        actor.attemptsTo(MakePayment.pay(amount,phone,name,country));
    }

    @Then("user should see balance is reduced by {string}")
    public void userShouldSeeBalanceIsReducedByAmount(String amount) {
        newBalance=initialBalance-(Integer.parseInt(amount));
        actor.should(
                seeThat(RemainingBalance.balance(), Matchers.is("Your balance is: "+Integer.toString(newBalance)+".00$"))
        );

    }


}
