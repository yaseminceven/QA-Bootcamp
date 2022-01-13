package starter.n11.navigation.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class n11SellerPageSignUpElements {

    public static Target SELLERUSERNAME_FIELD = Target.the("seller username field").located(By.id("usernameInputText"));
    public static Target DIALOGLOADING_LABEL = Target.the("dialog loading").located(By.id("dialogLoading"));
    public static Target SELLERPASSWORD_FIELD = Target.the("seller password field").located(By.id("passwordInputText"));
    public static final Target PASSWORDRETYPE_FIELD = Target.the("seller password verify").located(By.id("passwordRetypeInputText"));
    public static final Target SELLEREMAIL_FIELD = Target.the("seller email").located(By.id("emailInputText"));
    public static final Target EMAILRETYPE_FIELD = Target.the("seller email verify").located(By.id("emailRetypeInputText"));
    public static final Target STORENAME_FIELD = Target.the("seller storename").located(By.id("nicknameInputText"));
    public static final Target MEMBERSHIP_BUTTON = Target.the("membership radio button").locatedBy("//*[@id=\"membershipTypeRadio\"]/tbody/tr/td[1]/div/div[2]");
    public static final Target SIGNUP_BUTTON = Target.the("signup button").located(By.id("j_id274_j_id_dj"));
}
