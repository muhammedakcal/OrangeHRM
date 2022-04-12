package com.qa.cloudwise.pages;


import com.qa.cloudwise.utils.HelperMethods;


import com.qa.cloudwise.TestToolException;
import com.qa.cloudwise.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static com.qa.cloudwise.pages.WaitingPage.waitForSeconds;

import static com.qa.cloudwise.base.BasePage.driver;


import static org.openqa.selenium.support.PageFactory.initElements;

public class MenuPage {

    public static HelperMethods helperMethods;
    @FindBy(xpath = "//a[@id='toggle-nav']//span")
    private static WebElement menuNavigator;
    @FindBy(xpath = "//*[@id='CybotCookiebotDialogBodyButtonAccept']")
    private static WebElement acceptCookies;
    @FindBy(xpath = "//*[contains(@id,'leadinModal')]/div[2]/button")
    private static WebElement closeTabOnCookies;

    public MenuPage() {
        initElements(driver, this);
        helperMethods = new HelperMethods();
    }

    public static Object verifyPageTitle() {
        String pageTitle = HelperMethods.doGetPageTitle();
        HelperMethods.printInfo(("Page Title Name: " + pageTitle));
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
        HelperMethods.printInfoMethodStarted(methodName);

        if (driver.findElements((By.xpath(languageFlagXpathWhenMenuNavigatorIsEnabled))).size() != 0
                &&
                driver.findElement(By.xpath(languageFlagXpathWhenMenuNavigatorIsEnabled)).isEnabled()) {
            languageFlag = HelperMethods.getElement(By.xpath(languageFlagXpathWhenMenuNavigatorIsEnabled));

        } else {
            languageFlag = HelperMethods.getElement(By.xpath(languageFlagXpathWhenMenuNavigatorIsDisabled));
        }
        try {
            closeCookies();
            HelperMethods.doClick(menuNavigator);
            HelperMethods.doClick(languageFlag);
            waitForSeconds(3);
            helperMethods.setBrowserSizeToMaximize();

        } catch (Exception e) {
            throw new TestToolException(methodName + "x path : " + languageFlag + methodName + "is failed: " + e.getCause());

        }

        HelperMethods.printInfoMethodEnded(methodName);
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
        HelperMethods.printInfoMethodStarted(methodName);

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
            HelperMethods.doClick(menuNavigator);
            WebElement iconAngleDownElement = driver.findElement(By.xpath(menuIconAngleDownXpath));
            WebElement menuElement = driver.findElement(By.xpath(menuXpath));
            HelperMethods.doClick(iconAngleDownElement);
            HelperMethods.moveToElementAndClick(menuElement);

        } catch (TestToolException e) {
            e.printStackTrace();
            throw new TestToolException(methodName + "is failed: " + e.getCause());
        }

        helperMethods.setBrowserSizeToMaximize();
        HelperMethods.printInfoMethodEnded(methodName);

    }

    /**
     * Close cookies if they are appeared during the test execution
     */
    public static void closeCookies() {
        final String methodName = "MenuPage.closeCookies: ";
        HelperMethods.printInfoMethodStarted(methodName);
        try {
            if (driver.findElements(By.xpath("//*[@id='CybotCookiebotDialogBodyButtonAccept']")).size() == 1) {
                JavaScriptUtil.clickElementByJS(acceptCookies);
                HelperMethods.printInfo(methodName + "are closed by clicking on the accept button!");
            }
            if (driver.findElements(By.xpath("//*[contains(@id,'leadinModal')]/div[2]/button")).size() == 1) {
                JavaScriptUtil.clickElementByJS(closeTabOnCookies);
                HelperMethods.printInfo(methodName + " are disabled!");
            }
        } catch (TestToolException e) {
            e.printStackTrace();
            HelperMethods.printInfo(methodName + "is failed: " + e.getCause());
        }
        HelperMethods.printInfoMethodEnded(methodName);
    }

    /**
     * This function is going back to the previous page by using the driver.back.navigator
     */
    public static void navigateToBackPage() {
        final String methodName = "MenuPage.navigatingToBackPage: ";
        try {
            HelperMethods.printInfoMethodStarted(methodName);
            waitForSeconds(3);
            HelperMethods.navigateToBackPage();
            waitForSeconds(3);
            JavaScriptUtil.checkPageIsReady(methodName + "Page Title: " + HelperMethods.doGetPageTitle() + "Page Url: " + driver.getCurrentUrl() + ": ");
            HelperMethods.printInfoMethodEnded(methodName);

        } catch (TestToolException e) {
            e.printStackTrace();
            HelperMethods.printInfo(methodName + "is failed: " + e.getCause());
        }
    }

    /**
     * This function is navigating page to the new page
     */
    public static void navigateToPage(String url) {
        final String methodName = "MenuPage.navigateToPage: ";
        try {
            HelperMethods.printInfoMethodStarted(methodName);
            waitForSeconds(4);
            driver.navigate().to(url);
            JavaScriptUtil.checkPageIsReady(methodName + "Page Title: " + HelperMethods.doGetPageTitle() + "Page Url: " + driver.getCurrentUrl() + ": ");
            HelperMethods.getWaitObject();
            HelperMethods.printInfoMethodEnded(methodName);

        } catch (TestToolException e) {
            e.printStackTrace();
            HelperMethods.printInfo(methodName + "is failed: " + e.getCause());
        }

    }

}

