package broker.stepdefination;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import broker.page.BrokerPage;


public class BrokerStepDefination {

BrokerPage brokerObj= new BrokerPage();
  Logger  logger = LogManager.getLogger(BrokerStepDefination.class);

        @Given("Launch the broker application")
        public void launch_the_broker_application() {
            brokerObj.initiateUrl();
            logger.info(Thread.currentThread().threadId()+" :: "+hook.base.getCurrentFeature()+" :: "+ hook.base.getScenarioName() + " :: Application is launched");
        }


    @When("User enters the below credentials")
    public void user_enters_the_below_credentials(DataTable dataTable) {

            brokerObj.enterUserCredentials(dataTable);
        logger.info(Thread.currentThread().threadId()+" :: "+hook.base.getCurrentFeature()+" :: "+ hook.base.getScenarioName() + " :: User credentials entered on webpage");

    }








}
