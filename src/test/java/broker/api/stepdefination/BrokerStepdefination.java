package broker.api.stepdefination;

import broker.api.page.BrokerPage;
import broker.ui.stepdefination.BrokerStepDefination;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;


public class BrokerStepdefination {
    Logger logger = LogManager.getLogger(BrokerStepDefination.class);


    @Given("Broker hit {string} api")
    public void broker_hit_api(String string, DataTable dataTable) {
        File schemaFile = new File("src/test/resources/broker/responseschema/ENGINE_USER_LOGIN.json");
        String brokerUrl = "https://api.klearnow.com/stage-engine/v1/events";
        String yamlFilePath = "src/test/resources/broker/yml/ENGINE_USER_LOGIN.yml";
        String jsonString = BrokerPage.getJsonString(brokerUrl, yamlFilePath, dataTable);
        System.out.println("json request body is :: " + jsonString);
        Response response = RestAssured.given().contentType("application/json").body(jsonString).post(brokerUrl);
        System.out.println("status code is :: " + response.getStatusCode());
        System.out.println("Response is :: " + response.getBody().asString());
        logger.info(Thread.currentThread().threadId()+" :: "+hook.base.getCurrentFeature()+" :: "+ hook.base.getScenarioName() + " :: Response is received");
        JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchema(schemaFile);
		response.then().assertThat().body(validator);

    }
}