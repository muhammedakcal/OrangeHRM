package com.qa.pages;

import com.qa.TestToolException;
import com.qa.utils.HelperMethods;
import org.openqa.selenium.By;
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
    @FindBy(id = "user-name")
    private static WebElement usernameID;
    @FindBy(id = "password")
    private static WebElement passwordID;

    public static void enterCredentials (String value, String credential) {

        final String methodName = "LoginPage.enterCredentials: ";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .waitForVisibility (usernameID)
                    .and ()
                    .waitForVisibility (passwordID);

            if (value.equals ("username")) {
                helperMethods.sendText (usernameID, credential);

            } else if (value.equals ("password")) {
                helperMethods.sendText (passwordID, credential);

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
    @FindBy(id = "login-button")
    private static WebElement buttonLoginID;

    public static void clickOnLoginButton () {
        final String methodName = "LoginPage.clickOnLoginButton: ";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .waitForClickability (buttonLoginID)
                    .and ()
                    .doClick (buttonLoginID)
                    .and ()
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Verify the OrangeHRM Logo after the login
     */
    @FindBy(xpath = "//div[@class='app_logo']")
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
    @FindBy(xpath = "//div[@class='error-message-container error']")
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

    /**
     * Log out from the application
     */
    public static void logOut(){
        final String methodName = "LoginPage.logOut: ";
        final String menuButtonClassName = "bm-burger-button";
        final String logOutButtonCSS = "a#logout_sidebar_link";
        try {
            WebElement menuButtonElement = driver.findElement(By.className (menuButtonClassName));
            WebElement logOutButtonElement = driver.findElement(By.cssSelector(logOutButtonCSS));
            helperMethods.printInfoMethodStarted (methodName)

                    .moveToElementAndClick (menuButtonElement)
                    .and ()
                    .moveToElementAndClick (logOutButtonElement)
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    }











