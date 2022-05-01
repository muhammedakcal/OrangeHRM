package com.qa.stepdefinition;

import com.qa.pages.WorkflowPage;
import io.cucumber.java.en.And;

import static org.testng.AssertJUnit.assertEquals;


public class WorkflowSD {


    /**
     * Verify if the section is visible
     * @param expectedSectionName - that will be using in the x-path to verify section and assertion
     */
    @And("^Workflow: I see the tab section with label: \"([^\"]*)\"$")
    public void bddVerifyTabSection(String expectedSectionName) {
      String actualSectionName  = WorkflowPage.getTextFromTabSection(expectedSectionName);
      assertEquals(actualSectionName, expectedSectionName);

    }

    /**
     * This function will visit each department and print duplicate or triplicate names
     * @param condition - duplicate/triplicate
     */
    @And("^Workflow: I visit departments and print duplicate/triplicate: \"([^\"]*)\" employee names$")
    public void bddvisitDepartmentsAndPrintDuplicateNamest(String condition) {
        WorkflowPage.visitDepartmentsAndPrintDuplicateAndTriplicateNames(condition);
    }


}
