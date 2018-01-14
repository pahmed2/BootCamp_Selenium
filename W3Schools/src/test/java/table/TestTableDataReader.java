package table;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTableDataReader extends TableDataReader{
    @Test
    public void read(){
        String actual = readData();
        Assert.assertTrue(actual.contains("Svendson"));
        System.out.println("TS1 Passed");
    }
}
