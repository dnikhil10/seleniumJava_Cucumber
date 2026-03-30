package master;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    protected static WebDriver driver;

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
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
