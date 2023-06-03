package com.qa.runners;

import com.qa.testutilities.TestUtil;
import com.qa.base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    /**  This step wil be activated before the test scenario */
    @Before
    public void start() { BasePage.initializeDriver(); }

    /** This step wil be activated after the test scenario */
    @After
    public void end(Scenario scenario) {

        byte[] picture;

        if (scenario.isFailed()) {
            // take screenshot and save it in /failed
            picture = TestUtil.takeScreenshot("failed/" + scenario.getName());

        } else {

            // take screenshot and put it in /passed folder
            picture = TestUtil.takeScreenshot("passed/" + scenario.getName());
        }

        scenario.attach(picture, "image/png", scenario.getName());
        BasePage.tearDown();


    }

}
