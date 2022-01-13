package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.HomePageElements;

public class RemainingBalance implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return HomePageElements.BALANCE_VIEW.resolveFor(actor).getAttribute("content-desc");
    }

    public static RemainingBalance balance(){
        return new RemainingBalance();
    }
}
