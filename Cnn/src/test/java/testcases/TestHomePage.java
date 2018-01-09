package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestHomePage extends HomePage {
    // CNN_TS1_TC1: Verify CNN url
    @Test
    public void cnnTS1TC01() {
        String actualUrl = verifyCnnUrl();
        String expectedUrl = "cnn.com";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        System.out.println("Test case 1 passed");
    }

    // CNN_TS1_TC2: CNN LOGO LINK IS VISIBLE
    @Test
    public void cnnTS1TC02() {
        String actual = cnnLogo();
        String expected = "cnn.com";
        Assert.assertTrue(actual.contains(actual));
        System.out.println("Test case 2 passed");
    }
}