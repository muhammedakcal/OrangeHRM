package com.cloudwise.stepdefinitions;


import com.cloudwise.utils.HelperMethods;
import com.cloudwise.utils.JavaScriptUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertEquals;


public class GenericSD {


    @Given("^Generic: I see the page title with name: \"([^\"]*)\"$")
    public void bddVerifyPageTitle(String expectedTitleName) {
        assertEquals(HelperMethods.doGetPageTitle(), expectedTitleName);
    }

    @When("^Generic: I scroll page down$")
    public void bddScrollPageDown(){
        JavaScriptUtil.scrollPageDown();
    }

    @When("^Generic: I scroll page down till the end of page$")
    public void bddScrollPageDownTillTheEndOfPage(){
        JavaScriptUtil.scrollPageTillTheEnd();
    }


}
