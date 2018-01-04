package homepage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestValidateHomePage extends ValidateHomePage{
    // AMZ_TS1: Validate the homepage
    // AMZ_TS1_TC1: Amazon url is correct url
    @Test
    public void amzTS01TC01(){
        String expectedUrl = "amazon.com";
        Assert.assertTrue(isCorrectUrl().contains(expectedUrl));
        System.out.println("AMZ TS1 TC1 Passed");
    }
    // AMZ_TS1_TC2: Amazon logo link is visible
    @Test
    public void amzTS01TC02(){
        String expectedText = "Amazon";
        Assert.assertTrue(isLogoVisible().equals(expectedText));
        System.out.println("AMZ TS1 TC2 Passed");
    }
    // AMZ_TS1_TC3: Language is set to english
    @Test
    public void amzTS01TC03(){
        String expectedLang = "EN";
        Assert.assertTrue(isLangEng().equals(expectedLang));
        System.out.println("AMZ TS1 TC3 Passed");
    }
    // AMZ_TS1_TC4: Search box takes an input and shows search results
    @Test
    public void amzTS01TC04(){
        String expectedText = "results for \"Selenium books\"";
        Assert.assertTrue(isSearchBoxWorking().contains(expectedText));
        System.out.println("AMZ TS1 TC4 Passed");
    }
    // AMZ_TS1_TC5: Sign is button text is visible
    @Test
    public void amzTS01TC05(){
        String expectedText = "Sign in";
        Assert.assertTrue(isSigninVisible().contains(expectedText));
        System.out.println("AMZ TS1 TC5 Passed");
    }
    // AMZ_TS1_TC6: Sign in button text is clickable
    @Test
    public void amzTS01TC06() {
        String expectedText = "Email (phone for mobile accounts)";
        Assert.assertTrue(isSigninClickable().contains(expectedText));
        System.out.println("AMZ TS1 TC6 Passed");
    }
    // AMZ_TS1_TC7: Start here link is visible
    @Test
    public void amzTS01TC07(){
        String expectedText = "Start here.";
        Assert.assertTrue(isStartHereVisible().contains(expectedText));
        System.out.println("AMZ TS1 TC7 Passed");
    }
    // AMZ_TS1_TC8: Start here link is clickable
    @Test
    public void amzTS01TC08(){
        String expectedText = "Create account";
        Assert.assertTrue(isStartHereClickable().contains(expectedText));
        System.out.println("AMZ TS1 TC8 Passed");
    }
    // AMZ_TS1_TC9: Departments is visible
    @Test
    public void amzTS01TC09(){
        String expectedText = "Departments";
        Assert.assertTrue(isDeptVisible().contains(expectedText));
        System.out.println("AMZ TS1 TC9 Passed");
    }
    // AMZ_TS1_TC10: Get all search in items under All button
    @Test
    public void tS01TC10() throws InterruptedException {
        getAllItems();
        System.out.println("AMZ TS1 TC10 Passed");
    }
}
