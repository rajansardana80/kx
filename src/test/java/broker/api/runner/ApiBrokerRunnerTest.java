package broker.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/broker/api/feature"},

        glue = {"broker/api/stepdefination","hook"}, plugin = {"pretty", "json:target/cucumber-reports/cucumber.json" ,"rerun:target/rerun.txt"},tags = "@Automated",monochrome = true )
public class ApiBrokerRunnerTest {


}
