package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        try {

            FileInputStream file =
                    new FileInputStream(
                            System.getProperty("user.dir")
                            + "/src/test/resources/config.properties");

            prop = new Properties();

            prop.load(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String getAppURL() {
        return prop.getProperty("appURL");
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
}