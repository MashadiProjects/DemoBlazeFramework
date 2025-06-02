package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:Reports/cucumber-reports.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // For Extent Report

        },
        monochrome = true, // Readable console output
        //tags = "@Demoblaze" // Or specific tags if you want to run subsets
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

