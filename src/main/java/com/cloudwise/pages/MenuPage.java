package com.cloudwise.pages;


import com.cloudwise.utils.HelperMethods;


import error.TestToolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static com.cloudwise.pages.WaitingPage.waitForSeconds;
import static com.cloudwise.utils.HelperMethods.*;

import static com.cloudwise.base.BasePage.driver;


import static com.cloudwise.utils.JavaScriptUtil.checkPageIsReady;
import static com.cloudwise.utils.JavaScriptUtil.clickElementByJS;
import static org.openqa.selenium.support.PageFactory.initElements;

public class MenuPage {

    @FindBy(xpath = "//a[@id='toggle-nav']//span")
    private static WebElement menuNavigator;
    @FindBy(xpath = "//*[@id='CybotCookiebotDialogBodyButtonAccept']")
    private static WebElement acceptCookies;
    @FindBy(xpath = "//*[contains(@id,'leadinModal')]/div[2]/button")
    private static WebElement closeTabOnCookies;

    public static HelperMethods helperMethods;
    public MenuPage() {initElements(driver, this);helperMethods = new HelperMethods();}

    public static Object verifyPageTitle() {
        String pageTitle = HelperMethods.doGetPageTitle();printInfo(("Page Title Name: " + pageTitle));
        return pageTitle;
    }

    /**
     * Select the language option from main menu
     *
     * @param language - The language which will be selected
     */
    public static void selectLanguage(String language) {
        final String methodName = "MenuPage.selectLanguage: ";
        final String languageFlagXpathWhenMenuNavigatorIsEnabled = "//div[@id='mobile-menu']//div[@class='container']//li[contains(@class,'lang-item')]//a//img[@alt='" + language + "' and @title='" + language + "']";
        final String languageFlagXpathWhenMenuNavigatorIsDisabled = "//ul[@class='sf-menu sf-js-enabled sf-arrows']//a//img[@title='" + language + "' and @title='" + language + "']";
        helperMethods.setBrowserSizeAsMedium();
        WebElement languageFlag;
        printInfoMethodStarted(methodName);

        if (driver.findElements((By.xpath(languageFlagXpathWhenMenuNavigatorIsEnabled))).size() != 0 &&
                driver.findElement(By.xpath(languageFlagXpathWhenMenuNavigatorIsEnabled)).isEnabled()) {
            languageFlag = getElement(By.xpath(languageFlagXpathWhenMenuNavigatorIsEnabled));}

        else {
            languageFlag = getElement(By.xpath(languageFlagXpathWhenMenuNavigatorIsDisabled));}

        try {
            closeCookies();
            doClick(menuNavigator);
            doClick(languageFlag);
        } catch (TestToolException e) {
            printInfo(methodName + "x path : " + languageFlag);
            printInfo(methodName + "is failed: " + e.getCause());
            e.printStackTrace();
        }
        getWaitObject();
        helperMethods.setBrowserSizeToMaximize();
        printInfoMethodEnded(methodName);
    }

    /**
     * Select the menu option from main menu
     *
     * @param menuOption - which will be selected by identifying x-paths
     * @param menuOption - (->) character has been configured to select sub-menu options which are located under the arrow
     */
    public static void selectMenu(String menuOption) {
        final String methodName = "MenuPage.selectMenu: ";
        String menuIconAngleDownXpath;
        String menuXpath;
        printInfoMethodStarted(methodName);

        if (menuOption.contains("->")) {
            menuIconAngleDownXpath = "//a[normalize-space()='" + menuOption.split("->")[0] + "']//span[@class='sf-sub-indicator']//i";
            menuXpath = "//*[@id='mobile-menu']/div/ul/li//a[normalize-space()='" + menuOption.split("->")[1] + "']";
        } else {
            menuIconAngleDownXpath = "//a[normalize-space()='" + menuOption + "']//span[@class='sf-sub-indicator']//i";
            menuXpath = "//*[@id='mobile-menu']/div/ul/li//a[normalize-space()='" + menuOption + "']";
        }

        try {
            closeCookies();
            helperMethods.setBrowserSizeAsMedium();
            doClick(menuNavigator);
            WebElement iconAngleDownElement = driver.findElement(By.xpath(menuIconAngleDownXpath));
            WebElement menuElement = driver.findElement(By.xpath(menuXpath));
            doClick(iconAngleDownElement);
            moveToElementAndClick(menuElement);

        } catch (TestToolException e) {
            e.printStackTrace();
            throw new TestToolException(methodName + "is failed: " + e.getCause());
        }

        helperMethods.setBrowserSizeToMaximize();
        printInfoMethodEnded(methodName);

    }

    /**
     * Close cookies if they are appeared during the test execution
     */
    public static void closeCookies() {
        final String methodName = "MenuPage.closeCookies: ";
        printInfoMethodStarted(methodName);
        try {
            if (driver.findElements(By.xpath("//*[@id='CybotCookiebotDialogBodyButtonAccept']")).size() == 1) {
                clickElementByJS(acceptCookies);
                printInfo(methodName + "are closed by clicking on the accept button!");
            }
            if (driver.findElements(By.xpath("//*[contains(@id,'leadinModal')]/div[2]/button")).size() == 1) {
                clickElementByJS(closeTabOnCookies);
                printInfo(methodName + " are disabled!");
            }
        } catch (TestToolException e) {
            e.printStackTrace();
            printInfo(methodName + "is failed: " + e.getCause());
        }
        printInfoMethodEnded(methodName);
    }

    /**
     * This function is going back to the previous page by using the driver.back.navigator
     */
    public static void navigateToBackPage() {
        final String methodName = "MenuPage.navigatingToBackPage: ";
        try {
            printInfoMethodStarted(methodName);
            getWaitObject();
            HelperMethods.navigateToBackPage();
            waitForSeconds(3);
            checkPageIsReady(methodName + "Page Title: " + doGetPageTitle() + "Page Url: " + driver.getCurrentUrl() + ": ");
            printInfoMethodEnded(methodName);

        } catch (TestToolException e) {
            e.printStackTrace();
            printInfo(methodName + "is failed: " + e.getCause());
        }
    }

        /**
         * This function is navigating page to the new page
         */
        public static void navigateToPage(String url) {
            final String methodName = "MenuPage.navigateToPage: ";
            try {
                printInfoMethodStarted(methodName);
                waitForSeconds(4);
                driver.navigate().to(url);
                checkPageIsReady(methodName + "Page Title: " + doGetPageTitle() + "Page Url: " + driver.getCurrentUrl() + ": ");
                getWaitObject();
                printInfoMethodEnded(methodName);

            } catch (TestToolException e) {
                e.printStackTrace();
                printInfo(methodName + "is failed: " + e.getCause());
            }

    }

}

