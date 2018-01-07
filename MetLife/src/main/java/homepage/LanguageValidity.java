package homepage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LanguageValidity extends CommonAPI{
    public String LanguageValidity () {
        WebElement englishLang = driver.findElement(By.xpath("//*[@id=\"countryNameSelected\"]"));
        String result = englishLang.getText();
        return result;
    }
}
