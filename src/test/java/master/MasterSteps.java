package master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MasterSteps
{

   public void waitFor(long millisec)
   {
       try
       {
           Thread.sleep(millisec);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
   }
   public void waitUntilElementEnabled(WebElement ele , long sec)
   {
       try{
           WebDriverWait wait=new WebDriverWait(BaseTest.getDriver() , Duration.ofSeconds(sec));
           wait.until(ExpectedConditions.elementToBeClickable(ele));
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

   }

   public boolean waitUntilDisplayed(WebElement ele , long sec)
   {
       try {
           WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(sec));
           wait.until(ExpectedConditions.visibilityOf(ele));
           return true;
       }
       catch (Exception e)
       {
           e.printStackTrace();
           return false;
       }

   }

}
