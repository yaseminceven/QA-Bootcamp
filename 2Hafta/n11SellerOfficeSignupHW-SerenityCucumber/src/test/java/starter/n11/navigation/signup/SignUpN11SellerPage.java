package starter.n11.navigation.signup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import starter.n11.navigation.user_interface.n11SellerHomePageElements;
import starter.n11.navigation.user_interface.n11SellerPageSignUpElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotSelected;
import static starter.n11.navigation.user_interface.n11SellerPageSignUpElements.*;

public class SignUpN11SellerPage implements Task {

    private final String username_text;
    private final String email_text;
    private final String password_text;
    private final String storename_text;

    public SignUpN11SellerPage(String username_text,String email_text,String password_text,String storename_text) {
        this.username_text = username_text;
        this.email_text = email_text;
        this.password_text = password_text;
        this.storename_text = storename_text;
    }

    @Step("{0} Signup with username '#username_text' email '#email_text' password '#password_text' and storename '#storename_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(n11SellerHomePageElements.SIGNUP_LINK),
                WaitUntil.the(SELLERUSERNAME_FIELD,isClickable()).forNoMoreThan(5).seconds(),
                Click.on(SELLERUSERNAME_FIELD),
                Enter.theValue(this.username_text).into(SELLERUSERNAME_FIELD),
                WebElementStateMatchers.isNotVisible(DIALOGLOADING_LABEL),
                Click.on(SELLERPASSWORD_FIELD),
                Enter.theValue(this.password_text).into(SELLERPASSWORD_FIELD),
                Click.on(PASSWORDRETYPE_FIELD),
                Enter.theValue(this.password_text).into(PASSWORDRETYPE_FIELD),
                Click.on(SELLEREMAIL_FIELD),
                Enter.theValue(this.email_text).into(SELLEREMAIL_FIELD),
                Click.on(EMAILRETYPE_FIELD),
                Enter.theValue(this.email_text).into(EMAILRETYPE_FIELD),
                Click.on(STORENAME_FIELD),
                Enter.theValue(this.storename_text).into(STORENAME_FIELD),
                Click.on(MEMBERSHIP_BUTTON),
                Click.on(SIGNUP_BUTTON)
        );
    }

    public static SignUpN11SellerPage signUpThePage(String username_text,String email_text, String password_text,String storename_text) {
        return instrumented(SignUpN11SellerPage.class
                ,username_text,email_text,password_text,storename_text);
    }
}

