package core;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectParser {
    static Logger logger = LogManager.getLogger(ObjectParser.class);

    public static By readData(String elementToLocate) {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("src/test/resources/PageObjects.properties");

        } catch (FileNotFoundException e) {
            logger.error("File not found");
        }
        Properties prop = new Properties();

        try {
            prop.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File not found");
        }

        String locatorProperty=prop.getProperty(elementToLocate);
        String locatorName=locatorProperty.split(":")[0];
        String locatorValue=locatorProperty.split(":")[1];

        By locator= null;
        switch (locatorName) {
            case "id": {
                locator= By.id(locatorValue);
                break;

            }
            case "name": {
                locator = By.name(locatorValue);
                break;
            }

            default:
                break;
        }
        return locator;
}

}
