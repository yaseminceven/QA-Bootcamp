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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ValidAuthSteps {
    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="yasemin";
    Actor actor = Actor.named(actorName);

    @Before
    //setting the stage for the actor
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @When("I login with username company and password company")
    public void iLoginWithUsernameCompanyAndPasswordCompany() {
        //giving an ability to actor to the browse the page
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
    }

    @Then("you should see the home page")
    public void youShouldSeeTheHomePage() {
        actor.should(
                seeThat(the(LoginPageElements.LOGIN_BTN), isNotCurrentlyVisible())
        );
    }


}
