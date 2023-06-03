package com.qa.stepdefinition;


import com.qa.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class HomePageSD {


    @Given("^HomePage: I select: \"([^\"]*)\" from the filter dropdown$")
    public void bddSelectFilterDropdownByText(String filterText) {

        HomePage.selectFilterDropdownByText (filterText);

    }

    @Given("^HomePage: I add to cart/remove: \"([^\"]*)\" the product with name: \"([^\"]*)\" on the home page$")
    public void bddSelectProductInTheCart(String operation, String productName) {

        HomePage.selectProductInTheCart (operation, productName);

    }

    @And("HomePage: I verify that {int} number of products added to the cart")
    public void bddVerifyTheNumberOfItem(int selectedProductNumber) {

        HomePage.verifyTheNumberOfItem (selectedProductNumber);

    }

    @When("^HomePage: I click on the shopping cart button$")
    public void bddClickOnShoppingCart() {
        HomePage.clickOnShoppingCart ();

    }


    @And("^HomePage: I select the operation Continue Shopping/Checkout: \"([^\"]*)\" on the checkout section")
    public void bddSelectFinalOperationOnTheCheckOutProcess(String operationName) {

        HomePage.selectFinalOperationOnTheCheckOutProcess (operationName);

    }

    @And("^Home Page: I verify the page title with: \"([^\"]*)\" on the checkout section$")
    public void bddVerifyErrorMessage(String expected) {
        String actual = HomePage.getCheckOutPageTitle ();
        assertEquals(actual,expected);  }


    @And("^HomePage: I enter the fields on the checkout section$")
    public void bddEnterFieldsOnTheCheckout(DataTable dataTable) {

        List < Map <String, String> > fields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> field : fields) {
            String fieldName = field.get("Field Name");
            String value = field.get("Value");
            // Perform the necessary actions to enter the field with the given value on the checkout section
            HomePage.enterFieldsOnTheCheckout (fieldName, value);
        }

    }

    @And("^Home Page: I click on the button Continue/Cancel: \"([^\"]*)\" on the checkout section$")
    public void bddClickOnButtonOnTheCheckout(String buttonName) {
        HomePage.clickOnButtonOnTheCheckout (buttonName);


}

    @And("^Home Page: I verify total amount: \"([^\"]*)\" on the checkout section$")
    public void bddVerifyTotalPaymentAmount(String expected) {
        String actual = HomePage.extractTotalPaymentAmount ();
        assertEquals(actual,expected);  }

    @And("^Home Page: I click on the button Finish/Cancel: \"([^\"]*)\" on the checkout overview section$")
    public void bddClickOnButtonOnTheCheckoutOverview(String buttonName) {
        HomePage.clickOnButtonOnTheCheckoutOverview (buttonName);


    }

    @And("^Home Page: I verify the message: \"([^\"]*)\" on the checkout complete section")
    public void bddVerifyErrorMessageOnTheCheckoutComplete(String expectedMessage) {
       HomePage.verifyTheMessageOnCheckoutCompleteSection(expectedMessage);

    }

}
