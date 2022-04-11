package com.cloudwise.stepdefinitions;
import com.cloudwise.pages.WaitingPage;
import io.cucumber.java.en.When;



public class WaitingSD {

    /**
     * Wait for a certain number of seconds
     * @param time - seconds
     */
    @When("Waiting: I wait for {int} seconds")
    public void bddWaitForSeconds(int time){
        WaitingPage.waitForSeconds(time);
    }

    /**
     * Wait for a certain number of minutes
     * @param time - minutes
     */
    @When("Waiting I wait for {int} minutes")
    public void bddWaitForMinutes(int time){
        WaitingPage.waitForMinutes(time);
    }


    }

