package searchpage;

import base.CommonAPI;
import utility.DataReader;
import java.io.IOException;

public class ItemsToBeSearched extends CommonAPI{
    DataReader dr = new DataReader();
    public String[] getDataFromExcelFile() throws IOException, InterruptedException {
        String path = System.getProperty("user.dir")+"/data/SearchItemByName.xls";
        String [] data = dr.colReader(path,2);
        sleepFor(2);
        return data;
    }
    public String[] getDataFromExcelFileForFeaturesChoice() throws IOException, InterruptedException {
        String path = System.getProperty("user.dir")+"/data/Features.xls";
        String [] data = dr.colReader(path,2);
        sleepFor(2);
        return data;
    }
}
