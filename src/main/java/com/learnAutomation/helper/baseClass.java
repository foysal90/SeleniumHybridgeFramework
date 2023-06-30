package com.learnAutomation.helper;

import com.learnAutomation.dataProvider.configReader;
import com.learnAutonmation.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseClass {
   public WebDriver driver;

    @BeforeClass
    public void setupBrowser(){
        //checking if the method run perfecly before running class
        System.out.println("Running baseclass before classs");
        driver= BrowserFactory.startBrowser(configReader.getProperty("browser"),
                configReader.getProperty("url"));

    }
    @AfterClass
    public void tearDown(){
        System.out.println("I am in tearDown class.............");
        driver.close();
        driver.quit();
    }

}
