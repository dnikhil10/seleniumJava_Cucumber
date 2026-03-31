package runners;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.awt.*;

@CucumberOptions (features = "src/test/resources/Login.feature",
        glue = {"steps" , "master"},
        monochrome = true,
        tags= "@Regression",
        dryRun = false,
        plugin = {"pretty" , "html:target/cucumber-report.html", "json:target/cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests
{

}
