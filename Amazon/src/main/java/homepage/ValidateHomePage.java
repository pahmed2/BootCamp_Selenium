package homepage;

import base.CommonAPI;

import java.util.List;

public class ValidateHomePage extends CommonAPI{
    // AMZ_TS1: Validate the homepage
    // AMZ_TS1_TC1:  Amazon url is correct url
    public String isCorrectUrl(){
        String actualUrl = getCurrentPageUrl();
        return actualUrl;
    }
    // AMZ_TS1_TC2: Amazon logo link is visible
    public String isLogoVisible(){
        String text = getTextByClassName("nav-logo-link");
        return text;
    }
    // AMZ_TS1_TC3: Language is set to english
    public String isLangEng(){
        String language = getTextByCss(".icp-nav-language");
        return language;
    }
    // AMZ_TS1_TC4: Search box takes an input and shows search results
    public String isSearchBoxWorking(){
        String result = "";
        typeByIdNEnter("twotabsearchtextbox", "Selenium books");
        result = getTextByClassName("s-first-column");
        return result;
    }
    // AMZ_TS1_TC5: Sign is button text is visible
    public String isSigninVisible(){
        String result = getTextByCss("#nav-signin-tooltip");
        return result;
    }
    // AMZ_TS1_TC6: Sign in button text is clickable
    public String isSigninClickable() {
        String result = "";
        clickByCss("#nav-signin-tooltip");
        result = getTextByCss(".a-form-label");
        return result;
    }
    // AMZ_TS1_TC7: Start here link is visible
    public String isStartHereVisible(){
        String result = "";
        result = getTextByXpath("//div[@class='nav-signin-tooltip-footer']/a");
        return result;
    }
    // AMZ_TS1_TC8: Start here link is clickable
    public String isStartHereClickable(){
        String result = "";
        clickByXpath("//div[@class='nav-signin-tooltip-footer']/a");
        result = getTextByTagName("h1");
        return result;
    }
    // AMZ_TS1_TC9: Departments is visible
    public String isDeptVisible(){
        String result = "";
        result = getTextById("nav-shop");
        return result;
    }
    // AMZ_TS1_TC10: Get all search in items under All button
    public void getAllItems() throws InterruptedException {
        List<String> allText = getTextFromWebElementsById("searchDropdownBox");
        for (String st: allText){
            System.out.println(st);
        }
    }
}
