package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.PaymentPageElements;

public class SendPayment implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return PaymentPageElements.SENDPAYMENT_BUTTON.resolveFor(actor).isClickable();
    }

    public static SendPayment send(){
        return new SendPayment();
    }
}
