package com.qa.utils;
import com.qa.TestToolException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import static com.qa.base.BasePage.driver;
import static com.qa.utils.Waiting.waitForSeconds;

public class JavaScriptUtil {
    static HelperMethods helperMethods = new HelperMethods();

    /**
     * Flash the elment
     * @param element - web element
     */
    public static void flash(WebElement element) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element);// 1
            changeColor(bgcolor, element);// 2
        }
    }
    /**
     * Change element's color
     * @param color   - color name
     * @param element - web element
     */
    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        try {

            js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
            Thread.sleep(20);
        } catch (InterruptedException e) {

            throw new TestToolException("Some error occured while changing the coler: " + e.getCause());
        }}

    /**
     * Draw a border to surrend a web element
     * @param element - web element
     */
    public static void drawBorder(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    /**
     * Generate an alert message
     * @param message - alert message
     */
    public static void generateAlert(String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        try {
            driver.switchTo().defaultContent();
            js.executeScript("alert('" + message + "')");
            waitForSeconds(4);
            driver.switchTo().alert().dismiss();
        } catch (UnhandledAlertException e) {
            throw new TestToolException("Error occurred while creating or handling alert! " + message + ": " + e.getCause());
        }
    }


    /**
     * Click an element by JS
     * @param element - web element
     */
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Refresh browser by JS
     */
    public static void refreshBrowserByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    /**
     * Get title by JS
     */
    public static String getTitleByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return document.title;").toString();
    }


    /**
     * Get Page Inner Text by JS
     */
    public static String getPageInnerText() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return document.documentElement.innerText;").toString();
    }

    /**
     * Scroll page up
     */
    public static void scrollPageUp() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * Scroll page down by 450 pixel
     */
    public static void scrollPageDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,-450)");
    }


    /**
     * Scroll page till the end
     */
    public static void scrollPageTillTheEnd() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    /**
     * Scroll to the element
     * @param element - web element
     */
    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * Get Browser Info
     * @return - browser information
     */
    public static String getBrowserInfo() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return navigator.userAgent;").toString();
    }


    /**
     * Send keys by using web element's id
     * @param id    - web element's id
     * @param value - that will be sent to the web element
     */
    public static void sendKeysUsingJSWithId(String id, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
    }

    /**
     * Send keys by using web element's id
     * @param name  - web element's name
     * @param value - that will be sent to the web element
     */
    public static void sendKeysUsingJSWithName(String name, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
    }


    }

