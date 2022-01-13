package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakePayment implements Task {
    private final String amount;
    private final String phone;
    private final String name;
    private final String country;

    public MakePayment(String amount, String phone, String name, String country) {
        this.amount = amount;
        this.phone = phone;
        this.name = name;
        this.country = country;
    }

    @Step("{0} make payment with '#amount'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaymentPageElements.PAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.PHONE_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.PHONE_FIELD),
                Enter.theValue(String.valueOf(this.phone)).into(PaymentPageElements.PHONE_FIELD),
                Click.on(PaymentPageElements.NAME_FIELD),
                Enter.theValue(this.name).into(PaymentPageElements.NAME_FIELD),
                Click.on(PaymentPageElements.AMOUNT_BAR),
                Enter.theValue(String.valueOf(this.amount)).into(PaymentPageElements.AMOUNT_BAR),
                Click.on(PaymentPageElements.COUNTRY_FIELD),
                Enter.theValue(this.country).into(PaymentPageElements.COUNTRY_FIELD),
                Click.on(PaymentPageElements.SENDPAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.ACCEPT_BUTTON,WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.ACCEPT_BUTTON)
        );
    }

    public static MakePayment pay(String amount, String phone, String name, String country){
        return instrumented(MakePayment.class,amount,phone,name,country);
    }
}
