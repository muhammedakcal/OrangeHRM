package com.qa.stepdefinition;
import com.qa.pages.GateKeeperPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class GateKeeperPageSD {

    /**
     * Get text from the field in the page and assert with the expected value
     * @param expectedAddress - expected address which is located in the page
     */
    @Given("^GateKeeper: I extract and verify the address with text: \"([^\"]*)\"$")
    public void bddVerifyTextIsLocatedOnFieldPage(String expectedAddress) {
        Assert.assertEquals(expectedAddress ,GateKeeperPage.extractAddress());

    }

    /**
     * Verify Section Name
     * @param sectionName - Section Name
     */
    @And("^GateKeeper: I see the section with name: \"([^\"]*)\"$")
    public void bddVerifyverifySectionName(String sectionName) {GateKeeperPage.verifySectionName(sectionName);}

    /**
     * Verify Icon Button On Defined Section
     * @param iconName    - Icon Name
     * @param sectionName - Section Name
     */
    @And("^GateKeeper: I see the icon \"([^\"]*)\" on defined section: \"([^\"]*)\"$")
    public void bddverifyIconButtonOnDefinedSection(String iconName, String sectionName) {GateKeeperPage.verifyIconButtonOnDefinedSection(iconName, sectionName);}


    /**
     * Click on Pop-up
     * @param popupName - Pop-up name
     */
    @When("^GateKeeper: I click on popup: \"([^\"]*)\"$")
    public void bddClickOnPopup(String popupName) {GateKeeperPage.clickOnPopup(popupName);}

    /**
     * Verify Number Of Ports
     * @param portNumber - that wil be asserted to the actual number
     */
    @Then("GateKeeper: I see {int} thermal exhaust ports in the main port")
    public void bddVerifyNumberOfPorts(int portNumber) {GateKeeperPage.verifyNumberOfPorts(portNumber);}

    /**
     * Defeat/Click & Cost/Element which will be presented in the popup
     */
    @And("^GateKeeper: I defeat the cost in the thermal exhaust port$")
    public void bddDefeatCostInTheThermalExhaustPort() {GateKeeperPage.defeatCostInTheThermalExhaustPort();}

    /**
     * Performance/ Functional Method to defeat cost as much as wanted in the function
     * @param times - Number of times - that will be defeated cost
     */
    @And("GateKeeper: I defeat the cost for {int} times, and print out the ports information")
    public void bddDefeatCostNumberOfTimesAndStoreInfoToTheList(int times) {GateKeeperPage.defeatCostNumberOfTimesAndStoreInfoToTheList(times);}

    /**
     * Search unicorn with invalid data
     * @param dataTable - it will be asserted to verify data the data is invalid
     */
    @And("^GateKeeper: I enter incorrect information with following data, and verify if the unicorn is not visible$")
    public void bddSearchUnicornWithInvalidData(DataTable dataTable) {
        List<Map<String, String>> searchList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> field : searchList) {
            GateKeeperPage.searchUnicornWithInvalidData(field.get("Invalid_Unicorn_Name"));
        }
    }

    /**
     * Search unicorn with valid data
     * @param searchData              - data that will be searched
     * @param searchResultExpectation - expected result
     */
    @And("^GateKeeper: I enter the search data: \"([^\"]*)\", and verify if the unicorn is visible with text: \"([^\"]*)\"$")
    public void bddSearchUnicornWithValidData(String searchData, String searchResultExpectation) {GateKeeperPage.searchUnicornWithValidData(searchData, searchResultExpectation);}

    /**
     * Mathematical Operation Performance Method
     * @param numberOfData - Number of data which will be sent to the page
     * @param expectedTime  - which will be used to verify if numberOfData has been sent and verified before in defined time
     * @param sectionName  - Section Name
     */
    @And("GateKeeper: I execute a performance test by sending {int} different sorts of random data and verifying the results in less than {int} seconds on defined section: {string}")
    public void bddrPerformanceTestOnCalculator(Integer numberOfData, Integer expectedTime, String sectionName) {
        GateKeeperPage.performanceTestFunctionOnCalculator(String.valueOf(numberOfData), expectedTime, sectionName);

    }

}

