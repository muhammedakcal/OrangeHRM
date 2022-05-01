package com.qa.pages;
import com.qa.base.ConfigReader;
import com.qa.utils.HelperMethods;
import com.qa.utils.Constants;
import com.qa.TestToolException;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.*;
import static com.qa.base.BasePage.driver;
import static com.qa.utils.HelperMethods.getElement;
import static org.openqa.selenium.support.PageFactory.initElements;

public class GateKeeperPage {
    private static final TreeMap<String, String> defeatedCostsInformation = new TreeMap();
    public static HelperMethods helperMethods = new HelperMethods();
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
    private static WebElement thirdFieldToAssertValue;

    public GateKeeperPage() {
        initElements(driver, this);
    }
    /**
     * X path Generator For Icon Element
     * @param iconName - which will identify to customize x-path
     * @return - Customized x path
     */
    private static WebElement iconButton(String iconName) {
        if (iconName.equalsIgnoreCase("Calculator")) {
            iconName = iconName + "-alt";
        }
        return getElement(By.xpath("//i[@class='fal fa-" + iconName.toLowerCase(Locale.ROOT) + "']"));
    }
    /**
     * X path Generator For Section Element
     * @param sectionName - The text which will identify to customize x-path
     * @return - Customized x path
     */
    private static WebElement section(String sectionName) {
        return getElement(By.xpath("//p[contains(text(),'" + sectionName + "')]"));
    }
    /**
     * Verify Section Name
     * @param sectionName - Section Name
     */
    public static void verifySectionName(String sectionName) {
        final String methodName = "GateKeeperPage.verifySectionName: ";
        try {
            helperMethods.printInfoMethodStarted(methodName).waitForVisibility(section(sectionName)).and().printInfoMethodEnded(methodName);
        } catch (NoSuchElementException e) {
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }
    }
    /**
     * Verify Icon Button On Defined Section
     * @param iconName    - Icon Name
     * @param sectionName - Section Name
     */
    public static void verifyIconButtonOnDefinedSection(String iconName, String sectionName) {
        final String methodName = "GateKeeperPage.verifyIconButton: ";
        try {
            helperMethods.printInfoMethodStarted(methodName).waitForVisibility(section(sectionName)).and().printInfoMethodEnded(methodName).waitForVisibility(iconButton(iconName));
        } catch (NoSuchElementException e) {
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }
    }
    /**
     * Extract address from Gatekeeper Page
     * @return - text
     */
    public static String extractAddress() {
        final String methodName = "GateKeeperPage.getTextFromFieldInPage: ";
        final String addressXpath = "//span[contains(text(),'Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istan')]";
        try {
            helperMethods.printInfoMethodStarted(methodName).waitForVisibility(getElement(HelperMethods.getXpath(addressXpath)))
                    .and().printInfoMethodEnded(methodName);
        } catch (NoSuchElementException e) {
            throw new TestToolException(methodName + "failed! " + e.getCause());
        }
        return HelperMethods.doGetText(getElement(HelperMethods.getXpath(addressXpath)));
    }
    /**
     * Click on Pop-up
     * @param popupName - Pop-up name
     */
    public static void clickOnPopup(String popupName) {
        final String methodName = "GateKeeperPage.clickOnPopup: ";
        final String popupXpath = "//span[@class='mat-button-wrapper' and text()='" + popupName + "']";
        try {
            helperMethods.printInfoMethodStarted(methodName).waitForVisibility(getElement(HelperMethods.getXpath(popupXpath)))
                    .and().doClick(getElement(HelperMethods.getXpath(popupXpath))).printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }
    }
    /**
     * Verify Number Of Ports
     *
     * @param portNumber - that wil be asserted to the actual number
     */
    public static void verifyNumberOfPorts(int portNumber) {
        final String methodName = "GateKeeperPage.verifyNumberOfPorts: ";
        final String numberOfPorts = "//i[@class='fal fa-bullseye-arrow ng-star-inserted']";

        try {
            helperMethods.printInfoMethodStarted(methodName);
            int actualNumberOfPorts = driver.findElements(HelperMethods.getXpath(numberOfPorts)).size();
            if (actualNumberOfPorts != portNumber) {
                throw new TestToolException(methodName + "failed! Expected Number of Ports: 9" + " Actual NumberOfPorts: " + actualNumberOfPorts);
            }
            helperMethods.printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }
    }

    /**
     * Defeat/Click & Cost/Element which will be presented in the popup
     */
    public static void defeatCostInTheThermalExhaustPort() {
        final String methodName = "GateKeeperPage.defeatCostInTheThermalExhaustPort: ";
        try {
            helperMethods.printInfoMethodStarted(methodName).doClick(defeatCost).and().printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }
    }
    /**
     * Performance/ Functional Method to defeat cost as much as wanted in the function
     * @param time - Number of times the cost will be defeated
     */
    public static void defeatCostNumberOfTimesAndStoreInfoToTheList(int time) {
        final String methodName = "GateKeeperPage.defeatCostAndStoreNumberOfCostInAndStoreInTheList: ";
        helperMethods.printInfoMethodStarted(methodName);
        try {
            for (int i = 0; i < time; i++) {
                String iterationKey = "[Iteration Number: " + i + "] --> ";
                clickOnPopup(ConfigReader.getProperty("popupName"));
                defeatedCostsInformation.put(iterationKey, "Location: " + defeatCost.getLocation() + " Rectangle Number: "
                        + defeatCost.getRect().toString().split("@")[1] + " Size: " + defeatCost.getSize());
                defeatCostInTheThermalExhaustPort();
            }
            for (Map.Entry<String, String> generalInfo : defeatedCostsInformation.entrySet()) {
                helperMethods.printInfo("<------------------------------------------------------------------------------------------------------------>")
                        .printInfo(generalInfo.getKey() + " = " + generalInfo.getValue())
                        .printInfo("<------------------------------------------------------------------------------------------------------------>")
                        .printInfo("").and().printInfoMethodEnded(methodName);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new TestToolException(methodName + "failed! " + e.getCause() + ": " + e.getMessage());
        }
    }
    /**
     * Search unicorn with a valid data (BOBI/bobi)
     * @param expectedUnicornName  - unicorn name data
     * @param expectedSearchResult - expected result after the search
     */
    public static void searchUnicornWithValidData(String expectedUnicornName, String expectedSearchResult) {
        final String methodName = "GateKeeperPage.searchUnicornWithValidData: ";
        try {
            helperMethods.printInfoMethodStarted(methodName).and().doSendTextAndPressEnter(searchField, expectedUnicornName);
            if (!expectedUnicornName.equalsIgnoreCase(Constants.LOST_UNICORN_NAME)) {
                throw new TestToolException("Unicorn name is not correct! -> Search Data: " + expectedUnicornName + " Expected Name: " + Constants.LOST_UNICORN_NAME);
            }
            if (!HelperMethods.doGetText(searchResult).equalsIgnoreCase(expectedSearchResult)) {
                throw new TestToolException(" The search result is not matches with the expected name! -> Expected: " + expectedUnicornName + " Found: " + HelperMethods.doGetText(searchResult));
            }
            helperMethods.refreshPageByWebElement(searchField).and().printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }
    }
    /**
     * Search unicorn with an invalid data
     * @param expectedUnicornInvalidName - invalid unicorn name data
     */
    public static void searchUnicornWithInvalidData(String expectedUnicornInvalidName) {
        final String methodName = "GateKeeperPage.searchUnicornWithInvalidData: ";
        try {
            helperMethods.printInfoMethodStarted(methodName).waitForVisibility(searchField).and().doSendTextAndPressEnter(searchField, expectedUnicornInvalidName);
            if (expectedUnicornInvalidName.equalsIgnoreCase(Constants.LOST_UNICORN_NAME)) {
                throw new TestToolException("Valid unicorn name has been identified! -> Unicorn Name Data In The Test: " + expectedUnicornInvalidName
                        + " Search Result: " + searchResult.getText());
            }
            helperMethods.refreshPageByWebElement(searchField).and().printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }}
    /**
     * Mathematical Operation - First field
     * @param firstInputValue - First input
     */
    public static void fillInputFieldsAndAssertResult(String firstInputValue, String secondInputValue, String expectedValue) {
        final String methodName = "GateKeeperPage.fillInputFieldsAndAssertResult: ";
        try {
            helperMethods.printInfoMethodStarted(methodName).sendText(firstFieldToFillWithValues, firstInputValue).and().sendText(secondFieldToFillWithValues, secondInputValue);
            String result = thirdFieldToAssertValue.getAttribute("value");
            helperMethods.printInfo("Result: " + HelperMethods.doGetText(thirdFieldToAssertValue) + result);
            if (!result.equals(String.valueOf(expectedValue))) {
                throw new TestToolException("First Input: " + firstInputValue + " Second Input: " + secondInputValue + " Expected Result: " + expectedValue
                        + " not found after the assertion! ->" + " Found Value: " + thirdFieldToAssertValue.getAttribute("value"));
            }
            helperMethods.refreshPageByWebElement(firstFieldToFillWithValues).and().printInfoMethodEnded(methodName);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed! " + e.getCause());
        }}
    /**
     * Mathematical Operation Performance Method
     * @param numberOfData - Number of data which will be sent to the page
     * @param expectedTime - which will be used to verify if numberOfData has been sent and verified before in defined time
     * @param sectionName  - Section Name
     */
    public static void performanceTestFunctionOnCalculator(String numberOfData, Integer expectedTime, String sectionName) {
        final String methodName = "GateKeeperPage.performanceTestFunctionOnCalculator ";
        DateTime dt1 = new DateTime();
        int getSecondsBeforePefTest = dt1.getSecondOfDay();
        helperMethods.printInfo("[Get Seconds Of Day Before Peformance Test: " + getSecondsBeforePefTest);

        //Generate random int value between [-50 and +900]
        int firstRandomNumber = helperMethods.getRandomNumberUsingNextInt(-50, 900);
        int secondRandomNumber = helperMethods.getRandomNumberUsingNextInt(-50, 900);
        helperMethods.printInfoMethodStarted(methodName);

        verifySectionName(sectionName);
        for (int i = 1; i < Integer.parseInt(numberOfData); i++) {
            String firstInput = String.valueOf(i * firstRandomNumber);
            String secondInput = String.valueOf(i * secondRandomNumber);
            int result = (i * firstRandomNumber) + (i * secondRandomNumber);
            fillInputFieldsAndAssertResult(firstInput, secondInput, String.valueOf(result));
        }

        DateTime dt2 = new DateTime();
        int getSecondsAfterPefTest = dt2.getSecondOfDay();
        helperMethods.printInfo("Get Seconds Of Day After Peformance Test: " + getSecondsAfterPefTest);
        int timeDifferenceAfterPerformanceTest = getSecondsAfterPefTest - getSecondsBeforePefTest;
        helperMethods.printInfo(timeDifferenceAfterPerformanceTest + " seconds passed after the peformance Test: ");
        if (timeDifferenceAfterPerformanceTest >= expectedTime) {
            throw new TestToolException(methodName + "failed! [" + timeDifferenceAfterPerformanceTest + " seconds] took to verify " + numberOfData + " different sorts of random data ->" +
                    " [Expected Time: " + expectedTime + " seconds] -  [Actual Time: " + timeDifferenceAfterPerformanceTest + " seconds]");
        }
    }}










