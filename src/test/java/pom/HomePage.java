package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class HomePage
{
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "email")
    public WebElement userName;

    @FindBy (xpath = "//span[contains(text(),'Log in to Facebook')]")
    public WebElement titleLogin;

    @FindBy (id = "twotabsearchtextbox")
    public WebElement amazonTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement amazonSearchIcon;

    @FindBy (xpath = "//a[contains(@class,'sc-1or3vea-8 fdbMVZ')]")
    public WebElement bookMyShowIcon;
}
