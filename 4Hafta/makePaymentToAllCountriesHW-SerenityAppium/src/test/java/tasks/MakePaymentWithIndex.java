package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.CountrySelectPageElements;
import ui.PaymentPageElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;

//class to make payment for each country based on index of the country element
public class MakePaymentWithIndex implements Task {
    private final String amount;
    private final String phone;
    private final String name;
    private final int index;

    public MakePaymentWithIndex(String amount, String phone, String name, int index) {
        this.amount = amount;
        this.phone = phone;
        this.name = name;
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaymentPageElements.PAYMENT_BUTTON, WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.PAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.PHONE_FIELD, WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.PHONE_FIELD),
                Enter.theValue(String.valueOf(this.phone)).into(PaymentPageElements.PHONE_FIELD),
                Click.on(PaymentPageElements.NAME_FIELD),
                Enter.theValue(this.name).into(PaymentPageElements.NAME_FIELD),
                Click.on(PaymentPageElements.AMOUNT_BAR),
                Enter.theValue(String.valueOf(this.amount)).into(PaymentPageElements.AMOUNT_BAR),
                Click.on(PaymentPageElements.COUNTRY_BUTTON),
                WaitUntil.the(CountrySelectPageElements.COUNTRY_LIST,WebElementStateMatchers.isVisible()),
                SelectCountry.select(index),
                Click.on(PaymentPageElements.SENDPAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.ACCEPT_BUTTON,WebElementStateMatchers.isClickable()),
                Click.on(PaymentPageElements.ACCEPT_BUTTON)
        );
    }


    public static MakePaymentWithIndex payOne(String amount, String phone, String name, int index) {
        return instrumented(MakePaymentWithIndex.class,amount,phone,name,index);
    }

}





