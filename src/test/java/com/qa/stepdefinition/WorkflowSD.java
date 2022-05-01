package com.qa.stepdefinition;

import com.qa.pages.WorkflowPage;
import io.cucumber.java.en.And;


public class WorkflowSD {


    /**
     * Verify if the section is visible
     * @param sectionName - that will be using in the x-path to verify section
     */
    @And("^Workflow: I see the section with label: \"([^\"]*)\"$")
    public void bddVerifySection(String sectionName) {
        WorkflowPage.verifySectionVisibility(sectionName);}

    /**
     * This function will visit each department and print duplicate names
     */
    @And("^Workflow: I visit departments and print duplicate and triplicate employee names$")
    public void bddvisitDepartmentsAndPrintDuplicateNamest() {WorkflowPage.visitDepartmentsAndPrintDuplicateNames();}


}
