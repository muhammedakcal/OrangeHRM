package com.qa.pages;

import com.qa.TestToolException;
import com.qa.utils.HelperMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.qa.base.BasePage.driver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage {


    public LoginPage () { initElements (driver, this); }

    public static HelperMethods helperMethods = new HelperMethods ();


    /**
     * This function is entering the username and password credentials on the Login Page
     *
     * @param value - username/password
     * @param credential - username or password credential
     */
    @FindBy(xpath = "//input[@name='username']")
    private static WebElement usernameXpath;
    @FindBy(xpath = "//input[@name='password']")
    private static WebElement passwordXpath;

    public static void enterCredentials (String value, String credential) {

        final String methodName = "LoginPage.enterCredentials: ";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .waitForVisibility (usernameXpath)
                    .and ()
                    .waitForVisibility (passwordXpath);

            if (value.equals ("username")) {
                helperMethods.sendText (usernameXpath, credential);

            } else if (value.equals ("password")) {
                helperMethods.sendText (passwordXpath, credential);

            } else {

                throw new TestToolException (methodName + "is failed: The value: " + value + " should be username or password!");
            }

            helperMethods.printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * This function clicks on the Login Button
     */
    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement buttonLogin;

    public static void clickOnLoginButton () {
        final String methodName = "LoginPage.clickOnLoginButton: ";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .waitForClickability (buttonLogin)
                    .and ()
                    .doClick (buttonLogin)
                    .and ()
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Verify the OrangeHRM Logo after the login
     */
    @FindBy(xpath = "//a[@class='oxd-brand']")
    private static WebElement logoXpath;

    public static void verifyLogo () {
        final String methodName = "LoginPage.verifyLogo: ";

        try {
            helperMethods.printInfoMethodStarted (methodName)
                    .waitForVisibility (logoXpath)
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Verify the Error Message on the Login Page
     */
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private static WebElement errorMessageXpath;

    public static String verifyErrorMessage () {
        final String methodName = "LoginPage.verifyErrorMessage: ";

        try {
            helperMethods.printInfoMethodStarted (methodName)
                    .waitForVisibility (errorMessageXpath)
                    .printInfoMethodEnded (methodName);


            return errorMessageXpath.getText ();

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());

        }

    }
}



