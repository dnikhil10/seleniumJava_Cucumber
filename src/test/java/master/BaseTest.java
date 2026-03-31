package master;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest
{
    protected static WebDriver driver;

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");   // run in headless mode
        options.addArguments("--disable-gpu");   // recommended for CI
        options.addArguments("--no-sandbox");    // required in some CI environments
        options.addArguments("--disable-dev-shm-usage"); // helps avoid resource issues

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }



}
