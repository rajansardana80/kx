package broker.api.stepdefination;

import broker.api.page.BrokerPage;
import broker.ui.stepdefination.BrokerStepDefination;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.io.File;


public class BrokerStepdefination {
    Logger logger = LogManager.getLogger(BrokerStepDefination.class);
    Response response = null;

    @Given("Broker hit {string} api")
    public void broker_hit_api(String name, DataTable dataTable) {
        File schemaFile = new File("src/test/resources/broker/responseschema/ENGINE_USER_LOGIN.json");
        String brokerUrl = "https://api.klearnow.com/stage-engine/v1/events";
        String yamlFilePath = "src/test/resources/broker/yml/RequestCreation/ENGINE_USER_LOGIN.yml";
        String jsonString = BrokerPage.getJsonString(brokerUrl, yamlFilePath, dataTable);
        System.out.println("json request body is :: " + jsonString);
        response = RestAssured.given().contentType("application/json").body(jsonString).post(brokerUrl);
        System.out.println("status code is :: " + response.getStatusCode());
        System.out.println("Response is :: " + response.getBody().asString());
        logger.info(Thread.currentThread().threadId() + " :: " + hook.base.getCurrentFeature() + " :: " + hook.base.getScenarioName() + " :: Response is received");
        JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchema(schemaFile);
        response.then().assertThat().body(validator);

    }

    @Then("Verify {string} response")
    public void verify_response(String name, DataTable dataTable) {
        String expectedResponseValue = null;
        String responseValidationFile = "src/test/resources/broker/yml/ResonseValidation/ENGINE_USER_LOGIN.yml";
        String actualResponseValue = BrokerPage.verifyResponse(dataTable, responseValidationFile, response);
        for (int i = 0; i < dataTable.asMaps().size(); i++) {
            expectedResponseValue = dataTable.asMaps().get(i).get("Element");
        }
        Assert.assertNotNull("Error : Value is null in response", actualResponseValue);



    }


}