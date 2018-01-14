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
    public void signIn(){
        nav.navigateToHomePage();
        nav.clickToGoSignIn();
        typeByCss("#ap_email", "youremail@mail.com");
        typeByCss("#ap_password", "yourpassword");
        clickByCss("#signInSubmit");
    }
    public void registration(){
        nav.navigateToHomePage();
        nav.clickToGoStartHere();
        typeByCss("#ap_customer_name", "Your Name");
        typeByCss("#ap_email", "youremail@mail.com");
        typeByCss("#ap_password", "yourpassword");
        typeByCss("#ap_password_check", "yourpassword");
        clickByCss("#continue");
    }
    public void search() throws IOException {
        nav.navigateToHomePage();
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchItemsAndSubmitButton();
    }
    public void select(String featureName)throws IOException{
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
    public void selectFeatures()throws IOException{
        ItemsToBeSearched itemsToBeSearched = new ItemsToBeSearched();
        String [] testSteps = itemsToBeSearched.getDataFromExcelFileForFeaturesChoice();
        for(int i=0; i<testSteps.length; i++) {
            select(testSteps[i]);
        }
    }
}
