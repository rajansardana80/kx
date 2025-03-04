package broker.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/rerun.txt"},

        glue = {"broker/stepdefination","hook"}, plugin = {"pretty", "json:target/cucumber-reports/cucumber-rerun.json" },tags = "@Automated",monochrome = true )
public class BrokerFailedRunnerTest {


}
