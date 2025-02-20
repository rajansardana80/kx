package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
static ThreadLocal<WebDriver> threadLocal = new ThreadLocal();
 static WebDriver driver;

    public static void setDriver()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        threadLocal.set(driver);

    }

    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }

}
