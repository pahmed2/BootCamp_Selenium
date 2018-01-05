package customerpage;

import base.CommonAPI;
import homepage.NavigateToPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountPage extends CommonAPI {

    NavigateToPages navi = new NavigateToPages();

    @FindBy(name = "customerName")
    WebElement yourName;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(className = "a-button-input")
    WebElement createAccount;
    @FindBy(xpath = "//*[@id=\"auth-customerName-missing-alert\"]/div/div")
    WebElement err1;
    @FindBy(xpath = "//*[@id=\"auth-email-missing-alert\"]/div/div")
    WebElement err2;
    @FindBy(xpath = "//*[@id=\"auth-password-missing-alert\"]/div/div")
    WebElement err3;


    // AMZ_TS2: Validate the create account page
    // AMZ_TS2_TC1: ‘Create account’ page url is correct
    public String isCorrectUrl() {
        navi.clickToGoStartHere();
        String url = getCurrentPageUrl();
        return url;
    }
    public String isCorrectTitle() {
        navi.clickToGoStartHere();
        String title = getCurrentPageTitle();
        return title;
    }
    // AMZ_TS2_TC2: Page text ‘Create account’ is visible
    public String isCreateAccVisible() {
        navi.clickToGoStartHere();
        String text = getTextByClassName("a-spacing-small");
        return text;
    }
    // AMZ_TS2_TC3: Your name field text is visible
    public String isNameVisible() {
        navi.clickToGoStartHere();
        String name = getTextByXpath("//label[contains(text(),'Your name')]");
        return name;
    }
    // AMZ_TS2_TC4: Your name text box is active and working
    public boolean isTextBoxActive() {
        navi.clickToGoStartHere();
        PageFactory.initElements(driver, this);
        boolean status = yourName.isEnabled();
        return status;
    }
    // AMZ_TS2_TC5: Email field is visible
    public String isEmailVisible() {
        navi.clickToGoStartHere();
        String email = getTextByXpath("//label[contains(text(),'Email')]");
        return email;
    }
    // AMZ_TS2_TC6: Email box is active and working
    public boolean isEmailBoxActive() {
        navi.clickToGoStartHere();
        PageFactory.initElements(driver, this);
        boolean status = email.isEnabled();
        return status;
    }
    // AMZ_TS2_TC7: Password text is visible
    public String isPasswordVisible() {
        navi.clickToGoStartHere();
        String password = getTextByXpath("//label[contains(text(),'Password')]");
        return password;
    }
    // AMZ_TS2_TC8: Password field is active and working
    public boolean isPasswordBoxActive() {
        navi.clickToGoStartHere();
        PageFactory.initElements(driver, this);
        boolean status = password.isEnabled();
        return status;
    }
    // AMZ_TS2_TC9: Create your Amazon account is an active button
    public boolean isCreateAccountButtonActive() {
        navi.clickToGoStartHere();
        PageFactory.initElements(driver, this);
        boolean status = createAccount.isEnabled();
        return status;
    }
    // AMZ_TS2_TC10: Error message is thrown if the required field is empty
    public void getErrorMsg() {
        navi.clickToGoStartHere();
        PageFactory.initElements(driver, this);
        createAccount.click();
        String e1 = err1.getText();
        String e2 = err2.getText();
        String e3 = err3.getText();
        List<String> errorMsgs = new ArrayList<>();
        errorMsgs.add(e1);
        errorMsgs.add(e2);
        errorMsgs.add(e3);
        for (String st : errorMsgs) {
            System.out.println(st);
        }
    }
}
