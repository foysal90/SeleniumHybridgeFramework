package com.learnAutonmation.factory;

import com.learnAutomation.dataProvider.configReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startBrowser(String browserName, String applicationURL){

        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome"))
        {
            ChromeOptions opt = new ChromeOptions();
           if (configReader.getProperty("headless").contains("true"))
           {
               opt.addArguments("--headless=new");
           }

            driver = new ChromeDriver(opt);

        }
        if (browserName.equalsIgnoreCase("Safari") || browserName.equalsIgnoreCase("Safari Browser"))
        {
            driver = new SafariDriver();
        }
        if (browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("edge driver"))
        {
            driver = new EdgeDriver();
        }
        else {
            System.out.println("Sorry we do not support the browser" + browserName + "browser");
        }


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(applicationURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
 
}
