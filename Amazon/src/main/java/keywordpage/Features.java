package keywordpage;

import base.CommonAPI;
import homepage.NavigateToPages;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.PageFactory;
import searchpage.ItemsToBeSearched;
import searchpage.SearchPage;
import java.io.IOException;

public class Features extends CommonAPI {
    NavigateToPages nav = new NavigateToPages();
    public void signIn() throws InterruptedException {
        nav.navigateToHomePage();
        nav.clickToGoSignIn();
        sleepFor(1);
        typeByCss("#ap_email", "youremail@mail.com");
        typeByCss("#ap_password", "yourpassword");
        sleepFor(1);
        clickByCss("#signInSubmit");
    }
    public void registration() throws InterruptedException {
        nav.navigateToHomePage();
        nav.clickToGoStartHere();
        sleepFor(1);
        typeByCss("#ap_customer_name", "Your Name");
        typeByCss("#ap_email", "youremail@mail.com");
        typeByCss("#ap_password", "yourpassword");
        typeByCss("#ap_password_check", "yourpassword");
        sleepFor(1);
        clickByCss("#continue");
    }
    public void search() throws IOException, InterruptedException {
        nav.navigateToHomePage();
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchItemsAndSubmitButton();
        sleepFor(1);
    }
    public void select(String featureName) throws IOException, InterruptedException {
        System.out.println("Feature: " + featureName);
        switch(featureName){
            case "signIn":
                signIn();
                break;
            case "registration":
                registration();
                break;
            case "search":
                search();
                break;
            default:
                throw new InvalidArgumentException("Invalid features choice");
        }
    }
    public void selectFeatures() throws IOException, InterruptedException {
        ItemsToBeSearched itemsToBeSearched = new ItemsToBeSearched();
        String [] testSteps = itemsToBeSearched.getDataFromExcelFileForFeaturesChoice();
        for(int i=0; i<testSteps.length; i++) {
            select(testSteps[i]);
            sleepFor(1);
        }
    }
}
