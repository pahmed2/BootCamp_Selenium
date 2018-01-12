package mysqldatapage;

import base.CommonAPI;
import utility.ConnectDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlJdbcPage extends CommonAPI{
    ConnectDB db = new ConnectDB();
    public List<String> getData(String tableName, String columnNamae) throws Exception {
        List<String> data = new ArrayList<String>();
        data = db.readDataBase(tableName, columnNamae);
        return data;
    }
    public List<String> getAssretData(String tableName, String columnNamae) throws Exception {
        List<String> data = new ArrayList<String>();
        data = db.readDataBase(tableName, columnNamae);
        return data;
    }
    // AMZ_TS6: Use MySQl test data to search multiple items
    // AMZ_TS6_TC1: Search multiple items by name from a database table
    public List<String> searchItemByName(String tableName, String columnName) throws Exception {
        List<String> values = getData(tableName, columnName);
        List<String> actual = new ArrayList<>();
        for (String value : values) {
            sleepFor(1);
            typeByIdNEnter("twotabsearchtextbox", value);
            sleepFor(1);
            actual.add(getCurrentPageTitle());
            clearInputFieldById("twotabsearchtextbox");
            sleepFor(1);
        }
        return actual;
    }
    // AMZ_TS6_TC2: Search multiple items by bar-code from a database table
    public List<String> searchItemByBarCode(String tableName, String column1, String column2) throws Exception {
        List<String> items = getData(tableName, column1);
        List<String> assertItems = getAssretData(tableName, column2);
        List<String> actual = new ArrayList<>();
        int i=0;
        for (String item : items) {
            sleepFor(3);
            typeByIdNEnter("twotabsearchtextbox", item);
            sleepFor(3);
            actual.add(getTextByXpath("//*[text()='"+assertItems.get(i)+"']"));
            clearInputFieldById("twotabsearchtextbox");
            sleepFor(3);
            i++;
        }
        return actual;
    }
}
