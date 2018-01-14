package homepage;

import base.CommonAPI;

public class NavigateToPages extends CommonAPI {
    // click start here
    public void clickToGoStartHere(){
        clickByXpath("//div[@class='nav-signin-tooltip-footer']/a");
    }
    // click sign in
    public void clickToGoSignIn(){
        clickByCss("#nav-signin-tooltip");
    }
    // navigate to homepage
    public void navigateToHomePage(){
        driver.navigate().to("https://www.amazon.com/");
    }
}
