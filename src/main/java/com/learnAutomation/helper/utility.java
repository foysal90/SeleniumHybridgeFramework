package com.learnAutomation.helper;

import com.learnAutomation.dataProvider.configReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class utility
{
       public  static WebElement  waitForElement(WebDriver driver, By locator)
       {
              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
              WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
              if (configReader.getProperty("hoghlightElement").contains("true"))
              {
                     return  highlightWebElement(driver,element);
              }
              else
              {
                     return element;
              }



       }

       public static void wait(int second)
       {
              try {
                     Thread.sleep(second*1000);
              } catch (InterruptedException e) {
                     System.out.println("Something went wrong .."+ e.getMessage());
              }
       }

       public static WebElement highlightWebElement(WebDriver driver,WebElement ele)
       {

              JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border: solid 2px red')",ele);
              utility.wait(1);
              js.executeScript("arguments[0].setAttribute('style', 'border: solid 2 black')",ele);

              return ele;
       }




}
