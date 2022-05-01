package com.qa.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty",
        "html:target/site/cucumber-pretty.html",
        "json:target/cucumber.json",
        "junit:target/cucumber-xml-reports/cucumber.xml"},

        snippets = CAMELCASE,
        monochrome = false,
        features = "src/test/resources/features/Assignment_01/Assignment_01_OutputDuplicateNamesWithinCloudwise.feature",
        tags = "@Assignment_01_OutputDuplicateNames",
        glue = "com.cloudWise.stepdefinition" // Specify step definition package name (Note: make sure to have this package on current directory)

)

public class TestRunner {
}
