package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonAPI {
    // CNN_TS1_TC1: Verify CNN url
    public String verifyCnnUrl() {
        String url = getCurrentPageUrl();
        return url;
    }

    // CNN_TS1_TC2: CNN LOGO LINK IS VISIBLE
    public String cnnLogo() {
        WebElement logo1 = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/a[1]"));
        String status = getCurrentPageUrl();
        return status;
    }
}