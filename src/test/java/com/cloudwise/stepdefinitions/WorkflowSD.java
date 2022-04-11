package com.cloudwise.stepdefinitions;
import com.cloudwise.pages.WorkflowPage;
import io.cucumber.java.en.And;



public class WorkflowSD {


    /**
     * Verify if the section is visible
     * @param sectionName - that will be using in the x-path to verify section
     */
    @And("^Workflow: I see the section with label: \"([^\"]*)\"$")
    public void bddVerifySection(String sectionName){
        WorkflowPage.verifySectionVisibility(sectionName);

    }

    /**
     * Click Flip Box Element to go to the department that
     *
     * @param departmentName - Flix-box element is located inside the department. Flip-box x-path will identify the department
     * @param sectionName    - Section Name
     */
    @And("^Workflow: I click on the flip-box button with name: \"([^\"]*)\" inside the department: \"([^\"]*)\" placed on section having label: \"([^\"]*)\"$")
    public void bddClickFlipBoxInDepartmentDefinedInSection(String buttonName, String departmentName, String sectionName)
    {WorkflowPage.clickFlipBoxInDepartmentDefinedInSection(buttonName,departmentName,sectionName);

    }

    /**
     * This function is checking if names are duplicated in the list.
     * @param sectionName - Section Name
     */
    @And("^Workflow: I verify that there are no duplicate names placed on section having label: \"([^\"]*)\"$")
    public void bddVerifyThereAreNoDuplicateNamesInSection( String sectionName)
    {WorkflowPage.verifyIfThereAreNoDuplicateNamesInTheSection(sectionName);

    }

    /**
     * This method is creating or using a list to add names into the list in the defined section
     *
     * @param condition   - create or use a list
     * @param sectionName - it will be used to verify names under the section
     */
    @And("^Workflow: I create/use: \"([^\"]*)\" a list to store the names placed on section having label: \"([^\"]*)\"$")
    public void bddCreateOrUseListToAddNamesInDefinedSection(String condition, String sectionName)
    {WorkflowPage.createOrUseListToAddNamesInDefinedSection(condition, sectionName);

    }

    /**
     * This function prints duplicate names from the "WorkflowPage.createOrUseListToAddNamesInDefinedSection" method-created list
     * Reference: "WorkflowSD.bddCreateOrUseListToAddNamesInDefinedSection)
     */
    @And("^Workflow: I print out the names that were stored in the list that were duplicated$")
    public void bddOutputDuplicateNamesInTheList()  {WorkflowPage.outputDuplicateNamesInTheList();
    }





}
