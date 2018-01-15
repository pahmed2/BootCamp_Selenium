package searchpage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;

public class TestSearchPage extends SearchPage{
    @Test
    public void searchItemsTest() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        PageFactory.initElements(driver, SearchPage.class);
        searchItemsAndSubmitButton();
        sleepFor(1);
    }
}
