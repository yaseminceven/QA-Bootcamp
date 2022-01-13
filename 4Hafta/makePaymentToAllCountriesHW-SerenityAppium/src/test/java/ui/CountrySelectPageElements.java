package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CountrySelectPageElements{
  public static Target COUNTRY_LIST = Target.the("Country List")
            .located(By.id("countryList"));
}


