package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import master.BaseTest;
import master.MasterSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pom.HomePage;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MyStepdefs extends MasterSteps {

    HomePage page;

    @Given("User is hits the facebook url")
    public void userIsHitsTheFacebookUrl()
    {
       BaseTest.getDriver().navigate().to("https://www.facebook.com/");
        page= new HomePage(BaseTest.getDriver());
    }

    @When("user is on facebook login page")
    public void userIsOnFacebookLoginPage() throws InterruptedException {
          Thread.sleep(3000);
          Assert.assertTrue(page.titleLogin.isDisplayed());
    }

    @Then("user is displayed with {string} and {string} textbox")
    public void userIsDisplayedWithAndTextbox(String arg0, String arg1)
    {
        Assert.assertTrue(page.userName.isDisplayed());
    }

    @Given("User hits the amazon url")
    public void userHitsTheAmazonUrl() {
        BaseTest.getDriver().navigate().to("https://www.amazon.in/");
        page= new HomePage(BaseTest.getDriver());
        waitFor(5000);
    }

    @When("User see the search text box")
    public void userSeeTheSearchTextBox() {
        Assert.assertTrue(page.amazonTextBox.isDisplayed());
    }

    @Then("User enter {string}")
    public void userEnter(String productType) {

        if (productType.equals("Iphone")) {
            waitUntilElementEnabled(page.amazonTextBox, 05);
            page.amazonTextBox.sendKeys(productType);
        }
        else
        {
            waitUntilElementEnabled(page.amazonTextBox, 05);
            page.amazonTextBox.sendKeys(Keys.EQUALS);
        }
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        Assert.assertTrue(page.amazonSearchIcon.isDisplayed());
        waitUntilElementEnabled(page.amazonSearchIcon,05);
        page.amazonSearchIcon.click();
    }

    @And("get all the options shown in the suggestions")
    public void getAllTheOptionsShownInTheSuggestions()
    {
        waitFor(3000);
       List<WebElement> options=BaseTest.getDriver().findElements(By.xpath("//div[contains(@id , 'sac-autocomplete-results-container')]//div[@role='button']"));
        List<String> text = options.stream()
                .map(WebElement::getText)                  // convert WebElement to String
                .filter(optionText -> optionText.contains("17")) // filter by substring
                .collect(Collectors.toList());
              text.forEach(System.out::println);
    }
}
