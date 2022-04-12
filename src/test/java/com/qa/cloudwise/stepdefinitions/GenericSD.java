package com.qa.cloudwise.stepdefinitions;


import com.qa.cloudwise.utils.HelperMethods;
import com.qa.cloudwise.utils.JavaScriptUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertEquals;


public class GenericSD {

    /**
     * Assert the page title
     */
    @Given("^Generic: I see the page title with name: \"([^\"]*)\"$")
    public void bddVerifyPageTitle(String expectedTitleName) {
        assertEquals(HelperMethods.doGetPageTitle(), expectedTitleName);
    }

    /**
     * Scroll page down by 450 pixel
     */
    @When("^Generic: I scroll page down$")
    public void bddScrollPageDown() {
        JavaScriptUtil.scrollPageDown();
    }

    /**
     * Scroll page till the end
     */
    @When("^Generic: I scroll page down till the end of page$")
    public void bddScrollPageDownTillTheEndOfPage() {
        JavaScriptUtil.scrollPageTillTheEnd();
    }

    /**
     * Generate an alert
     *
     * @param message - alert message
     */
    @And("^Generic: I generate a message with text: \"([^\"]*)\"$")
    public void bddGenerateAlertMessage(String message) {JavaScriptUtil.generateAlert(message);


    }
}
