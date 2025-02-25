package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {
    private static final ThreadLocal<Scenario> scenarioThreadLocal = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario)
    {scenarioThreadLocal.set(scenario);
DriverFactory.setDriver();

    }

    public static Scenario getScenario() {
        return scenarioThreadLocal.get();
    }

    @After
    public void afterScenario()
    {
        if (getScenario().isFailed())
        {
            takescreenhot();
        }
                DriverFactory.getDriver().close();




    }

    public static void takescreenhot()  {
        final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        getScenario().attach(screenshot, "image/png", "screenshot");
    }
}
