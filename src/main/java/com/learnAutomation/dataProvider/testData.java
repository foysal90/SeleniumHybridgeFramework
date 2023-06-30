package com.learnAutomation.dataProvider;

import com.learnAutomation.helper.baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testData  {

    @Test (dataProvider = "loginTestApp", dataProviderClass = dataProvider.class)
    public void receiverData(String email, String password) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://freelance-learn-automation.vercel.app/login");

        driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        Thread.sleep(1000);
        driver.quit();

    }
}
