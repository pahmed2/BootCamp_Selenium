package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestHomePage extends HomePage {
    // CNN_TS1_TC1: Verify CNN url
    @Test(enabled = true)
    public void cnnTS1TC01() {
        String actualUrl = verifyCnnUrl();
        String expectedUrl = "cnn.com";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        System.out.println("Test Case 1 Passed");
    }

    // CNN_TS1_TC2: CNN LOGO LINK IS VISIBLE
    @Test(enabled = true)
    public void cnnTS1TC02() {
        String actual = cnnLogo();
        String expected = "cnn.com";
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 2 Passed");
    }

    // CNN_TS1_TC3: Language set in english
    @Test(enabled = true)
    public void cnnTS1TC03() throws InterruptedException {
        String expectedLang = "U.S. Edition";
        String actual = isLanguageEnglish();
        Assert.assertTrue(actual.contains(expectedLang));
        System.out.println("Test Case 3 Passed");
    }

    // CNN_TS1_TC4: US button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC04() throws InterruptedException {
        String expected = "U.S. News";
        String actual = isUSClickable();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 4 Passed");
    }

    // CNN_TS1_TC5: World button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC05() throws InterruptedException {
        String expected = "World";
        String actual = isWorldClickable();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 5 Passed");
    }

    // CNN_TS1_TC6: Politics button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC06() throws InterruptedException {
        String expected = "Politics";
        String actual = isPoliticsClickable();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 6 Passed");
    }

    // CNN_TS1_TC7: Money button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC07() throws InterruptedException {
        String expected = "CNNMoney";
        String actual = isMoneyClickable();
        System.out.println("actual:" + actual);
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 7 Passed");
    }

    // CNN_TS1_TC8: Opinion button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC08() throws InterruptedException {
        String expected = "Opinion,";
        String actual = isOpinionClickable();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 8 Passed");
    }

    // CNN_TS1_TC9: Health button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC09() throws InterruptedException {
        String expected = "Health";
        String actual = isHealthClickable();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 9 Passed");
    }

    // CNN_TS1_TC10: Tech button is Clickable
    @Test(enabled = true)
    public void cnnTS1TC10() throws InterruptedException {
        String expected = "Tech";
        String actual = isTechClickable();
        Assert.assertTrue(actual.contains(expected));
        System.out.println("Test Case 10 Passed");
    }
}
