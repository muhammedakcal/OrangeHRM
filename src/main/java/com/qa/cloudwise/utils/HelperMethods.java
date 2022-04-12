package com.qa.cloudwise.utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;


import com.qa.cloudwise.base.ConfigReader;
import com.qa.cloudwise.TestToolException;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qa.cloudwise.base.BasePage.*;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.qa.cloudwise.pages.WaitingPage.waitForSeconds;
import static com.qa.cloudwise.utils.JavaScriptUtil.flash;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HelperMethods {

    /**
     * Create Public and Useful Methods in order to use in "Pages Package"
     *
     */
    public HelperMethods() {initElements(driver, this);}

    public static Actions actions = new Actions(driver);

    /**
     * Print "System.out.println" in a shorter way
     * @param line - line that will be printed
     */
    public static void printInfo(Object line) {System.out.println(line);}

    /**
     * Print system.info in a shorter way to define that the functional operation is started!
     * @param line - line that will be printed
     */
    public static void printInfoMethodStarted(Object line) {System.out.println(line + "start!");}

    /**
     * Print system.info in a shorter way to declare that the functional operation is ended!
     * @param line - line that will be printed
     */
    public static void printInfoMethodEnded(Object line) {System.out.println(line + "end!");}

    /**
     * General Selenium Wait that can be modified in Constants by changing the "EXPLICIT_WAIT_TIME"
     * @return - web element
     */
    public static WebDriverWait getWaitObject() {return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);}

    /**
     * Wait until the element is presented
     * @param element - web element
     */
    public static void waitForVisibility(WebElement element) {

        try{
        getWaitObject().until(ExpectedConditions.visibilityOf(element));

        } catch(NoSuchElementException e)
        {
            throw new TestToolException(element + " is not visible!");
        }
    }
    /**
     * Wait until the element is clickable
     * @param element - web element
     */
    public static void waitForClickability(WebElement element) {
        try{
            getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
        }
        catch(NoSuchElementException e){
            throw new TestToolException(element + " is not clickable!");
        }
    }

    /**
     *  Get Element and use flash and draw if it's selected as 'yes' in the configuration.properties file
     * @param locator - web element locator
     * @return - locator
     */
    public static WebElement getElement(By locator) {
        WebElement element = null;

        try {
            element = driver.findElement(locator);
            if (highlightElement) {
                flash(element);
            }
            if (drowBorderOnElement) {
                JavaScriptUtil.drawBorder(element);
            }

        } catch (NoSuchElementException e) {
            throw new TestToolException("Some exception got occurred while getting the web element: " + element + ": " + e.getCause());
        }

        return element;
    }

    /**
     * Send text to the element
     *
     * @param element - web element
     * @param text - text
     */
    public static void sendText(WebElement element, String text) {
        try {
            waitForVisibility(element);
            element.clear();
            element.sendKeys(text);
            flash(element);
            if (highlightElement) {
                flash(element);
            }
            if (drowBorderOnElement) {
                JavaScriptUtil.drawBorder(element);
            }
        } catch (NoSuchElementException e) {
            throw new TestToolException("Some exception got occurred while getting the web element: " + element + ": " + e.getCause());
        }

    }

    /**
     * Send text and press Enter by using Robot Class
     * @param element - web element
     * @param text - text
     */
    public static void doSendTextAndPressEnter(WebElement element, String text) {
        try {
            Robot robot = new Robot();
            waitForVisibility(element);
            element.click();
            element.clear();
            element.sendKeys(text);
            robot.keyPress(KeyEvent.VK_ENTER);
            waitForSeconds(2);
            robot.keyRelease(KeyEvent.VK_ENTER);
            waitForSeconds(2);

        } catch (AWTException e) {
            e.printStackTrace();
            throw new TestToolException("Error occurred while pressing sending and pressing enter to value: " + text);
        }

    }

    /**
     * Click on the web-element by using "Action Class"
     * @param element - web element
     */
    public static void doClick(WebElement element) {
        try {
            actions.click(element).pause(Duration.ofMillis(2000)).build().perform();
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while clicking to the web element: " + element + ": " + e.getCause());

        }
    }

    /**
     * Move and Click the web-element by using "Action Class"
     * @param element - web element
     */

    public static void moveToElementAndClick(WebElement element) {
        try {
            moveToElement(element);
            doClick(element);

        } catch (NoSuchElementException e) {
            throw new TestToolException("Some exception occurred while moving or clicking to the web element: " + element + ": " + e.getCause());
        }
    }

    /**
     * Move to the defined web-element by using "Action Class"
     * @param element - web element
     */
    public static void moveToElement(WebElement element) {
        try {
            actions.moveToElement(element).pause(Duration.ofMillis(1000)).build().perform();
        } catch (NoSuchElementException e) {
            throw new TestToolException("Some exception occurred while moving  to the web element: " + element + ": " + e.getCause());

        }
    }

    /**
     * Get Page Title
     */
    public static String doGetPageTitle() {
        try {
            return driver.getTitle();
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while getting the page title: " + e.getCause());

        }
    }

    /**
     * Refresh Page and wait till the page is loaded to avoid potential exception error
     */
    public static void refreshPage() {
        try {
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(Constants.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while refreshing the page: " + driver.getCurrentUrl() + ": " + e.getCause());

        }
    }

    /**
     * Navigate to the page and wait till the page is loaded to avoid potential exception error
     */
    public static void navigateToBackPage() {
        try {
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while navigating the the page: " + driver.getCurrentUrl() + ": " + e.getCause());

        }
    }

    /**
     * Get text from the element
     * @param element - web element
     * @return - element
     */
    public static String doGetText(WebElement element) {
        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            throw new TestToolException("Some exception occurred while getting the text from the element: " + element + ": " + e.getCause());

        }
    }

    /**
     * Verify if the element is displayed
     * @param element - web element
     * @return - element
     */
    public static boolean isDisplayed(WebElement element) {
        try {
            getWaitObject();
            return element.isDisplayed();
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while verifying if the element is displayed: " + element + ": " + e.getCause());
        }

    }

    /**
     * Verify if there is no duplicated name in the list
     * @param list - list
     * @return verification result as true or false
     */
    public static boolean verifyIfThereIsNoDuplicatedNameInList(List<WebElement> list) {
        HashMap<Integer, String> hMap = new HashMap<Integer, String>();
        for (int i = 0; i < list.size(); i++) {
            //hashmap doesn't contain any value if the condition is true
            if (!(hMap.containsValue(list.get(i).getText()))) {
                hMap.put(i, list.get(i).getText());
            } else {
                printInfo("Duplicate value in the List: " + list.get(i).getText());
                hMap.put(list.size() + 1, "The list has a duplicated value");
            }
        }
        return Objects.isNull(hMap.get(list.size() + 1));

    }

    /**
     * Verify if there is no duplicated value in the list
     * @param list - list
     * @return verification result as true or false
     */
    public static boolean findNotDuplicatedValueInList(List<WebElement> list, String name) {
        HashMap<Integer, String> hMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            //hashmap doesn't contain any value if the condition is true
            if (!(hMap.containsValue(list.get(i).getText()))) {
                hMap.put(i, list.get(i).getText());
            } else {
                printInfo("Duplicate value in the List: " + list.get(i).getText());
                hMap.put(list.size() + 2, list.get(i).getText());

            }
        }
        return Objects.equals(hMap.get(list.size() + 2), name);
    }

    /**
     * Find the duplicate value by set
     * @param list - list name
     * @param <T> - Object Type
     * @return - duplicated names
     */
    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                .collect(Collectors.toSet());

    }

    /**
     * Set browser size to medium
     * Dimension can be modified from configuration.properties file
     */
    public static void setBrowserSizeAsMedium() {
        try {
            int width = Integer.parseInt(ConfigReader.getProperty("width"));
            int height = Integer.parseInt(ConfigReader.getProperty("height"));
            Dimension dimension = new Dimension(width, height);
            driver.manage().window().setSize(dimension);
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while setting the window size " + ": " + e.getCause());
        }
    }
    /**
     * Set browser size to maximize
     * Dimension can be modified from configuration.properties file
     */
    public static void setBrowserSizeToMaximize() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
        } catch (NoSuchContextException e) {
            throw new TestToolException("Some exception occurred while setting the window maximize " + ": " + e.getCause());
        }

    }


}

