package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class base {
    private static final ThreadLocal<Scenario> scenarioThreadLocal = new ThreadLocal<>();
    private static String currentFeature;



    @Before
    public void beforeScenario(Scenario scenario)
    {
        String featurePath = scenario.getUri().toString();
        currentFeature = featurePath.substring(featurePath.lastIndexOf("/") + 1);
        System.out.println("Running Feature: " + currentFeature);


        scenarioThreadLocal.set(scenario);
DriverFactory.setDriver();

    }

    public static Scenario getScenario() {
        return scenarioThreadLocal.get();
    }

    public static String getScenarioName() {
        return getScenario().getName();
    }

    @After
    public void afterScenario(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            takescreenhot();
        }
                DriverFactory.getDriver().close();




    }

    public static String getCurrentFeature() {
        return currentFeature;
    }

    public static void takescreenhot()  {
        final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        getScenario().attach(screenshot, "image/png", "screenshot");
    }
}
