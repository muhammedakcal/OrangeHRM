package com.qa.stepdefinition;

import com.qa.pages.MenuPage;
import com.qa.utils.Constants;
import com.qa.utils.HelperMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;


public class MenuSD {

    /**
     * This step is going to the home page and verifies to the home page title
     * to make sure that the correct url and environment session has been opened!
     */
    @Given("^I open the environment and see the home page$")
    public void bddOpenEnvironmentAndVerifyHomePageTitle() {
        Assert.assertEquals(Constants.HOME_PAGE_TITLE, MenuPage.verifyPageTitle());}

    /**
     * This step selects the language option from main menu
     * @param languageOption - The language which will be selected
     */
    @Then("^Menu: I select the language: \"([^\"]*)\"$")
    public void bddSelectLanguage(String languageOption) {
        MenuPage.selectLanguage(languageOption);
    }

    /**
     * This step selects the menu option from main menu
     * @param menuOption - which will be selected by identifying x-paths
     * (->) character has been configured to select sub-menu options which are located under the arrow
     */
    @And("^Menu: I select the menu option: \"([^\"]*)\"$")
    public void bddSelectMenuOpion(String menuOption) {
        MenuPage.selectMenu(menuOption);
    }

    /**
     * This step is going back to the previous page
     */
    @And("^Menu: I go back to previous page$")
    public void bddNavigateBackToThePage() {
        MenuPage.navigateToBackPage();
    }

    /**
     * This step is navigating forward to another page
     * @param url - the url which will be navigated by the browser
     */
    @When("^Menu: I navigate to the page: \"([^\"]*)\"$")
    public void bddNavigateToPage(String url) {
        HelperMethods.navigateToPage(url);
    }
}