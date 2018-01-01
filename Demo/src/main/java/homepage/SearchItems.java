package homepage;

import base.CommonAPI;

public class SearchItems extends CommonAPI{
    public void searchItems() throws InterruptedException {
        System.out.println(getCurrentPageTitle());
        typeByCss("#twotabsearchtextbox", "Java Books");
        clickByCss(".nav-input");
        clearInputFieldByCss("#twotabsearchtextbox");
        typeByCss("#twotabsearchtextbox", "Selenium Books");
        clickByCss(".nav-input");
        clearInputFieldByCss("#twotabsearchtextbox");
        System.out.println(getCurrentPageUrl());
        sleepFor(1);
    }
}
