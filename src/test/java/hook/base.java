package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

    @Before
    public void beforeScenario()
    {

DriverFactory.setDriver();

    }

    @After
    public void afterScenario(Scenario scenario)
    {
                DriverFactory.getDriver().close();




    }
}
