package datasearchpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.TestLogger;
import java.io.IOException;

public class TestItemSearchPage extends ItemSearchPage {
    // AMZ_TS4: Use test data to search multiple items
    // AMZ_TS4_TC1: Search multiple items by name from a xls file
    @Test
    public void amzTS04TC01() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String[] expectedItems = getAssretData("SearchItemByName.xls");
        String[] actualItems = searchItemByName("SearchItemByName.xls");
        for (int i=0; i<actualItems.length; i++){
            Assert.assertTrue(actualItems[i].contains(expectedItems[i]));
            System.out.println(expectedItems[i] + ": Search - Passed");
        }
        System.out.println("AMZ TS4 TC1 Passed");
    }
    // AMZ_TS4_TC2:  Search multiple items by bar-code from a xls file
    @Test
    public void amzTS04TC02() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String[] expectedItems = getAssretData("SearchItemByBarCode.xls");
        String[] actualItems = searchItemByBarCode("SearchItemByBarCode.xls");
        for (int i=0; i<actualItems.length; i++){
            Assert.assertTrue(actualItems[i].contains(expectedItems[i]));
            System.out.println(expectedItems[i] + ": Search - Passed");
        }
        System.out.println("AMZ TS4 TC2 Passed");
    }
}
