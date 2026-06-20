package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getLoginData() throws IOException {

        String filePath =
                System.getProperty("user.dir")
                + "/src/test/resources/LoginData.xlsx";

        return ExcelUtility.getData(filePath, "Login");
    }
}