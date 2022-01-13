package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageElements {
    public static Target BALANCE_VIEW = Target.the("Remaining balance text")
            .located(By.className("android.view.View"));
}
