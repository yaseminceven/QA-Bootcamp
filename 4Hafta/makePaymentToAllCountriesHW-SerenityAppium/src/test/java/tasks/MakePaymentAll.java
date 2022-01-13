package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

//class to make payment for all countries
public class MakePaymentAll implements Task {
    private final String amount;
    private final String phone;
    private final String name;
    private final int[] index= {1,2,3,4,5,6,7,8,9,10,11,12};
    private final int[] index2 = {8,9,10,11};

    public MakePaymentAll(String amount, String phone, String name) {
        this.amount = amount;
        this.phone = phone;
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //from India to Japan
        for (int idx: index) {
            actor.attemptsTo(
                    MakePaymentWithIndex.payOne(amount, phone, name, idx)
            );
        }

        //from France to Canada
        for (int idx2: index2) {
            actor.attemptsTo(
                    MakePaymentWithIndex2.payOne2(amount,phone,name,idx2)
            );
        }
    }

    public static MakePaymentAll pay(String amount, String phone, String name) {
        return instrumented(MakePaymentAll.class,amount,phone,name);
    }

}
