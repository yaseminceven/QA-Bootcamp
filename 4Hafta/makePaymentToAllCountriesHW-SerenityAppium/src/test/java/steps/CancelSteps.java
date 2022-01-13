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
import tasks.CancelPayment;
import tasks.LoginToEriBank;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class CancelSteps {
    public static int initialBalance = 100;

    @Managed(driver = "Appium")
    public WebDriver MobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user login to app")
    public void userLoginToApp() {
        actor.can(BrowseTheWeb.with(MobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @When("user makes a payment to {string} {string} {string} with amount of {string} and cancels")
    public void userMakesAPaymentToWithAmountOfAndCancels(String name, String phone, String country, String amount) {
        actor.attemptsTo(CancelPayment.cancel(name,phone,country,amount));
    }

    @Then("user should see the same balance")
    public void userShouldSeeTheSameBalance() {
        actor.should(
                seeThat(RemainingBalance.balance(), Matchers.is("Your balance is: "+Integer.toString(initialBalance)+".00$"))
        );
    }
}
