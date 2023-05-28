package com.qa.stepdefinition;


import com.qa.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;


public class LoginPageSD {


    @Given("^Login Page: I enter the username/password: \"([^\"]*)\" with: \"([^\"]*)\"$")
    public void bddEnterCredentials(String value, String credential) {
       LoginPage.enterCredentials(value, credential );
    }

    @When("^Login Page: I click on the Login button$")
    public void bddClickOnLoginButton() {
        LoginPage.clickOnLoginButton();


    }

    @And("^Login Page: I verify if the logo is present$")
    public void bddVerifyLogo() {
        LoginPage.verifyLogo();

    }

    @And("^Login Page: I verify the error message with: \"([^\"]*)\"$")
    public void bddVerifyErrorMessage(String expected) {
       String actual = LoginPage.verifyErrorMessage();
       assertEquals(actual,expected);


    }

}
