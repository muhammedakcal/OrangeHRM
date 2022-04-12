package com.qa.cloudwise.pages;




import com.qa.cloudwise.TestToolException;
import com.qa.cloudwise.utils.HelperMethods;
import com.qa.cloudwise.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;


import java.util.*;

import java.util.stream.Collectors;

import static com.qa.cloudwise.base.BasePage.driver;


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
         HelperMethods.printInfoMethodStarted(methodName);
        try {
            JavaScriptUtil.checkPageIsReady(methodName + sectionName);
        }
        catch (NoSuchElementException e) {
            throw new TestToolException("method + sectionName + failed!"  + e.getCause());
        }
        HelperMethods.printInfoMethodEnded(methodName);
    }

    /**
     * Click Flip Box Element to go to the selected department
     *
     * @param departmentName - Flix-box element is located inside the department. Flip-box x-path will identify the department
     * @param sectionName    - Section Name
     */
    public static void clickFlipBoxInDepartmentDefinedInSection(String flipBoxName, String departmentName, String sectionName) {
        final String methodName = "WorkflowPage.clickFlipBoxInDepartmentDefinedInSection: ";
        final String departmentXpath = "*//div//h3[normalize-space()='" + departmentName + "']";
        final String flipBoxXpath = departmentXpath.concat("//parent::div//parent::div//a//span[contains(text(),'" +flipBoxName + "')]");
        HelperMethods.printInfoMethodStarted(methodName);

       try {
           WebElement department= driver.findElement(By.xpath((departmentXpath)));
           WebElement flipBox= driver.findElement(By.xpath((flipBoxXpath)));
           HelperMethods.moveToElementAndClick(department);
           HelperMethods.moveToElementAndClick(flipBox);

        } catch (NoSuchElementException e) {
            throw new TestToolException(methodName + "failed!" + e.getCause());
        }

        HelperMethods.printInfoMethodEnded(methodName);
    }

    /**
     * This method is creating or using a list to add names into the list in the defined section
     * @param condition - create or use a list
     * @param sectionName - it will be used to verify names under the section
     */
    public static void createOrUseListToAddNamesInDefinedSection(String condition, String sectionName) {
        final String method = "WorkflowPage.findDuplicatedNameIntheSection: ";
        final String pageXpath = "//div[@class='inner']//h3";

        HelperMethods.printInfo(method + " start!");
        HelperMethods.isDisplayed( HelperMethods.getElement(By.xpath(sectionXpathGenerator(sectionName))));
        HelperMethods.isDisplayed(HelperMethods.getElement(By.xpath(pageXpath)));

        if (condition.equalsIgnoreCase("create")) {
            listForSavingNamesInTheSection = HelperMethods.getElement(By.xpath(sectionXpathGenerator(sectionName))).findElements(By.xpath(pageXpath))
                    .stream().map(WebElement::getText).collect(Collectors.toList()); }

        else if(condition.equalsIgnoreCase("use")){
            listForSavingNamesInTheSection.addAll( HelperMethods.getElement(By.xpath(sectionXpathGenerator(sectionName))).findElements(By.xpath(pageXpath))
                    .stream().map(WebElement::getText).collect(Collectors.toList()));
        }

        else {
            throw new TestToolException("The condition should be 'create' or 'use''! -> " + condition);
        }

        HelperMethods.printInfo(method + "Names in the List Placed On " + sectionName + " Section: " + listForSavingNamesInTheSection);
        HelperMethods.printInfo(method + " end!");
    }

    /**
     * - This function will print the duplicate names (It's available to see these names
     *  in the command prompt at the end of the test. These names can also be added to the log message
     *  when this project is integrated with CI Platform.(such as Jenkins)
     * - "WorkflowPage.createOrUseListToAddNamesInDefinedSection" method-created list
     */
    public static void outputDuplicateNamesInTheList() {
        final String methodName = "WorkflowPage.outputTheDuplicateNamesInTheList: ";
        HelperMethods.printInfoMethodStarted(methodName);
        Set<String> result = HelperMethods.findDuplicateBySetAdd(listForSavingNamesInTheSection);
        HelperMethods.printInfoMethodEnded(methodName);
        HelperMethods.printInfo(methodName+ "Duplicate Names: " + result.toString());
    }

    /**
     * This function is checking if names (which have been listed) are duplicated in the list:
     * @param sectionName - Section Name
     */
    public static void verifyIfThereAreNoDuplicateNamesInTheSection(String sectionName) {
        final String methodName = "WorkflowPage.verifyIfThereAreNoDuplicateNamesInTheSection: ";
        final String namesInTheSectionXpath = ("//div[@class='inner']//h3");
        HelperMethods.printInfoMethodStarted(methodName);
        HelperMethods.waitForVisibility(HelperMethods.getElement(By.xpath(sectionXpathGenerator(sectionName))));

        try {
            List<WebElement> list = HelperMethods.getElement(By.xpath(sectionXpathGenerator(sectionName))).
                    findElements(By.xpath(namesInTheSectionXpath));
            HelperMethods.printInfo("The size of the list is : " + list.size());

            if (!HelperMethods.verifyIfThereIsNoDuplicatedNameInList(list)) {
                throw new TestToolException(sectionName + " has a duplicated name! -> " + list);
            }
        }

        catch (Exception e) {
            throw new TestToolException(methodName + "failed! " + e.getCause());
        }

        HelperMethods.printInfoMethodEnded(methodName);


    }


}
