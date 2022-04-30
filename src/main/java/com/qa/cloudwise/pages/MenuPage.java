package com.qa.cloudwise.pages;


import com.qa.cloudwise.TestToolException;
import com.qa.cloudwise.utils.HelperMethods;
import com.qa.cloudwise.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static com.qa.cloudwise.base.BasePage.driver;


import static com.qa.cloudwise.utils.HelperMethods.*;


import static org.openqa.selenium.support.PageFactory.initElements;

public class MenuPage {


    public static HelperMethods helperMethods = new HelperMethods();
    @FindBy(xpath = "//a[@id='toggle-nav']//span")
    private static WebElement menuNavigator;

    public MenuPage() {
        initElements(driver, this);
    }

    public static Object verifyPageTitle() {
        String pageTitle = doGetPageTitle();
        helperMethods.printInfo(("Page Title Name: " + pageTitle));
        return pageTitle;
    }

    /**
     * Select the language option from main menu
     *
     * @param language - The language which will be selected
     */
    public static void selectLanguage(String language) {
        final String methodName = "MenuPage.selectLanguage: ";
        final String languageFlagXpath= "//div[@id='mobile-menu']//div[@class='container']//li[contains(@class,'lang-item')]//a//img[@alt='" + language + "' and @title='" + language + "']";
        helperMethods.printInfoMethodStarted(methodName).setBrowserSizeAsMedium();
        try {
            helperMethods.closeCookies().doClick(menuNavigator);
            WebElement languageElement = getElement(getXpath(languageFlagXpath));
            helperMethods.waitForClickability(languageElement).doClick(languageElement).setBrowserSizeToMaximize().printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());

        }

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

        if (menuOption.contains("->")) {
            menuIconAngleDownXpath = "//a[normalize-space()='" + menuOption.split("->")[0] + "']//span[@class='sf-sub-indicator']//i";
            menuXpath = "//*[@id='mobile-menu']/div/ul/li//a[normalize-space()='" + menuOption.split("->")[1] + "']";
        } else {
            menuIconAngleDownXpath = "//a[normalize-space()='" + menuOption + "']//span[@class='sf-sub-indicator']//i";
            menuXpath = "//*[@id='mobile-menu']/div/ul/li//a[normalize-space()='" + menuOption + "']";
        }

        try {

            helperMethods.printInfoMethodStarted(methodName)
                    .setBrowserSizeAsMedium()
                    .doClick(menuNavigator)
                    .doClick(getElement(getXpath(menuIconAngleDownXpath)))
                    .moveToElementAndClick(getElement(getXpath(menuXpath)))
                    .setBrowserSizeToMaximize()
                    .printInfoMethodEnded(methodName);

        } catch (TestToolException e) {
            e.printStackTrace();
            throw new TestToolException(methodName + "is failed: " + e.getCause());
        }


    }


    /**
     * This function is going back to the previous page by using the driver.back.navigator
     */
    public static void navigateToBackPage() {
        final String methodName = "MenuPage.navigatingToBackPage: ";
        try {

            helperMethods.printInfoMethodStarted(methodName)
                    .and().navigateToBackPage()
                    .printInfoMethodEnded(methodName);
            JavaScriptUtil.checkPageIsReady(methodName + "Page Title: " + doGetPageTitle() + "Page Url: " + driver.getCurrentUrl() + ": ");

        } catch (TestToolException e) {
            e.printStackTrace();
            throw new TestToolException(methodName + "is failed: " + e.getCause());
        }

    }


}



