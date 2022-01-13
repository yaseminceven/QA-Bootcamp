package user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class n11UserHomePageElements {
    public static Target CONTRACT_BUTTON = Target.the("Contract Agreement Button").
            located(By.id("acceptContract"));
    public static Target SMS_BUTTON = Target.the("Email and SMS Agreement Button").
            located(By.id("sendPromotionalMailAndSms"));
    public static Target ACCEPT_BUTTON = Target.the("Accept Terms Button").
            locatedBy("#confirmBtn");
    public static Target CLOSE_BUTTON = Target.the("Close Button").
            locatedBy("#userAgreementLB > div:nth-child(1) > span:nth-child(1)");
    public static Target USERNAME_LINK = Target.the("User Account Link").
            locatedBy(".menuLink.user");
}
