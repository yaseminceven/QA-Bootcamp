package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.n11.navigation.signup.SignUpN11SellerPage;
import starter.n11.navigation.tasks.NavigateToSeller;


public class N11SellerPageSteps {
    Actor actor = Actor.named("patikadev");

    @Managed
    WebDriver webDriver;

    @Given("user launch browser and open the login page")
    public void userLaunchBrowserAndOpenTheLoginPage() {
        actor.can(BrowseTheWeb.with(webDriver));
        actor.wasAbleTo(NavigateToSeller.theN11SellerPage());
    }

    @When("user signed in selleroffice with valid credentials")
    public void userSignedInSellerofficeWithValidCredentials() {
        actor.attemptsTo(SignUpN11SellerPage.signUpThePage("serenitytest","serenitytest@gmail.com","serenitytest*1","test"));
    }

    @Then("user signed in selleroffice successfully")
    public void userSignedInSellerofficeSuccessfully() {
        String url =  "https://so.n11.com/";
        String currentUrl = webDriver.getCurrentUrl();
        actor.attemptsTo(
                Ensure.that(currentUrl).isEqualToIgnoringCase(url)
        );
    }

}
