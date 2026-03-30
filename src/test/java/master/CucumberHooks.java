package master;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks
{
    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Before
    public void setUp(Scenario scenario)
    {
        BaseTest.initializeDriver();
        test = extent.createTest(scenario.getName());

    }

    @AfterStep
    public void captureScreenShot(Scenario scenario)
    {
        try {
            // Capture screenshot as bytes for Cucumber
            final byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

            // Capture screenshot as Base64 for ExtentReports
            String base64Screenshot = ((TakesScreenshot) BaseTest.getDriver())
                    .getScreenshotAs(OutputType.BASE64);

            test.addScreenCaptureFromBase64String(base64Screenshot);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
            // You can also capture screenshot here
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
        BaseTest.quitDriver();
        extent.flush();
        try {
            java.awt.Desktop.getDesktop()
                    .browse(new java.io.File("target/ExtentReport.html").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

