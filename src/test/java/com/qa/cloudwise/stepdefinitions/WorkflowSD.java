package com.qa.cloudwise.stepdefinitions;

import com.qa.cloudwise.pages.WorkflowPage;
import io.cucumber.java.en.And;


public class WorkflowSD {


    /**
     * Verify if the section is visible
     *
     * @param sectionName - that will be using in the x-path to verify section
     */
    @And("^Workflow: I see the section with label: \"([^\"]*)\"$")
    public void bddVerifySection(String sectionName) {
        WorkflowPage.verifySectionVisibility(sectionName);

    }




    @And("^Workflow: I go to departments and print out the employee names that have been duplicated$")
    public void bddvisitDepartmentsAndPrintDuplicateNamest() {
        WorkflowPage.visitDepartmentsAndPrintDuplicateNames();
    }


}
