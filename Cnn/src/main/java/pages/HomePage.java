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

    // CNN_TS1_TC2: CNN logo link is visible
    public String cnnLogo() throws InterruptedException {
        sleepFor(1);
        clickByXpath("//a[@id='logo']");
        sleepFor(1);
        String status = getCurrentPageUrl();
        return status;
    }

    // CNN_TS1_TC3: Language set in english
    public String isLanguageEnglish() throws InterruptedException {
        sleepFor(1);
        String language = getTextByXpath("//*[@id=\"nav\"]/div[2]/div[3]/div[1]");
        return language;
    }

    //CNN_TS1_TC4: US button is clickable
    public String isUSClickable() throws InterruptedException {
        sleepFor(1);
        clickByCss("#nav > div.nav__container > div.nav-menu-links > a:nth-child(1)");
        sleepFor(1);
        String result = getCurrentPageTitle();
        sleepFor(1);
        return result;
    }

    //CNN_TS1_TC5: World button is clickable
    public String isWorldClickable() throws InterruptedException {
        clickByCss("#nav > div.nav__container > div.nav-menu-links > a:nth-child(2)");
        sleepFor(1);
        String result = getCurrentPageTitle();
        sleepFor(1);
        return result;
    }

    //CNN_TS1_TC6: Politics button is clickable
    public String isPoliticsClickable() throws InterruptedException {
        clickByCss("#nav > div.nav__container > div.nav-menu-links > a:nth-child(3)");
        sleepFor(1);
        String result = getCurrentPageTitle();
        sleepFor(1);
        return result;
    }

    //CNN_TS1_TC7: Money button is clickable
    public String isMoneyClickable() throws InterruptedException {
        sleepFor(2);
        clickByXpath("//*[@id=\"nav\"]/div[2]/div[2]/a[4]");
        sleepFor(2);
        String result = getCurrentPageTitle();
        return result;
    }

    //CNN_TS1_TC8: Opinion button is clickable
    public String isOpinionClickable() throws InterruptedException {
        clickByCss("#nav > div.nav__container > div.nav-menu-links > a:nth-child(5)");
        sleepFor(1);
        String result = getCurrentPageTitle();
        sleepFor(1);
        return result;
    }

    //CNN_TS1_TC9: Health button is clickable
    public String isHealthClickable() throws InterruptedException {
        clickByCss("#nav > div.nav__container > div.nav-menu-links > a:nth-child(6)");
        sleepFor(1);
        String result = getCurrentPageTitle();
        sleepFor(1);
        return result;
    }

    //CNN_TS1_TC10: Tech button is clickable
    public String isTechClickable() throws InterruptedException {
        sleepFor(1);
        clickByCss("#nav > div.nav__container > div.nav-menu-links > a:nth-child(8)");
        sleepFor(1);
        String result = getCurrentPageTitle();
        return result;
    }
}
