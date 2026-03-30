package master;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
            reporter.config().setReportName("Automation Test Results");
            reporter.config().setDocumentTitle("Test Execution Report");
            reporter.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

}
