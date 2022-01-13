package tasks;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;


public class ScrollDown implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        TouchAction swipe = new TouchAction(getProxiedDriver())
                .press(PointOption.point(581, 1132))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(581, 250))
                .release();
        swipe.perform();

    }

    public static ScrollDown scroll(){
        return instrumented(ScrollDown.class);
    }
}
