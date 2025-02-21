package core;

import base.DriverFactory;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


public class CoreData {
   static  Logger logger = LogManager.getLogger(CoreData.class);
    static Scenario scenario;
    public static WebElement element(String elementToLocate) {
        WebElement element = DriverFactory.getDriver().findElement(ObjectParser.readData(elementToLocate));
        return element;
    }


    }


