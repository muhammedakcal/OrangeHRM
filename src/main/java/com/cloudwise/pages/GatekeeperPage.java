package com.cloudwise.pages;

import com.cloudwise.base.ConfigReader;
import com.cloudwise.utils.HelperMethods;


import error.TestToolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.*;


import static com.cloudwise.base.BasePage.driver;
import static com.cloudwise.pages.WaitingPage.waitForSeconds;
import static com.cloudwise.utils.HelperMethods.*;
import static com.cloudwise.utils.JavaScriptUtil.*;
import static org.openqa.selenium.support.PageFactory.initElements;

public class GatekeeperPage {

    private static final TreeMap<String, String> defeatedCostsInformation = new TreeMap();
    public static HelperMethods helperMethods;

    @FindBy(xpath = "//app-test/div/div/div[1]")
    private static WebElement mainPage;

    @FindBy(xpath = "//i[@class='fal fa-bullseye-arrow ng-star-inserted' and @style='color: orange; cursor: pointer;']")
    private static WebElement defeatCost;

    @FindBy(xpath = "//input[@id='mat-input-3']")
    private static WebElement searchField;

    @FindBy(xpath = "//div[@class='ng-star-inserted']")
    private static WebElement searchResult;

    @FindBy(xpath = "//input[@id='mat-input-0']")
    private static WebElement firstFieldToFillWithValues;

    @FindBy(xpath = "//input[@id='mat-input-1']")
    private static WebElement secondFieldToFillWithValues;

    @FindBy(xpath = "//input[@id='mat-input-2']")
    private static WebElement thirdFieldToAssertValues;

    public GatekeeperPage() {
        initElements(driver, this);
        helperMethods = new HelperMethods();
    }

    private static String xPathGeneratorForGettingTextFromFrame(String text) {
        return ".//span[contains(@class, 'color') and contains(text(),'" + text + "')]";
    }

    private static String xPathGeneratorForGettingTextFromPage(String text) {
        return ".//span[not (contains(@class, 'color')) and contains(text(),'" + text + "')]";
    }

    private static WebElement frameElement(String frameName) {
        return getElement((By.xpath("//body[@class='mat-typography']//iframe[@id='" + frameName + "']")));
    }

    private static String sectionXpathInFrame(String sectionName) {
        return getElement(By.xpath("//*[@class='_1u8sp']//p[normalize-space(text())='" + sectionName + "']")).getText();
    }

    private static WebElement iconButton(String iconName){
        if (iconName.equalsIgnoreCase("Calculator")){
            iconName = iconName + "-alt";
        }
        return getElement(By.xpath("//i[@class='fal fa-" + iconName.toLowerCase(Locale.ROOT) + "']"));
    }

    private static WebElement section(String sectionName){
        return getElement(By.xpath("//p[contains(text(),'" + sectionName +"')]"));
    }

    public static String getTextFromFieldInPage(String text) {
        final String method = "GatekeeperPage.getTextFromField:getTextFromFieldFromPage: ";
        printInfoMethodStarted(method);
        printInfoMethodEnded(method);
        WebElement textElement = getElement(By.xpath(xPathGeneratorForGettingTextFromPage(text)));
        waitForVisibility(textElement);
        return doGetText(textElement);
    }

    public static String getTextFromFieldFromFrame(String text) {
        final String method = "GatekeeperPage.getTextFromField:getTextFromFieldFromFrame: ";
        printInfoMethodStarted(method);
        printInfoMethodEnded(method);
        WebElement textElement = getElement(By.xpath(xPathGeneratorForGettingTextFromFrame(text)));
        waitForVisibility(textElement);
        return doGetText(textElement);
    }


    public static void verifyPartOfTextIsLocatedOnFieldPage(String text) {
        final String method = "GatekeeperPage.getPartOfTextFromField: ";
        printInfoMethodStarted(method);
        printInfoMethodEnded(method);
        waitForVisibility(mainPage);
        flash(mainPage);
        drawBorder(mainPage);
        if (!doGetText(mainPage).contains(text)) {
            throw new TestToolException(doGetText(mainPage) + " does not contain value of: " + text);
        }

    }

    public static void switchFrame(String frameName) {
        final String method = "GatekeeperPage.switchFrame: ";
        printInfoMethodStarted(method);
        driver.switchTo().frame((frameElement(frameName)));
        waitForSeconds(5);
        printInfoMethodEnded(method);
    }

    public static String getSectionNameInFrame(String sectionName) {
        final String method = "GatekeeperPage.getSectionNameInFrame: ";
        printInfoMethodStarted(method);
        printInfoMethodEnded(method);
        return sectionXpathInFrame(sectionName);

    }

    public static void clickOnPopup(String popupName) {
        final String method = "GatekeeperPage.clickOnPopup: ";
        final String popupXpath = "//span[@class='mat-button-wrapper' and text()='" + popupName + "']";
        printInfoMethodStarted(method);
        doClick(getElement(By.xpath(popupXpath)));
        waitForSeconds(2);
        printInfoMethodEnded(method);

    }


    public static void verifyNumberOfPorts(int portNumber) {
        final String method = "GatekeeperPage.verifyNumberOfPorts: ";
        final String portsXpath = "//i[@class='fal fa-bullseye-arrow ng-star-inserted']";
        printInfoMethodStarted(method);
        int actualNumberOfPorts = driver.findElements(By.xpath(portsXpath)).size();
        printInfoMethodEnded(method);
        if (actualNumberOfPorts != portNumber) {
            throw new TestToolException(method + "failed! Expected Number of Ports: 9" +
                    " Actual NumberOfPorts: " + actualNumberOfPorts);
        }
    }

    public static void verifyPortsSize(String width, String height) {
        final String method = "GatekeeperPage.verifyNumberOfPorts: ";
        final String portsXpath = "//i[@class='fal fa-bullseye-arrow ng-star-inserted']";
        printInfoMethodStarted(method);
        if (defeatCost.getSize().getWidth() != Integer.parseInt(String.valueOf(width)) &&
                defeatCost.getSize().getHeight() != Integer.parseInt(String.valueOf(height))
        ) {
            throw new TestToolException(method + "failed! " +
                    "Expected Size: (" + width + ")," + height + ")" +
                    " Actual Size: " + defeatCost.getSize());
        }
        printInfoMethodEnded(method);
    }


    public static void defeatCostInTheThermalExhaustPort() {
        final String method = "GatekeeperPage.defeatCostInTheThermalExhaustPort: ";
        printInfoMethodStarted(method);
        doClick(defeatCost);
        waitForSeconds(2);
        printInfoMethodEnded(method);
    }

    public static void defeatCostNumberOfTimesAndStoreInfoToTheList(int times) {
        final String method = "GatekeeperPage.defeatCostAndStoreNumberOfCostInAndStoreInTheList: ";
        printInfoMethodStarted(method);

        try {
            for (int i = 0; i < times; i++) {
                String iterationKey = "[Iteration Number: " + i + "] --> ";
                clickOnPopup(ConfigReader.getProperty("popupName"));
                defeatedCostsInformation.put(iterationKey, "Location: " + defeatCost.getLocation() +
                        " Rectangle Number: " + defeatCost.getRect().toString().split("@")[1] +
                        " Size: " + defeatCost.getSize());
                defeatCostInTheThermalExhaustPort();
                waitForSeconds(1);
            }

            printInfo("Defeated Cost Information According To the Iteration:");
            printInfo("");

            for (Map.Entry<String, String> generalInfo : defeatedCostsInformation.entrySet()) {
                printInfo("<------------------------------------------------------------------------------------------------------------>");
                System.out.println(generalInfo.getKey() + " = " + generalInfo.getValue());
                printInfo("<------------------------------------------------------------------------------------------------------------>");
                printInfo("");
                printInfoMethodEnded(method);

            }

        } catch (NumberFormatException e) {
            throw new TestToolException(method + "failed! " + e.getCause() + e.getMessage());
        }
    }

    public static void searchUnicornWithInvalidData(String data) {
        final String method = "GatekeeperPage.searchUnicornWithInvalidData: ";
        printInfoMethodStarted(method);
        waitForVisibility(searchField);
        doSendTextAndPressEnter(searchField, data);
        if (data.equalsIgnoreCase("bobi") || driver.findElements(By.xpath("//div[@class='ng-star-inserted']")).size() != 0) {
            if ((searchResult.isDisplayed())) {
                throw new TestToolException("A valid search criteria has been identified: " + data + " is valid! Search Result: " + searchResult.getText());
            }
        }
        refreshPage();
        waitForSeconds(2);
        printInfoMethodEnded(method);

    }

    public static void searchValidUnicornWithInvalidData(String data, String searchResultExpectation) {
        final String method = "GatekeeperPage.searchValidUnicornWithInvalidData: ";
        printInfoMethodStarted(method);
        if (!data.equalsIgnoreCase("bobi")) {
            throw new TestToolException("An invalid valid search criteria has been identified: " + data +
                    searchResultExpectation + " is not found in the search result: " + searchResult.getText());
        }
        scrollPageDown();
        waitForVisibility(searchField);
        doSendTextAndPressEnter(searchField, data);
        waitForVisibility(searchResult);
        scrollPageTillTheEnd();
        flash(searchResult);
        waitForSeconds(3);
        drawBorder(searchResult);
        waitForSeconds(3);
        refreshPage();
        printInfoMethodEnded(method);

    }

    public static void fillValueToFirstInput(String firstInputValue) {
        final String method = "GatekeeperPage.fillValueToFirstInput: ";
        printInfoMethodStarted(method);
        waitForVisibility(firstFieldToFillWithValues);
        sendText(firstFieldToFillWithValues,firstInputValue);
        printInfoMethodEnded(method);

    }

    public static void fillValueToSecondInput(String secondInputValue) {
        final String method = "GatekeeperPage.fillValueToSecondInput: ";
        printInfoMethodStarted(method);
        waitForVisibility(secondFieldToFillWithValues);
        sendText(secondFieldToFillWithValues,secondInputValue);
        printInfoMethodEnded(method);

    }

    public static void assertValueInThirdInput(String expectedValue) {
        final String method = "GatekeeperPage.assertValueInThirdInput: ";
        waitForVisibility(thirdFieldToAssertValues);
        if(!thirdFieldToAssertValues.getAttribute("value").equals(expectedValue)){
            throw new TestToolException(expectedValue + " not found after the assertion!" + " Found Value: " + thirdFieldToAssertValues.getText());
        }
        refreshPage();
        printInfoMethodEnded(method);

    }
    public static void verifyIconButtonOnDefinedSection(String iconName, String sectionName) {
        final String method = "GatekeeperPage.verifyIconButton: ";
        printInfoMethodStarted(method);
        verifySectionName(sectionName);
        waitForVisibility(iconButton(iconName));
        printInfoMethodEnded(method);

    }

    public static void verifySectionName(String sectionName) {
        final String method = "GatekeeperPage.verifySectionName: ";
        printInfoMethodStarted(method);
        waitForVisibility(section(sectionName));
        printInfoMethodEnded(method);

    }


}










