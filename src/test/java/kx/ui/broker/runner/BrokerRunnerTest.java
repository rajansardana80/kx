package kx.ui.broker.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/kx/ui/broker/features/login.feature"},

        glue = {"kx/ui/broker/stepdefinations","hook"}, plugin = {"pretty", "json:target/cucumber-reports/cucumber.json" ,"rerun:target/rerun.txt"},tags = "@Automated",monochrome = true )
public class BrokerRunnerTest {


}
