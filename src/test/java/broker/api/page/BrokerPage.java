package broker.api.page;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.response.Response;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import io.restassured.path.json.*;

import io.cucumber.datatable.DataTable;

import com.jayway.jsonpath.DocumentContext;


public class BrokerPage {
    static String elementFromDataTable;
    static String valueFromDataTable;
    static Configuration configuration = null;
    static DocumentContext documentContext = null;
    static String finalJsonString;

    public static String getJsonString(String brokerUrl, String yamlFilePath, DataTable dataTable) {
        try {
            FileInputStream fileInputStream = new FileInputStream(yamlFilePath);
            Yaml yaml = new Yaml();

            Map<String, Object> objectMap = yaml.load(fileInputStream);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = null;


            jsonNode = objectMapper.readTree(new File("src/test/resources/broker/json/" + "ENGINE_USER_LOGIN" + ".json"));


            configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                    .mappingProvider(new JacksonMappingProvider()).build();
            for (int i = 0; i < dataTable.asMaps().size(); i++) {

                elementFromDataTable = dataTable.asMaps().get(i).get("Element");
                valueFromDataTable = dataTable.asMaps().get(i).get("Value");


                String valueFromYaml = (String) objectMap.get(elementFromDataTable);


                if (finalJsonString == null) {
                    documentContext = com.jayway.jsonpath.JsonPath.using(configuration).parse(jsonNode.toString());
                    finalJsonString = documentContext.set(valueFromYaml, valueFromDataTable).jsonString();
                } else {
                    documentContext = com.jayway.jsonpath.JsonPath.using(configuration).parse(finalJsonString);
                    finalJsonString = documentContext.set(valueFromYaml, valueFromDataTable).jsonString();
                }

            }
        } catch (Exception e) {

        }
        return finalJsonString;

    }


    public static String verifyResponse(DataTable dataTable, String responseValidationFile, Response response) {
        InputStream inputStream = null;
        String actualValueFromResponse = null;
        String valueFromYaml = null;
        String elementFromDataTable = null;
        try {
            inputStream = new FileInputStream(new File(responseValidationFile));
        } catch (Exception e) {
            e.getStackTrace();
        }

        Yaml yaml = new Yaml();
        Map<String, Object> dataFromYaml = yaml.load(inputStream);
        for (int i = 0; i < dataTable.asMaps().size(); i++) {
            elementFromDataTable = dataTable.asMaps().get(i).get("Element");
        }
        valueFromYaml = (String) dataFromYaml.get(elementFromDataTable);
        JsonPath jsonPath = response.jsonPath();
        actualValueFromResponse = jsonPath.get(valueFromYaml);
        return actualValueFromResponse;
    }
}
