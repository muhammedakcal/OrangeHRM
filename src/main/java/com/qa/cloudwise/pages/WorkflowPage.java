package com.qa.cloudwise.pages;


import com.qa.cloudwise.TestToolException;
import com.qa.cloudwise.utils.HelperMethods;
import com.qa.cloudwise.utils.JavaScriptUtil;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;

import java.util.*;


import static com.qa.cloudwise.base.BasePage.driver;
import static com.qa.cloudwise.utils.HelperMethods.*;


public class WorkflowPage {

    private static final List<String> employeeListInCloudWise = new ArrayList<>();
    public static HelperMethods helperMethods = new HelperMethods();


    public WorkflowPage() {
        PageFactory.initElements(driver, this);
    }

    private static String sectionXpathGenerator(String sectionName) {
        return ".//div[h1='" + sectionName + "' or h2='" + sectionName + "' or h3='" + sectionName + "']";
    }

    /**
     * Verify if the section is visible
     *
     * @param sectionName - that will be using in the x-path to verify section
     */
    public static void verifySectionVisibility(String sectionName) {
        final String methodName = "WorkflowPage.verifySectionVisibility: ";

        try {
            JavaScriptUtil.checkPageIsReady(methodName + sectionName);
            helperMethods.printInfoMethodStarted(methodName).and().printInfoMethodEnded(methodName);

        } catch (NoSuchElementException e) {
            throw new TestToolException("method + sectionName + failed!" + e.getCause());
        }
    }

    /**
     * This function will visit each department and print duplicate names
     */
    public static void visitDepartmentsAndPrintDuplicateNames() {
        final String methodName = "WorkflowPage.visitDepartmentsAndPrintDuplicateNames: ";
        final By flipBox = By.xpath(".//a[@class='nectar-button large see-through']//span");
        final By department = By.xpath("//div[@class='flip-box-front']//h3");
        final By employees = By.xpath("//div[@class='vc_column-inner']//h3");

        try {
            int numberOfDepartments = driver.findElements(flipBox).size();
            helperMethods.printInfoMethodStarted(methodName).printInfo("Number of Departments: " + numberOfDepartments);

            for (int i = 0; i < numberOfDepartments; i++) {
                String departmentName = driver.findElements((department)).get(i).getText();
                helperMethods.moveToElementAndClick(driver.findElements(flipBox).get(i));

                int size = driver.findElements((employees)).size();
                List<String> singleDepartmentEmployeeList = new ArrayList<>();

                for (int y = 0; y < size; y++) {
                    singleDepartmentEmployeeList.add((driver.findElements((employees)).get(y).getText()));
                    employeeListInCloudWise.add((driver.findElements(employees)).get(y).getText());
                }

                helperMethods.printInfo(departmentName + ": --> " + singleDepartmentEmployeeList).and().navigateToBackPage();

            }

            findAndPrintDuplicateNamesInTheList(employeeListInCloudWise);
            findAndPrintTriplicateNamesInTheList(employeeListInCloudWise);
            helperMethods.printInfo("").printInfoMethodEnded(methodName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TestToolException(methodName + " failed: " + e.getCause());
        }

    }


}


