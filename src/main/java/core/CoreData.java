package core;

import base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.Properties;

public class CoreData {

    public static WebElement element(String elementToLocate)
    {
        WebElement element =DriverFactory.getDriver().findElement(ObjectParser.readData(elementToLocate));
        return element;
    }

    public static  void takescreenhot()
    {
        File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);    }
}
