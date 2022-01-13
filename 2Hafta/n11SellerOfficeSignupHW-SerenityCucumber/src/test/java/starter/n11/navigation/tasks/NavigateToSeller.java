package starter.n11.navigation.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.n11.navigation.user_interface.n11SellerPage;

public class NavigateToSeller {
    public static Performable theN11SellerPage() {
        return Task.where("{0} opens the n11 seller page",
                Open.browserOn().the(n11SellerPage.class));
    }
}
