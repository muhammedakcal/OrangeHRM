package com.qa.cloudwise.pages;

import com.qa.cloudwise.base.ConfigReader;
import com.qa.cloudwise.utils.Constants;
import com.qa.cloudwise.utils.HelperMethods;


import com.qa.cloudwise.TestToolException;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.*;


import static com.qa.cloudwise.base.BasePage.driver;
import static com.qa.cloudwise.pages.WaitingPage.waitForSeconds;
import static com.qa.cloudwise.utils.JavaScriptUtil.*;
import static org.openqa.selenium.support.PageFactory.initElements;

public class GateKeeperPage {

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
    @FindBy(xpath = "/html/body/app-root/app-test/div/div/div[1]/div[3]")
    private static WebElement searchOfUnicornTabArea;
    @FindBy(xpath = "//input[@id='mat-input-0']")
    private static WebElement firstFieldToFillWithValues;
    @FindBy(xpath = "//input[@id='mat-input-1']")
    private static WebElement secondFieldToFillWithValues;
    @FindBy(xpath = "//input[@id='mat-input-2']")
    private static WebElement thirdFieldToAssertValues;

    public GateKeeperPage() {
        initElements(driver, this);
        helperMethods = new HelperMethods();
    }

    /**
     * X path Generator For Frame
     *
     * @param text - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static String xPathGeneratorForGettingTextFromFrame(String text) {
        return ".//span[contains(@class, 'color') and contains(text(),'" + text + "')]";
    }

    /**
     * X path Generator For Page
     *
     * @param text - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static String xPathGeneratorForGettingTextFromPage(String text) {
        return ".//span[not (contains(@class, 'color')) and contains(text(),'" + text + "')]";
    }

    /**
     * X path Generator For Element
     *
     * @param frameName - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static WebElement frameElement(String frameName) {
        return HelperMethods.getElement((By.xpath("//body[@class='mat-typography']//iframe[@id='" + frameName + "']")));
    }

    /**
     * X path Generator For Section Element In The Frame
     *
     * @param sectionName - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static String sectionXpathInFrame(String sectionName) {
        return HelperMethods.getElement(By.xpath("//*[@class='_1u8sp']//p[normalize-space(text())='" + sectionName + "']")).getText();
    }

    /**
     * X path Generator For Icon Element
     *
     * @param iconName - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static WebElement iconButton(String iconName) {
        if (iconName.equalsIgnoreCase("Calculator")) {
            iconName = iconName + "-alt";
        }
        return HelperMethods.getElement(By.xpath("//i[@class='fal fa-" + iconName.toLowerCase(Locale.ROOT) + "']"));
    }

    /**
     * X path Generator For Section Element
     *
     * @param sectionName - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static WebElement section(String sectionName) {
        return HelperMethods.getElement(By.xpath("//p[contains(text(),'" + sectionName + "')]"));
    }

    /**
     * Get text from the field in the page
     *
     * @param text - text name
     * @return - text
     */
    public static String getTextFromFieldInPage(String text) {
        final String method = "GateKeeperPage.getTextFromFieldInPage: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.printInfoMethodEnded(method);
        WebElement textElement = HelperMethods.getElement(By.xpath(xPathGeneratorForGettingTextFromPage(text)));
        HelperMethods.waitForVisibility(textElement);
        return HelperMethods.doGetText(textElement);
    }

    /**
     * Get text from the field in the frame
     *
     * @param text - text name
     * @return - text
     */
    public static String getTextFromFieldFromFrame(String text) {
        final String method = "GateKeeperPage.getTextFromField:getTextFromFieldFromFrame: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.printInfoMethodEnded(method);
        WebElement textElement = HelperMethods.getElement(By.xpath(xPathGeneratorForGettingTextFromFrame(text)));
        HelperMethods.waitForVisibility(textElement);
        return HelperMethods.doGetText(textElement);
    }

    /**
     * Get part of text from the field in the page
     *
     * @param text - text name
     */
    public static void verifyPartOfTextIsLocatedOnFieldPage(String text) {
        final String method = "GateKeeperPage.getPartOfTextFromField: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.printInfoMethodEnded(method);
        HelperMethods.waitForVisibility(mainPage);
        flash(mainPage);
        drawBorder(mainPage);
        if (!HelperMethods.doGetText(mainPage).contains(text)) {
            throw new TestToolException(HelperMethods.doGetText(mainPage) + " does not contain value of: " + text);
        }

    }

    /**
     * Verify Text If it's located on unicorn tab area
     *
     * @param text - text name that will be verified
     * @return - text
     */
    public static boolean verifyTextIsLocatedOnUnicornTabArea(String text) {
        final String method = "GateKeeperPage.getPartOfTextIsLocatedOnFieldPage: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.printInfoMethodEnded(method);
        HelperMethods.waitForVisibility(searchOfUnicornTabArea);
        flash(searchOfUnicornTabArea);
        drawBorder(searchOfUnicornTabArea);
        return HelperMethods.doGetText(searchOfUnicornTabArea).contains(text);
    }

    /**
     * Switch Driver To Frame
     *
     * @param frameName - frame name
     */
    public static void switchFrame(String frameName) {
        final String method = "GateKeeperPage.switchFrame: ";
        HelperMethods.printInfoMethodStarted(method);
        driver.switchTo().frame((frameElement(frameName)));
        waitForSeconds(5);
        HelperMethods.printInfoMethodEnded(method);
    }

    /**
     * Get Section in Frame
     *
     * @param sectionName - Section name
     */
    public static String getSectionNameInFrame(String sectionName) {
        final String method = "GateKeeperPage.getSectionNameInFrame: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.printInfoMethodEnded(method);
        return sectionXpathInFrame(sectionName);

    }

    /**
     * Click on Pop-up
     *
     * @param popupName - Pop-up name
     */
    public static void clickOnPopup(String popupName) {
        final String method = "GateKeeperPage.clickOnPopup: ";
        final String popupXpath = "//span[@class='mat-button-wrapper' and text()='" + popupName + "']";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.doClick(HelperMethods.getElement(By.xpath(popupXpath)));
        waitForSeconds(2);
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Verify Number Of Ports
     *
     * @param portNumber - that wil be asserted to the actual number
     */
    public static void verifyNumberOfPorts(int portNumber) {
        final String method = "GateKeeperPage.verifyNumberOfPorts: ";
        final String portsXpath = "//i[@class='fal fa-bullseye-arrow ng-star-inserted']";
        HelperMethods.printInfoMethodStarted(method);
        int actualNumberOfPorts = driver.findElements(By.xpath(portsXpath)).size();
        HelperMethods.printInfoMethodEnded(method);
        if (actualNumberOfPorts != portNumber) {
            throw new TestToolException(method + "failed! Expected Number of Ports: 9" +
                    " Actual NumberOfPorts: " + actualNumberOfPorts);
        }
    }

    /**
     * Verify  Port Size
     *
     * @param width  - width
     * @param height - height
     */
    public static void verifyPortsSize(String width, String height) {
        final String method = "GateKeeperPage.verifyNumberOfPorts: ";
        final String portsXpath = "//i[@class='fal fa-bullseye-arrow ng-star-inserted']";
        HelperMethods.printInfoMethodStarted(method);

        if (defeatCost.getSize().getWidth() != Integer.parseInt(String.valueOf(width)) &&
                defeatCost.getSize().getHeight() != Integer.parseInt(String.valueOf(height))
        ) {
            throw new TestToolException(method + "failed! " +
                    "Expected Size: (" + width + ")," + height + ")" +
                    " Actual Size: " + defeatCost.getSize());
        }
        HelperMethods.printInfoMethodEnded(method);
    }

    /**
     * Defeat/Click & Cost/Element which will be presented in the popup
     */
    public static void defeatCostInTheThermalExhaustPort() {
        final String method = "GateKeeperPage.defeatCostInTheThermalExhaustPort: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.doClick(defeatCost);
        waitForSeconds(2);
        HelperMethods.printInfoMethodEnded(method);
    }

    /**
     * Performance/ Functional Method to defeat cost as much as wanted in the function
     *
     * @param times - Number of times - that will be defeated cost
     */
    public static void defeatCostNumberOfTimesAndStoreInfoToTheList(int times) {
        final String method = "GateKeeperPage.defeatCostAndStoreNumberOfCostInAndStoreInTheList: ";
        HelperMethods.printInfoMethodStarted(method);

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

            HelperMethods.printInfo("Defeated Cost Information According To the Iteration:");
            HelperMethods.printInfo("");

            for (Map.Entry<String, String> generalInfo : defeatedCostsInformation.entrySet()) {
                HelperMethods.printInfo("<------------------------------------------------------------------------------------------------------------>");
                System.out.println(generalInfo.getKey() + " = " + generalInfo.getValue());
                HelperMethods.printInfo("<------------------------------------------------------------------------------------------------------------>");
                HelperMethods.printInfo("");
                HelperMethods.printInfoMethodEnded(method);

            }

        } catch (NumberFormatException e) {
            throw new TestToolException(method + "failed! " + e.getCause() + e.getMessage());
        }
    }

    /**
     * Search unicorn with a valid data
     *
     * @param data - it will be asserted to verify that the data is invalid
     */
    public static void searchUnicornWithInvalidData(String data) {
        final String method = "GateKeeperPage.searchUnicornWithInvalidData: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.waitForVisibility(searchField);
        HelperMethods.doSendTextAndPressEnter(searchField, data);
        if (data.equalsIgnoreCase("bobi") || (verifyTextIsLocatedOnUnicornTabArea(Constants.LOST_UNICORN_NAME))) {
            if ((searchResult.isDisplayed())) {
                throw new TestToolException("A valid search criteria has been identified: " + data + " is valid! Search Result: " + searchResult.getText());
            }
        }
        scrollPageDown();
        HelperMethods.waitForVisibility(searchField);
        HelperMethods.doSendTextAndPressEnter(searchField, data);
        scrollPageTillTheEnd();
        flash(searchField);
        waitForSeconds(2);
        drawBorder(searchField);
        waitForSeconds(2);
        HelperMethods.refreshPage();
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Search unicorn with a valid data
     *
     * @param data - it will be asserted to verify that the data is valid
     */
    public static void searchValidUnicornWithInvalidData(String data, String searchResultExpectation) {
        final String method = "GateKeeperPage.searchValidUnicornWithInvalidData: ";
        HelperMethods.printInfoMethodStarted(method);
        if (!data.equalsIgnoreCase("bobi")) {
            throw new TestToolException("An invalid valid search criteria has been identified: " + data +
                    searchResultExpectation + " is not found in the search result: " + searchResult.getText());
        }
        scrollPageDown();
        HelperMethods.waitForVisibility(searchField);
        HelperMethods.doSendTextAndPressEnter(searchField, data);
        HelperMethods.waitForVisibility(searchResult);
        scrollPageTillTheEnd();
        flash(searchResult);
        waitForSeconds(3);
        drawBorder(searchResult);
        waitForSeconds(3);
        HelperMethods.refreshPage();
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Mathematical Operation - First field
     *
     * @param firstInputValue - First input
     */
    public static void fillValueToFirstInput(String firstInputValue) {
        final String method = "GateKeeperPage.fillValueToFirstInput: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.waitForVisibility(firstFieldToFillWithValues);
        HelperMethods.sendText(firstFieldToFillWithValues, firstInputValue);
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Mathematical Operation - Second Field
     *
     * @param secondInputValue - Second input
     */
    public static void fillValueToSecondInput(String secondInputValue) {
        final String method = "GateKeeperPage.fillValueToSecondInput: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.waitForVisibility(secondFieldToFillWithValues);
        HelperMethods.sendText(secondFieldToFillWithValues, secondInputValue);
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Mathematical Operation Third Field Verify Result
     *
     * @param expectedValue - Third input
     */
    public static void assertValueInThirdInput(String expectedValue) {
        final String method = "GateKeeperPage.assertValueInThirdInput: ";
        HelperMethods.waitForVisibility(thirdFieldToAssertValues);
        if (!thirdFieldToAssertValues.getAttribute("value").equals(expectedValue)) {
            throw new TestToolException(expectedValue + " not found after the assertion!" + " Found Value: " + thirdFieldToAssertValues.getText());
        }
        HelperMethods.refreshPage();
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Mathematical Operation Performance Method
     *
     * @param numberOfData - Number of data which will be sent to the page
     * @param time         - It will be used to verify if numberOfData has been sent and verified before in defined time
     * @param sectionName  - Section Name
     */
    public static void performanceTestFunctionOnCalculator(Integer numberOfData, Integer time, String sectionName) {
        DateTime dt = new DateTime();
        final String method = "GateKeeperPage.performanceTestFunctionOnCalculator ";
        final int getMinutesBeforePeformanceTest = dt.getMinuteOfHour();
        HelperMethods.printInfoMethodStarted(method);

        verifySectionName(sectionName);

        for (int i = 1; i < numberOfData; i++) {
            fillValueToFirstInput(String.valueOf(i * 10));
            fillValueToSecondInput(String.valueOf(i * 100));
            int result = (i * 10) + (i * 100);
            assertValueInThirdInput(String.valueOf(result));
        }
        int getMinutesAfterPeformanceTest = dt.getMinuteOfHour();

        int timeDifferenceAfterPerformanceTest = getMinutesAfterPeformanceTest - getMinutesBeforePeformanceTest;
        if (!(timeDifferenceAfterPerformanceTest <= time)) {
            throw new TestToolException(method + " failed! " + timeDifferenceAfterPerformanceTest + " minutes took performance test " +
                    "to verify: " + numberOfData + " different type of combinations!");
        }
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Verify Icon Button On Defined Section
     *
     * @param iconName    - Icon Name
     * @param sectionName - Section Name
     */
    public static void verifyIconButtonOnDefinedSection(String iconName, String sectionName) {
        final String method = "GateKeeperPage.verifyIconButton: ";
        HelperMethods.printInfoMethodStarted(method);
        verifySectionName(sectionName);
        HelperMethods.waitForVisibility(iconButton(iconName));
        HelperMethods.printInfoMethodEnded(method);

    }

    /**
     * Verify Section Name
     *
     * @param sectionName - Section Name
     */
    public static void verifySectionName(String sectionName) {
        final String method = "GateKeeperPage.verifySectionName: ";
        HelperMethods.printInfoMethodStarted(method);
        HelperMethods.waitForVisibility(section(sectionName));
        HelperMethods.printInfoMethodEnded(method);

    }


}










