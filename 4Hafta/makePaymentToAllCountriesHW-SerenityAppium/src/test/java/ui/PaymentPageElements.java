package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentPageElements {
    public static Target PAYMENT_BUTTON = Target.the("Payment button")
            .located(By.id("makePaymentButton"));
    public static Target PHONE_FIELD = Target.the("Phone field")
            .located(By.id("phoneTextField"));
    public static Target NAME_FIELD = Target.the("Name field")
            .located(By.id("nameTextField"));
    public static Target AMOUNT_BAR = Target.the("Amount bar")
            .located(By.id("amount"));
    public static Target COUNTRY_FIELD = Target.the("Country field")
            .located(By.id("countryTextField"));
    public static Target COUNTRY_BUTTON = Target.the("Select country button")
            .located(By.id("countryButton"));
    public static Target SENDPAYMENT_BUTTON = Target.the("Send payment button")
            .located(By.id("sendPaymentButton"));
    public static Target ACCEPT_BUTTON = Target.the("Accept payment button")
            .located(By.id("android:id/button1"));
    public static Target NOTACCEPT_BUTTON = Target.the("Don't accept button")
            .located(By.id("android:id/button2"));
    public static Target CANCEL_BUTTON = Target.the("Cancel button")
            .located(By.id("cancelButton"));
}
