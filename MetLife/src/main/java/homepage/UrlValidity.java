package homepage;

import base.CommonAPI;
import org.openqa.selenium.By;

public class UrlValidity extends CommonAPI{
    public String UrlValidity() {
       String url = getCurrentPageUrl();
        return url;
    }

    public boolean MetLifeLogo () {
       boolean status = driver.findElement(By.xpath("//div[1]/div[2]/a/img")).isEnabled();
        return status;
    }
}




