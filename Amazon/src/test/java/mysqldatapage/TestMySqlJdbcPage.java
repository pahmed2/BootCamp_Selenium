package mysqldatapage;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class TestMySqlJdbcPage extends MySqlJdbcPage {
    // AMZ_TS6: Use MySQl test data to search multiple items
    // AMZ_TS6_TC1: Search multiple items by name from a database table
    @Test
    public void amzTS06TC01() throws Exception {
        int i = 0;
        String tableName = "amz_dataset_01";
        String column1 = "actual";
        String column2 = "expected";
        List<String> actualItems = searchItemByName(tableName, column1);
        List<String> expectedItems = getAssretData(tableName, column2);
        for (String item : expectedItems) {
            Assert.assertTrue(actualItems.get(i).contains(item));
            System.out.println(item + ": Search - Passed");
            i++;
        }
        System.out.println("AMZ TS6 TC1 Passed");
    }
    // AMZ_TS6_TC2: Search multiple items by bar-code from a database table
    @Test
    public void amzTS06TC02() throws Exception {
        int i = 0;
        String tableName = "amz_dataset_02";
        String column1 = "actual";
        String column2 = "expected";
        List<String> actualItems = searchItemByBarCode(tableName, column1, column2);
        List<String> expectedItems = getAssretData(tableName, column2);
        for (String item : expectedItems) {
            Assert.assertTrue(actualItems.get(i).contains(item));
            System.out.println(item + ": Search - Passed");
            i++;
        }
        System.out.println("AMZ TS6 TC2 Passed");
    }
}
