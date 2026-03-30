package master;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            // Save screenshot to file or attach to report
            System.out.println("Screenshot captured for failed test: " + result.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
