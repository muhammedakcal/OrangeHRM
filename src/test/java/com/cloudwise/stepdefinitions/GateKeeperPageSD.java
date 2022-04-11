package com.cloudwise.stepdefinitions;

import com.cloudwise.pages.GatekeeperPage;
import com.cloudwise.utils.HelperMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GateKeeperPageSD {


    @Given("^GateKeeperPage: I see the text: \"([^\"]*)\" defined on page with title: \"([^\"]*)\"$")
    public void bddVerifyTextIsLocatedOnFieldPage(String text, String pageTitle) {
        assertEquals(HelperMethods.doGetPageTitle(), pageTitle);
        assertEquals(GatekeeperPage.getTextFromFieldInPage(text), text);
    }

    @Given("GateKeeperPage: I see the part of the text: \"([^\"]*)\" defined on page with title: \"([^\"]*)\"$")
    public void bddVerifyPartOfTextIsLocatedOnFieldPage(String text, String expectedText) {
        assertEquals(HelperMethods.doGetPageTitle(), expectedText);
        GatekeeperPage.verifyPartOfTextIsLocatedOnFieldPage(expectedText);
    }

    @And("^GateKeeperPage: I see the section: \"([^\"]*)\" defined on frame$")
    public void bddVerifySectionInFrame(String sectionName) {
        assertEquals(GatekeeperPage.getSectionNameInFrame(sectionName), sectionName);
    }

    @And("^GateKeeperPage: I see the section with name: \"([^\"]*)\"$")
    public void bddVerifyverifySectionName(String sectionName) {
        GatekeeperPage.verifySectionName(sectionName);
    }

    @And("^GateKeeperPage: I see the icon \"([^\"]*)\" on defined section: \"([^\"]*)\"$")
    public void bddverifyIconButtonOnDefinedSection(String iconName, String sectionName) {
        GatekeeperPage.verifyIconButtonOnDefinedSection(iconName,sectionName);
    }


    @And("^GateKeeperPage: I see the text: \"([^\"]*)\" defined on frame$")
    public void bddVerifyTextFieldInFrame(String field) {
        assertEquals(GatekeeperPage.getTextFromFieldFromFrame(field), field);
    }

    @And("^GateKeeperPage: I switch to frame: \"([^\"]*)\"$")
    public void bddSwitchFrame(String frame) {
        GatekeeperPage.switchFrame(frame);
    }


    @When("^GateKeeperPage: I click on popup: \"([^\"]*)\"$")
    public void bddClickOnPopup(String popupName) {
        GatekeeperPage.clickOnPopup(popupName);
    }

    @Then("GateKeeperPage: I see {int} thermal exhaust ports in the main port")
    public void bddVerifyNumberOfPorts(int portNumber) {
        GatekeeperPage.verifyNumberOfPorts(portNumber);

    }

    @And("^GateKeeperPage: I defeat the cost in the thermal exhaust port$")
    public void bddDefeatCostInTheThermalExhaustPort() {
        GatekeeperPage.defeatCostInTheThermalExhaustPort();
    }


    @And("^GateKeeperPage: I check the cost's size with the following information: Weight: \"([^\"]*)\", Height: \"([^\"]*)\"")
    public void bddvVerifyCostSize(String width, String height) {
        GatekeeperPage.verifyPortsSize(width, height);
    }

    @And("GateKeeperPage: I defeat the cost for {int} times, and print out the ports information")
    public void bddDefeatCostNumberOfTimesAndStoreInfoToTheList(int times) {
        GatekeeperPage.defeatCostNumberOfTimesAndStoreInfoToTheList(times);

    }
    @And("^GateKeeperPage: I enter incorrect information with following data, and verify if the unicorn is not visible$")
    public void bddSearchUnicornWithInvalidData(DataTable dataTable) {
        List<Map<String, String>> searchList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> field : searchList) {
              GatekeeperPage.searchUnicornWithInvalidData(field.get("Unicorn_Name"));
        }}

    @And("^GateKeeperPage: I enter the search data: \"([^\"]*)\", and verify if the unicorn is visible with text: \"([^\"]*)\"$")
    public void bddSearchUnicornWithValidData(String searchData, String searchResultExpectation) {
        GatekeeperPage.searchValidUnicornWithInvalidData(searchData , searchResultExpectation);
    }
    @And("^GateKeeperPage: I fill the input fields and assert number to verify if the results are correct;$")
    public void bddFillAndAssertNumbers(DataTable dataTable) {

        List<Map<String, String>> setInputList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> field : setInputList) {
            GatekeeperPage.fillValueToFirstInput(field.get("First_Input"));
            GatekeeperPage.fillValueToSecondInput(field.get("Second_Input"));
            GatekeeperPage.assertValueInThirdInput(field.get("Third_Input"));
        }}
    }

