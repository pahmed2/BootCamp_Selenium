package home;

import base.CommonAPI;

public class ViewFields extends CommonAPI {

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

}
