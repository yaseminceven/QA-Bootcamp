package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import ui.LoginPageElements;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

//Testing with invalid credentials
public class InvalidAuthSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @When("User logins with invalid username and password")
    public void user_logins_with_invalid_username_and_password() {
        //giving an ability to actor to the browse the page
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(LoginToEriBank.login("username","password"));
    }

    @Then("User should see the information toast")
    public void user_should_see_the_home_page() {
        actor.should(
                seeThat(the(LoginPageElements.LOGIN_BTN), isCurrentlyVisible())
                );
    }



}
