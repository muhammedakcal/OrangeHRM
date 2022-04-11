package com.cloudwise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(

       // This plugin creates cucumber reports
        plugin = {"pretty",
        "html:target/site/cucumber-pretty.html",
        "json:target/cucumber.json",
        "junit:target/cucumber-xml-reports/cucumber.xml"},
        snippets = CAMELCASE,  // This creates auto method name in camelCase
        monochrome = true, // If it is set as true, it means that the console output for the Cucumber test are much more readable
       //  if any of the steps in the Feature file is not implemented in the Step Definition file.
       //  A 'dry run' parameter is a part of the @CucumberOptions which is used to configure the test settings
        dryRun = false,
        features = "src/test/resources/features", //  Path to your feature file
        tags = "@All", // Specify tags to be executed
        glue = "com.cloudwise.stepdefinitions" // Specify step definition package name (Note: make sure to have this package on current directory)

)

public class TestRunner {
}
