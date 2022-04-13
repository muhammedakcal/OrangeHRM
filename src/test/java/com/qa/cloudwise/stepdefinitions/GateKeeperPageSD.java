package com.qa.cloudwise.stepdefinitions;

import com.qa.cloudwise.pages.GateKeeperPage;
import com.qa.cloudwise.utils.HelperMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GateKeeperPageSD {

    /**
     * Get text from the field in the page and assert with the expected value
     *
     * @param text - text name
     */
    @Given("^GateKeeperPage: I see the text: \"([^\"]*)\" defined on page with title: \"([^\"]*)\"$")
    public void bddVerifyTextIsLocatedOnFieldPage(String text, String pageTitle) {
        assertEquals(HelperMethods.doGetPageTitle(), pageTitle);
        assertEquals(GateKeeperPage.getTextFromFieldInPage(text), text);
    }

    /**
     * Get text from the field in the page and assert with the expected  part of the text
     *
     * @param text - text name
     */
    @Given("GateKeeperPage: I see the part of the text: \"([^\"]*)\" defined on page with title: \"([^\"]*)\"$")
    public void bddVerifyPartOfTextIsLocatedOnFieldPage(String text, String expectedText) {
        assertEquals(HelperMethods.doGetPageTitle(), expectedText);
        GateKeeperPage.verifyPartOfTextIsLocatedOnFieldPage(expectedText);
    }

    /**
     * Get Section in Frame
     *
     * @param sectionName - Section name
     */
    @And("^GateKeeperPage: I see the section: \"([^\"]*)\" defined on frame$")
    public void bddVerifySectionInFrame(String sectionName) {
        assertEquals(GateKeeperPage.getSectionNameInFrame(sectionName), sectionName);
    }

    /**
     * Verify Section Name
     *
     * @param sectionName - Section Name
     */
    @And("^GateKeeperPage: I see the section with name: \"([^\"]*)\"$")
    public void bddVerifyverifySectionName(String sectionName) {
        GateKeeperPage.verifySectionName(sectionName);
    }

    /**
     * Verify Icon Button On Defined Section
     *
     * @param iconName    - Icon Name
     * @param sectionName - Section Name
     */
    @And("^GateKeeperPage: I see the icon \"([^\"]*)\" on defined section: \"([^\"]*)\"$")
    public void bddverifyIconButtonOnDefinedSection(String iconName, String sectionName) {
        GateKeeperPage.verifyIconButtonOnDefinedSection(iconName, sectionName);
    }

    /**
     * Verify Text in the frame
     *
     * @param field - text field
     * @return - text
     */
    @And("^GateKeeperPage: I see the text: \"([^\"]*)\" defined on frame$")
    public void bddVerifyTextFieldInFrame(String field) {
        assertEquals(GateKeeperPage.getTextFromFieldFromFrame(field), field);
    }

    /**
     * Switch Driver To Frame
     *
     * @param frame - frame name
     */
    @And("^GateKeeperPage: I switch to frame: \"([^\"]*)\"$")
    public void bddSwitchFrame(String frame) {
        GateKeeperPage.switchFrame(frame);
    }

    /**
     * Click on Pop-up
     *
     * @param popupName - Pop-up name
     */
    @When("^GateKeeperPage: I click on popup: \"([^\"]*)\"$")
    public void bddClickOnPopup(String popupName) {
        GateKeeperPage.clickOnPopup(popupName);
    }

    /**
     * Verify Number Of Ports
     *
     * @param portNumber - that wil be asserted to the actual number
     */
    @Then("GateKeeperPage: I see {int} thermal exhaust ports in the main port")
    public void bddVerifyNumberOfPorts(int portNumber) {
        GateKeeperPage.verifyNumberOfPorts(portNumber);

    }

    /**
     * Defeat/Click & Cost/Element which will be presented in the popup
     */
    @And("^GateKeeperPage: I defeat the cost in the thermal exhaust port$")
    public void bddDefeatCostInTheThermalExhaustPort() {
        GateKeeperPage.defeatCostInTheThermalExhaustPort();
    }

    /**
     * Verify  Port Size
     *
     * @param width  - width
     * @param height - height
     */
    @And("^GateKeeperPage: I check the cost's size with the following information: Weight: \"([^\"]*)\", Height: \"([^\"]*)\"")
    public void bddvVerifyCostSize(String width, String height) {
        GateKeeperPage.verifyPortsSize(width, height);
    }

    /**
     * Performance/ Functional Method to defeat cost as much as wanted in the function
     *
     * @param times - Number of times - that will be defeated cost
     */
    @And("GateKeeperPage: I defeat the cost for {int} times, and print out the ports information")
    public void bddDefeatCostNumberOfTimesAndStoreInfoToTheList(int times) {
        GateKeeperPage.defeatCostNumberOfTimesAndStoreInfoToTheList(times);

    }

    /**
     * Search unicorn with invalid data
     *
     * @param dataTable - it will be asserted to verify data the data is invalid
     */
    @And("^GateKeeperPage: I enter incorrect information with following data, and verify if the unicorn is not visible$")
    public void bddSearchUnicornWithInvalidData(DataTable dataTable) {
        List<Map<String, String>> searchList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> field : searchList) {
            GateKeeperPage.searchUnicornWithValidData(field.get("Unicorn_Name"));
        }
    }

    /**
     * Search unicorn with valid data
     *
     * @param searchData              - data that will be searched
     * @param searchResultExpectation - expected result
     */
    @And("^GateKeeperPage: I enter the search data: \"([^\"]*)\", and verify if the unicorn is visible with text: \"([^\"]*)\"$")
    public void bddSearchUnicornWithValidData(String searchData, String searchResultExpectation) {
        GateKeeperPage.searchUnicornWithInvalidData(searchData, searchResultExpectation);
    }

    /**
     * Mathematical Operation
     *
     * @param dataTable - First input, Second Input, Third Field Verify Result
     */
    @And("^GateKeeperPage: I fill the input fields and assert number to verify if the results are correct;$")
    public void bddFillAndAssertNumbers(DataTable dataTable) {
        List<Map<String, String>> setInputList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> field : setInputList) {
            GateKeeperPage.fillValueToFirstInput(field.get("First_Input"));
            GateKeeperPage.fillValueToSecondInput(field.get("Second_Input"));
            GateKeeperPage.assertValueInThirdInput(field.get("Third_Input"));
        }
    }

    /**
     * Mathematical Operation Performance Method
     *
     * @param numberOfData - Number of data which will be sent to the page
     * @param time         - It will be used to verify if numberOfData has been sent and verified before in defined time
     * @param sectionName  - Section Name
     */
    @And("GateKeeperPage: I execute a performance test by sending {int} different sorts of data and verifying the results in less than {int} minutes on defined section: {string}")
    public void bddrPerformanceTestOnCalculator(Integer numberOfData, Integer time, String sectionName) {
        GateKeeperPage.performanceTestFunctionOnCalculator(numberOfData, time, sectionName);

    }

}

