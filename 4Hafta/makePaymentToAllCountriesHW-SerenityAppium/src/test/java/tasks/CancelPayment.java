package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CancelPayment implements Task {
    private final String name;
    private final String phone;
    private final String country;
    private final String amount;

    public CancelPayment(String name, String phone, String country, String amount) {
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaymentPageElements.PAYMENT_BUTTON, WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.PAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.PHONE_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.PHONE_FIELD),
                Enter.theValue(this.phone).into(PaymentPageElements.PHONE_FIELD),
                Click.on(PaymentPageElements.NAME_FIELD),
                Enter.theValue(this.name).into(PaymentPageElements.NAME_FIELD),
                Click.on(PaymentPageElements.AMOUNT_BAR),
                Enter.theValue(this.amount).into(PaymentPageElements.AMOUNT_BAR),
                Click.on(PaymentPageElements.COUNTRY_FIELD),
                Enter.theValue(this.country).into(PaymentPageElements.COUNTRY_FIELD),
                Click.on(PaymentPageElements.SENDPAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.NOTACCEPT_BUTTON,WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.NOTACCEPT_BUTTON),
                WaitUntil.the(PaymentPageElements.CANCEL_BUTTON,WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.CANCEL_BUTTON)
        );
    }

    public static CancelPayment cancel(String name,String phone,String country,String amount){
        return instrumented(CancelPayment.class,name,phone,country,amount);
    }
}
