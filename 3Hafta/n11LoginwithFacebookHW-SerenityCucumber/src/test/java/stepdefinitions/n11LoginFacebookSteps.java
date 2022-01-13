package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.LoginToFacebookPage;
import tasks.LoginToPage;
import tasks.NavigateTo;
import user_interface.n11UserHomePageElements;
import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

public class n11LoginFacebookSteps {
    Actor actor = Actor.named("patika.dev");
    @Managed(clearCookies=BeforeEachTest)
    WebDriver webDriver;

    @Given("User opens browser and the main page")
    public void user_opens_browser_and_the_main_page() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateTo.openN11HomePage());
    }

    @When("User navigate to Facebook Page")
    public void user_navigate_to_facebook_page() {
        actor.attemptsTo(LoginToPage.loginWithFacebook());
    }

    @And("User logged in with valid Facebook credentials")
    public void user_logged_in_with_valid_facebook_credentials() {
        actor.attemptsTo(LoginToFacebookPage.loginWithFacebook("testyasemin@gmail.com","!D6HgH&oAD"));
    }

    @Then("User loges in to user main page")
    public void user_loges_in_to_user_main_page() {
        actor.attemptsTo(
                Ensure.that(n11UserHomePageElements.USERNAME_LINK).text()
                        .isEqualToIgnoringCase("Yasemin Zeynep")
        );
    }
}
