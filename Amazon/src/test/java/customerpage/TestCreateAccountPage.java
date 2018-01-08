package customerpage;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class TestCreateAccountPage extends CreateAccountPage{

    // AMZ_TS2: Validate the create account page
    // AMZ_TS2_TC1: ‘Create account’ page url is correct
    @Test
    public void amzTS02TC01(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String expectedUrl = "amazon.com/ap/register";
        String actualUrl = isCorrectUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        System.out.println("AMZ TS2 TC1 Passed");
    }
    // AMZ_TS2_TC2: Page text ‘Create account’ is visible
    @Test
    public void amzTS02TC02(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String expectedText = "Create account";
        String actualText = isCreateAccVisible();
        Assert.assertTrue(actualText.equals(expectedText));
        System.out.println("AMZ TS2 TC2 Passed");
    }
    // AMZ_TS2_TC3: Your name field text is visible
    @Test
    public void amzTS02TC03(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String expectedText = "Your name";
        String actualText = isNameVisible();
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("AMZ TS2 TC3 Passed");
    }
    // AMZ_TS2_TC4: Your name text box is active and working
    @Test
    public void amzTS02TC04(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        boolean expectedStatus = isTextBoxActive();
        Assert.assertTrue(expectedStatus);
        System.out.println("AMZ TS2 TC4 Passed");
    }
    // AMZ_TS2_TC5: Email field is visible
    @Test
    public void amzTS02TC05(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String expectedText = "Email";
        String actualText = isEmailVisible();
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("AMZ TS2 TC5 Passed");
    }
    // AMZ_TS2_TC6: Email box is active and working
    @Test
    public void amzTS02TC06(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        boolean expectedStatus = isEmailBoxActive();
        Assert.assertTrue(expectedStatus);
        System.out.println("AMZ TS2 TC6 Passed");
    }
    // AMZ_TS2_TC7: Password text is visible
    @Test
    public void amzTS02TC07(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String expectedText = "Password";
        String actualText = isPasswordVisible();
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("AMZ TS2 TC7 Passed");
    }
    // AMZ_TS2_TC8: Password field is active and working
    @Test
    public void amzTS02TC08(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        boolean expectedStatus = isPasswordBoxActive();
        Assert.assertTrue(expectedStatus);
        System.out.println("AMZ TS2 TC8 Passed");
    }
    // AMZ_TS2_TC9: 'Create your Amazon account' is an active button
    @Test
    public void amzTS02TC09(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        boolean expectedStatus = isCreateAccountButtonActive();
        Assert.assertTrue(expectedStatus);
        System.out.println("AMZ TS2 TC9 Passed");
    }
    // AMZ_TS2_TC10: Error message is thrown if the required field is empty
    @Test
    public void amzTS02TC10(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getErrorMsg();
        System.out.println("AMZ TS2 TC10 Passed");
    }
}
