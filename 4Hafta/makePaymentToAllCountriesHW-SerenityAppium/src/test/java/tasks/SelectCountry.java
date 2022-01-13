package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectCountry implements Task {
    private final int index;
    WebElement countryElement;

    public SelectCountry(int index) {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        countryElement = getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
                "android.widget.ListView/android.widget.TextView[" + index + "]"));
        countryElement.click();
    }

    public static SelectCountry select(int index){
        return instrumented(SelectCountry.class,index);
    }
}


/*
public void selectCountry(String country) {
        if (deviceInfo.equals(DeviceType.ANDROID)) {
        int count = countryList.size();
        staticWait(1000);
        for (int i = 1; i < count; i++) {
        WebElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/" +
        "android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
        "android.widget.ListView/android.widget.TextView[" + i + "]"));
        if (element.getText().equals(country)) {
        element.click();
        break;
        }
        }

 */