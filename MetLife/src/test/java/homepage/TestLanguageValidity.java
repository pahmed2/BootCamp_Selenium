package homepage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLanguageValidity extends LanguageValidity{
    @Test
    public void languageTest01 () {
        String actualCountry = LanguageValidity();
        String expectedCountry = "USA";
        Assert.assertTrue(actualCountry.equals(expectedCountry));
    }
}
