package user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FacebookLoginPageElements {
    public static Target EMAIL_FIELD = Target.the("Facebook email")
            .located(By.id("email"));
    public static Target PASSWORD_FIELD = Target.the("Facebook password").
            located(By.id("pass"));
    public static Target LOGIN_BUTTON = Target.the("Login Button").
            located(By.name("login"));
    public static Target CONTINUE_BUTTON = Target.the("Continue Button").
            locatedBy(".a8c37x1j.ni8dbmo4.stjgntxs.l9j0dhe7.ltmttdrg.g0qnabr5.ojkyduve");
}
