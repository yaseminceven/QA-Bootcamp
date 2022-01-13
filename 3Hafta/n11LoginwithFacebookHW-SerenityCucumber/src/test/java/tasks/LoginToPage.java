package tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static user_interface.n11HomePageElements.LOGIN_LINK;
import static user_interface.n11LoginPageElements.FACEBOOK_LINK;

public class LoginToPage implements Task{
    @Step("{0} redirected to the Facebook login page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGIN_LINK),
                Click.on(FACEBOOK_LINK),
                Switch.toTheOtherWindow()
        );
    }

    public static LoginToPage loginWithFacebook() {
        return instrumented(LoginToPage.class);
    }
}
