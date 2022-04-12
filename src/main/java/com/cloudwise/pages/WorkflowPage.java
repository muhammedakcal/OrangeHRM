package com.cloudwise.pages;




import error.TestToolException;
import com.cloudwise.utils.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;


import java.util.*;

import java.util.stream.Collectors;

import static com.cloudwise.base.BasePage.driver;


import static com.cloudwise.pages.MenuPage.closeCookies;
import static com.cloudwise.utils.HelperMethods.*;
import static com.cloudwise.utils.JavaScriptUtil.checkPageIsReady;



public class WorkflowPage {

    private static List<String> listForSavingNamesInTheSection = null;
    private static String sectionXpathGenerator(String sectionName){
        return ".//div[h1='" + sectionName + "' or h2='" + sectionName + "' or h3='" + sectionName + "']";
    }

    public WorkflowPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify if the section is visible
     * @param sectionName - that will be using in the x-path to verify section
     */
    public static void verifySectionVisibility(String sectionName) {
        final String methodName = "WorkflowPage.verifySectionVisibility: ";
         printInfoMethodStarted(methodName);
        try {
            checkPageIsReady(methodName + sectionName);
        }
        catch (NoSuchElementException e) {
            throw new TestToolException("method + sectionName + failed!"  + e.getCause());
        }
        printInfoMethodEnded(methodName);
    }

    /**
     * Click Flip Box Element to go to the department that
     *
     * @param departmentName - Flix-box element is located inside the department. Flip-box x-path will identify the department
     * @param sectionName    - Section Name
     */
    public static void clickFlipBoxInDepartmentDefinedInSection(String flipBoxName, String departmentName, String sectionName) {
        final String methodName = "WorkflowPage.clickFlipBoxInDepartmentDefinedInSection: ";
        final String departmentXpath = "*//div//h3[normalize-space()='" + departmentName + "']";
        final String flipBoxXpath = departmentXpath.concat("//parent::div//parent::div//a//span[contains(text(),'" +flipBoxName + "')]");
        printInfoMethodStarted(methodName);

       try {
           WebElement department= driver.findElement(By.xpath((departmentXpath)));
           WebElement flipBox= driver.findElement(By.xpath((flipBoxXpath)));
           moveToElementAndClick(department);
           moveToElementAndClick(flipBox);

        } catch (NoSuchElementException e) {
            throw new TestToolException(methodName + "failed!" + e.getCause());
        }

        printInfoMethodEnded(methodName);
    }

    /**
     * This method is creating or using a list to add names into the list in the defined section
     * @param condition - create or use a list
     * @param sectionName - it will be used to verify names under the section
     */
    public static void createOrUseListToAddNamesInDefinedSection(String condition, String sectionName) {
        final String method = "WorkflowPage.findDuplicatedNameIntheSection: ";
        final String pageXpath = "//div[@class='inner']//h3";

        printInfo(method + " start!");
        isDisplayed( getElement(By.xpath(sectionXpathGenerator(sectionName))));
        isDisplayed(getElement(By.xpath(pageXpath)));

        if (condition.equalsIgnoreCase("create")) {
            listForSavingNamesInTheSection = getElement(By.xpath(sectionXpathGenerator(sectionName))).findElements(By.xpath(pageXpath))
                    .stream().map(WebElement::getText).collect(Collectors.toList()); }

        else if(condition.equalsIgnoreCase("use")){
            listForSavingNamesInTheSection.addAll( getElement(By.xpath(sectionXpathGenerator(sectionName))).findElements(By.xpath(pageXpath))
                    .stream().map(WebElement::getText).collect(Collectors.toList()));
        }

        else {
            throw new TestToolException("The condition should be create or user! ");
        }

        printInfo(method + "Names in the List Placed On " + sectionName + " Section: " + listForSavingNamesInTheSection);
        printInfo(method + " end!");
    }

    /**
     * - This function prints duplicate names
     * - "WorkflowPage.createOrUseListToAddNamesInDefinedSection" method-created list
     */
    public static void outputDuplicateNamesInTheList() {
        final String methodName = "WorkflowPage.outputTheDuplicateNamesInTheList: ";
        printInfoMethodStarted(methodName);
        Set<String> result = findDuplicateBySetAdd(listForSavingNamesInTheSection);
        printInfoMethodEnded(methodName);
        printInfo(methodName+ "Duplicate Names: " + result.toString());
    }

    /**
     * This function is checking if names are duplicated in the list.
     * @param sectionName - Section Name
     */
    public static void verifyIfThereAreNoDuplicateNamesInTheSection(String sectionName) {
        final String methodName = "WorkflowPage.verifyIfThereAreNoDuplicateNamesInTheSection: ";
        final String namesInTheSectionXpath = ("//div[@class='inner']//h3");
        printInfoMethodStarted(methodName);
        waitForVisibility(getElement(By.xpath(sectionXpathGenerator(sectionName))));

        try {
            List<WebElement> list = getElement(By.xpath(sectionXpathGenerator(sectionName))).
                    findElements(By.xpath(namesInTheSectionXpath));
            printInfo("The size of the list is : " + list.size());

            if (!HelperMethods.verifyIfThereIsNoDuplicatedNameInList(list)) {
                throw new TestToolException(sectionName + " has a duplicated name!");
            }
        }

        catch (Exception e) {
            throw new TestToolException(methodName + "failed! " + e.getCause());
        }

        printInfoMethodEnded(methodName);


    }


}
