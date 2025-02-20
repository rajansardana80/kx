package kx.ui.broker.pages;

import base.DriverFactory;

import core.CoreData;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

public class BrokerPage {

    public void initiateUrl()
    {
        DriverFactory.getDriver().get("https://broker.stage.klearnow.com/");
        CoreData.takescreenhot();

    }

    public void enterUserCredentials(DataTable dataTable)
    {

        String elementToLocate=dataTable.asMaps().get(0).get("Element");
        String elementValue=dataTable.asMaps().get(0).get("Value");
        CoreData.element(elementToLocate).sendKeys(elementValue);
    }
}
