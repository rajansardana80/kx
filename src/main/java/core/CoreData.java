package core;

import base.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CoreData {
   static  Logger logger = LogManager.getLogger(CoreData.class);

    public static WebElement element(String elementToLocate) {
        WebElement element = DriverFactory.getDriver().findElement(ObjectParser.readData(elementToLocate));
        return element;
    }

    public static void takescreenhot()  {
        try {
            //Use TakesScreenshot method to capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
//Saving the screenshot in desired location
            File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
            FileUtils.copyFile(source, new File("target/SeleniumScreenshots/Screen.png"));
        }catch (IOException e)
        {

                e.printStackTrace();
                logger.error("File not found");


        }
    }

}
