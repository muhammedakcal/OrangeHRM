package com.qa.pages;

import com.qa.TestToolException;
import com.qa.utils.HelperMethods;
import com.qa.utils.JavaScriptUtil;
import com.qa.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qa.base.BasePage.driver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage {


    public
    HomePage () {
        initElements (driver, this);
    }

    public static HelperMethods helperMethods = new HelperMethods ();

    /**
     * Filter Dropdown by visible text
     */
    public static
    void selectFilterDropdownByText ( String filterText ) {
        final String methodName = "LoginPage.filterDropdownByText: ";
        final String dropdownXPath = "//select[@class='product_sort_container']";
        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .selectDropdownOptionByText (driver, dropdownXPath, filterText)
                    .and ()
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());

        }
    }

    /**
     * Add or remove item into the cart
     *
     * @param operation   - [add to cart or remove]
     * @param productName - shopping item name
     */

    public static
    void selectProductInTheCart ( String operation, String productName ) {
        final String methodName = "LoginPage.selectItemInTheCart: ";
        final String itemXpath = "//button[contains(@id,'"
                + operation.toLowerCase ().replaceAll ("\\s", "-")
                + "-"
                + productName.toLowerCase ().replaceAll ("\\s", "-") + "')]";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .doClick (driver.findElement (By.xpath (itemXpath)))
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Verify the selected number of items on the home page
     *
     * @param selectedProductNumber - selected the number of products on the home page
     */

    public static
    void verifyTheNumberOfItem ( Integer selectedProductNumber ) {
        final String methodName = "LoginPage.verifyTheNumberOfItem: ";
        final String NumberOfItemXpath = "//span[@class='shopping_cart_badge' and text()='" + selectedProductNumber + "']";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .waitForVisibility (driver.findElement (By.xpath (NumberOfItemXpath)))
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Click on the shopping button on the home page
     */

    public static
    void clickOnShoppingCart () {
        final String methodName = "LoginPage.clickOnShoppingCart: ";
        final String shoppingCartCSS = ".shopping_cart_link";

        try {
            JavaScriptUtil.scrollPageUp ();
            helperMethods.printInfoMethodStarted (methodName)
                    .doClick (driver.findElement (By.cssSelector (shoppingCartCSS)))
                    .and ()
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Finalize the checkout by clicking on the operation button
     *
     * @param operationName - Continue Shopping or Checkout
     */

    public static
    void selectFinalOperationOnTheCheckOutProcess ( String operationName ) {
        final String methodName = "LoginPage.selectFinalOperationOnTheCheckOutProcess: ";
        final String opearationButtonXpath = "//button[contains(text(),'" + operationName + "')]";

        try {

            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .doClick (driver.findElement (By.xpath (opearationButtonXpath)))
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Extract the page title on the checkout section
     */

    public static
    String getCheckOutPageTitle () {
        final String methodName = "LoginPage.verifyCheckOutPageTitle: ";
        final String titleCss = ".title";

        try {
            WebElement pageTitle = driver.findElement (By.cssSelector (titleCss));
            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .waitForVisibility (pageTitle)
                    .printInfoMethodEnded (methodName);

            return pageTitle.getText ();

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }

    }

    /**
     * Enter necessary field on the checkout
     *
     * @param field - field name [Ex: First Name, Last Name, Zip Code]
     * @param value - field value
     */
    public static
    void enterFieldsOnTheCheckout ( String field, String value ) {
        final String methodName = "LoginPage.enterFieldsOnTheCheckout: ";
        final String fieldXpath = "//input[@placeholder='" + field + "']";

        try {
            WebElement fieldElement = driver.findElement (By.xpath (fieldXpath));
            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .waitForVisibility (fieldElement)
                    .sendText (fieldElement, value)
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }
    }


    /**
     * Click on the button on the Checkout: Your Information Section
     *
     * @param buttonName - Continue/Cancel
     */
    public static void clickOnButtonOnTheCheckout ( String buttonName ) {
        final String methodName = "LoginPage.clickOnButtonOnTheCheckout: ";
        final String buttonXpath = "//input[@value='" + buttonName + "']";

        try {
            WebElement buttonElement = driver.findElement (By.xpath (buttonXpath));
            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .waitForVisibility (buttonElement)
                    .doClick (buttonElement)
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }
    }

    /**
     * Get the Total Amount Of Payment
     * @return extract the total amount
     */
    public static String extractTotalPaymentAmount () {
        final String methodName = "LoginPage.totalPaymentInformation: ";
        final String totalPaymentAmountXpath = "//div[contains(@class, 'summary_total_label')]";
        try {
            WebElement totalPaymentElement = driver.findElement (By.xpath (totalPaymentAmountXpath));
            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .waitForVisibility (totalPaymentElement)
                    .printInfoMethodEnded (methodName);

            return totalPaymentElement.getText ();
        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }
    }
        /**
         * Click on the button on the Checkout: Your Information Section
         *
         * @param buttonName - Finish/Cancel
         */
        public static void clickOnButtonOnTheCheckoutOverview ( String buttonName ) {
            final String methodName = "LoginPage.clickOnButtonOnTheCheckout: ";
            final String buttonXpath = "//button[text() = '" + buttonName + "']";

            try {
                WebElement buttonElement = driver.findElement (By.xpath (buttonXpath));
                helperMethods.printInfoMethodStarted (methodName)
                        .and ()
                        .waitForVisibility (buttonElement)
                        .doClick (buttonElement)
                        .printInfoMethodEnded (methodName);

            } catch (TestToolException e) {

                throw new TestToolException (methodName + "is failed: " + e.getCause ());
            }
        }

    /**
     * Verify the message on the Checkout Complete! Section
      * @param expectedMessage -
     */
    public static void verifyTheMessageOnCheckoutCompleteSection (String expectedMessage) {
        final String methodName = "LoginPage.extractTheTextOnCheckoutCompleteSection: ";
        final String messageTextXpath = "//*[contains(text(), '" + expectedMessage + "')]";
        try {
            WebElement messageTextElement = driver.findElement (By.xpath (messageTextXpath));
            helperMethods.printInfoMethodStarted (methodName)
                    .and ()
                    .waitForVisibility (messageTextElement)
                    .printInfoMethodEnded (methodName);

        } catch (TestToolException e) {

            throw new TestToolException (methodName + "is failed: " + e.getCause ());
        }
    }
    }






