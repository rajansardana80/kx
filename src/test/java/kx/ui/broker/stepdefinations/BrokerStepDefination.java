package kx.ui.broker.stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import pages.BrokerPage;


public class BrokerStepDefination {

BrokerPage brokerObj= new BrokerPage();
  Logger  logger = LogManager.getLogger(BrokerStepDefination.class);

        @Given("Launch the broker application")
        public void launch_the_broker_application() {
            brokerObj.initiateUrl();
            logger.info("Application is launched");
        }


    @When("User enters the below credentials")
    public void user_enters_the_below_credentials(DataTable dataTable) {
        brokerObj.enterUserCredentials(dataTable);
    }








}
