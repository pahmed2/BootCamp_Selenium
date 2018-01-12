package datasearchpage;

import base.CommonAPI;
import utility.DataReader;
import java.io.IOException;

public class ItemSearchPage extends CommonAPI {
    DataReader dtr = new DataReader();
    public String[] getData(String fileName) throws IOException {
        String path = "../Amazon/data/" + fileName;
        String [] output = dtr.colReader(path,2);
        return output;
    }
    public String[] getAssretData(String fileName) throws IOException {
        String path = "../Amazon/data/" + fileName;
        String [] output = dtr.colReader(path,3);
        return output;
    }
    // AMZ_TS4: Use test data to search multiple items
    // AMZ_TS4_TC1:  Search multiple items by name from a xls file
    public String[] searchItemByName(String fileName) throws IOException, InterruptedException {
        String[] items = getData(fileName);
        String[] actual = new String[items.length];
        for (int i=0; i<items.length; i++){
            sleepFor(1);
            typeByIdNEnter("twotabsearchtextbox", items[i]);
            sleepFor(1);
            actual[i] = getCurrentPageTitle();
            clearInputFieldById("twotabsearchtextbox");
            sleepFor(1);
        }
        return actual;
    }
    // AMZ_TS4_TC2:  Search multiple items by bar-code from a xls file
    public String[] searchItemByBarCode(String fileName) throws IOException, InterruptedException {
        String[] items = getData(fileName);
        String[] assertItems = getAssretData(fileName);
        String[] actual = new String[items.length];
        for (int i=0; i<items.length; i++){
            sleepFor(3);
            typeByIdNEnter("twotabsearchtextbox", items[i]);
            sleepFor(3);
            actual[i] = getTextByXpath("//*[text()='"+assertItems[i]+"']");
            clearInputFieldById("twotabsearchtextbox");
            sleepFor(3);
        }
        return actual;
    }
}
