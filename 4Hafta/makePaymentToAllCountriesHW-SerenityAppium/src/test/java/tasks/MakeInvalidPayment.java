package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakeInvalidPayment implements Task {
    private final String phone;
    private final String name;
    private final String amount;
    private final String country;


    public MakeInvalidPayment(String phone,String name, String amount, String country) {
        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.country = country;
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
                Enter.theValue(this.country).into(PaymentPageElements.COUNTRY_FIELD)
        );
    }

    public static MakeInvalidPayment pay(String phone,String name,String amount,String country){
        return instrumented(MakeInvalidPayment.class,phone,name,amount,country);
    }
}
