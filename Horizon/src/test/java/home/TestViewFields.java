package home;

import org.testng.annotations.Test;

public class TestViewFields extends ViewFields {
    @Test
    public void testViewFields01() {
        geturl();
    }

    @Test
    public void testViewFields02() {
        pageBanner();
    }

    @Test
    public void testViewFields03() {
        homeTab();
    }

    @Test
    public void testViewFields04() {
        navigateToOurPlans();
    }

    @Test
    public void testViewFields05() {
        navigateToMembersSupport();
    }

    @Test
    public void testViewFields06() {
        navigateToForProviders();
    }

    @Test
    public void testViewFields07() {
        checkLogo();
    }

    @Test
    public void testViewFields08() {
        navigateToContactUsByEmail();
    }

    @Test
    public void testViewFields09() {
        linkReadMore();
    }

    @Test
    public void testViewFields10() {
        linkBackToTop();
    }

    @Test(priority = 11)
    public void testHorizonPage11() {
        horizonpage();
    }

    @Test(priority = 12)
    public void testProviderNetwork12() {
        providerNetwork();
    }

    @Test(priority = 13)
    public void testImageProviderNetwork13() {
        imageInProviderNetwork();
    }

    @Test(priority = 14)
    public void testSearchProviderDirectory14() {
        searchProviderDirectory();
    }

    @Test(priority = 15)
    public void testProviderSearch15() {
        providerLocation();
    }
}
