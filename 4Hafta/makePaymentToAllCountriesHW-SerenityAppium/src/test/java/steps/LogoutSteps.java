package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import tasks.LogoutEribank;
import ui.LoginPageElements;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class LogoutSteps {
    @Managed(driver = "Appium")
    public WebDriver MobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user logged in to application")
    public void userLoggedInToApplication() {
        actor.can(BrowseTheWeb.with(MobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @When("user loges out")
    public void userLogesOut() {
        actor.attemptsTo(LogoutEribank.logout());
    }

    @Then("user should see login page")
    public void userShouldSeeLoginPage() {
        actor.should(
                seeThat(the(LoginPageElements.LOGIN_BTN),WebElementStateMatchers.isVisible())
        );
    }

}
