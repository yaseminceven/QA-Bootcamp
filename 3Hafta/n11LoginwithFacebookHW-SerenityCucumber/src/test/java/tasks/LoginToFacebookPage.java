package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import user_interface.n11UserHomePageElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static user_interface.FacebookLoginPageElements.*;

public class LoginToFacebookPage implements Task {
    private final String email;
    private final String password;

    public LoginToFacebookPage(String email,String password) {
        this.email = email;
        this.password=password;
    }

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor){
        //Login with facebook account
        actor.attemptsTo(
                WaitUntil.the(EMAIL_FIELD,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(EMAIL_FIELD),
                Enter.theValue(this.email).into(EMAIL_FIELD),
                Click.on(PASSWORD_FIELD),
                Enter.theValue(this.password).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON),
                Click.on(CONTINUE_BUTTON),
                Switch.toTheOtherWindow()
        );

        //accept the contract
        actor.attemptsTo(
                WaitUntil.the(n11UserHomePageElements.CONTRACT_BUTTON,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(n11UserHomePageElements.CONTRACT_BUTTON),
                Click.on(n11UserHomePageElements.SMS_BUTTON),
                Click.on(n11UserHomePageElements.ACCEPT_BUTTON),
                WaitUntil.the(n11UserHomePageElements.CLOSE_BUTTON,isClickable()).forNoMoreThan(30).seconds(),
                Click.on(n11UserHomePageElements.CLOSE_BUTTON)
        );

        //click on the username link to check the name
        actor.attemptsTo(
                Click.on(n11UserHomePageElements.USERNAME_LINK)
        );
    }

    public static LoginToFacebookPage loginWithFacebook(String email_text, String password_text) {
        return instrumented(LoginToFacebookPage.class
                ,email_text,password_text);
    }
}
