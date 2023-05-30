package com.qa.stepdefinition;


import com.qa.utils.Waiting;
import com.qa.utils.HelperMethods;
import com.qa.utils.JavaScriptUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class GenericSD {

    /**
     * Assert the page title
     */
    @Given("^Generic: I see the page title with name: \"([^\"]*)\"$")
    public void bddVerifyPageTitle(String expectedTitleName) {
        Assert.assertEquals(HelperMethods.doGetPageTitle(), expectedTitleName);
    }

    /**
     * Scroll page down by 450 pixel
     */
    @When("^Generic: I scroll page down$")
    public void bddScrollPageDown() {
        JavaScriptUtil.scrollPageDown();}

    /**
     * Scroll page till the end
     */
    @When("^Generic: I scroll page down till the end of page$")
    public void bddScrollPageDownTillTheEndOfPage() {
        JavaScriptUtil.scrollPageTillTheEnd();
    }

    /**
     * Wait for a certain number of seconds
     * @param time - seconds
     */
    @And("Generic: I wait for {int} seconds")
    public void bddGenerateAlertMessage(Integer time) {
        Waiting.waitForSeconds(time);

    }
}
