package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.HomePageElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogoutEribank implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageElements.LOGOUT_BUTTON)
        );
    }

    public static LogoutEribank logout(){
        return instrumented(LogoutEribank.class);
    }
}
