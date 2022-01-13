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
import questions.SendPayment;
import tasks.LoginToEriBank;
import tasks.MakeInvalidPayment;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class InvalidPaymentSteps {
    @Managed(driver = "Appium")
    public WebDriver MobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user can login to app")
    public void userLoginToApp() {
        actor.can(BrowseTheWeb.with(MobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @When("user makes a payment to {string} {string} with {string} to {string}")
    public void userMakesAPaymentWithAmountAmountToNamePhoneCountry(String phone,String name, String amount, String country) {
        actor.attemptsTo(MakeInvalidPayment.pay(phone,name,amount,country));
    }

    @Then("user should not click the send payment")
    public void userShouldNotClickTheSendPayment() {
        actor.should(
              seeThat(SendPayment.send(), Matchers.is(false))
        );
    }
}