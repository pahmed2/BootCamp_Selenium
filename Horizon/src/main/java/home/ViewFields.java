package home;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class ViewFields extends CommonAPI {
    @FindBy(xpath = "//*[@id=\"ddSearchType\"]")
    WebElement dropdownOptions;
    @FindBy(xpath = "//*[@id=\"Physician-County\"]")
    WebElement countyOptions;

    //TC-TS1-001
    public void geturl() {
        System.out.println(getCurrentPageTitle());
    }

    //TC-TS1-002 verify click banner image
    public void pageBanner() {
        clickByCss("#azulBanner");
    }

    //TC-TS1-003 verify Home tab
    public void homeTab() {
        clickByXpath(".//*[@id='nav']/li[1]/a");
    }

    //TC-TS1-004 Navigate ‘our Plans’ from homepage.
    public void navigateToOurPlans() {
        clickByClassName("link3");
        clickByXpath(".//*[@id='nav']/li[1]/a");
    }

    //TC-TS1-005  Navigate ‘Members Support’ from homepage.
    public void navigateToMembersSupport() {
        clickByClassName("link5");
        clickByXpath(".//*[@id='nav']/li[1]/a");
    }

    //TC-TS1-006   Navigate ‘For Providers’ from homepage.
    public void navigateToForProviders() {
        clickByClassName("link6");
        clickByXpath(".//*[@id='nav']/li[1]/a");
    }

    //TC-TS1-007 Check logo
    public void checkLogo() {
        clickByCss("#logo");
    }

    //TC-TS1-008 Navigate ‘Contact Us by Email’ homepage.
    public void navigateToContactUsByEmail() {
        clickByCss(".emailLink");
        clickByXpath(".//*[@id='nav']/li[1]/a");
    }

    //TC-TS1-009 Verify link ‘read more’ under Recent News.
    public void linkReadMore() {
        clickByCss(".bold");
        clickByXpath(".//*[@id='nav']/li[1]/a");
    }

    //TC-TS1-010:Verify user able to click on link ‘back to top’
    public void linkBackToTop() {
        clickByCss(".arrowTop");
    }

    //TC-TS2-011: Verify Horizon page options
    public void horizonpage() {
        clickByXpath(".//*[@id='nav']/li[2]/a");
    }

    //TC-TS2-012:  View Provider Network page.
    public void providerNetwork() {
        clickByXpath(".//*[@id='nav']/li[2]/a");
        clickByXpath("html/body/div[2]/div[1]/div[5]/ul/li[2]/a");
    }

    //TC-TS2-013 Verify image under Provider Network page
    public void imageInProviderNetwork() {
        clickByXpath(".//*[@id='nav']/li[2]/a");
        clickByXpath("html/body/div[2]/div[1]/div[5]/ul/li[2]/a");
        clickByCss("#font>a>img");
    }

    //TC-TS2-014 Search the Provider Directory
    public void searchProviderDirectory() {
        clickByXpath(".//*[@id='nav']/li[2]/a");
        clickByXpath("html/body/div[2]/div[1]/div[5]/ul/li[2]/a");
        clickByXpath(".//*[@id='font']/ul/li/a/span");
    }

    //TC_TS2_015: Verify System displays Provider Location
    public void providerLocation() {
        searchProviderDirectory();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        PageFactory.initElements(driver, this);
        clickByXpath("//*[@id=\"ddSearchType\"]");
        selectOptionByVisibleText(dropdownOptions, "Physicians");
        clickByXpath("//*[@id=\"PlanType\"]/option[2]");
        typeByXpath("//*[@id=\"Physician-txtZip\"]", "07801");
        selectOptionByVisibleText(countyOptions, "Morris, NJ");
    }
}
