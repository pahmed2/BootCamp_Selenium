package homepage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUrlValidity extends UrlValidity {
    @Test
    public void testUrlValidity01 () {
        String actualUrl = UrlValidity();
        String expectedUrl = "metlife.com";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test
    public void testUrlValidity02 () {
        boolean status = MetLifeLogo();
        Assert.assertTrue(status);
    }
}
