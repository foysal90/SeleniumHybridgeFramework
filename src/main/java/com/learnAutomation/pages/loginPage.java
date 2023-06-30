package com.learnAutomation.pages;

import com.learnAutomation.helper.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {

    protected  WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver = driver;
    }
   //using POM
    // finding new user link by using locators............
    private By newUserLink = By.linkText("New user? Signup");
    // checking errorMsg............
    private By errorMsg = By.xpath("//h2[@class='errorMessage']");
    //finding username by using locators............
    private By username = By.xpath("//input[@id='email1']");
    //finding password by using locators............
    private By password = By.xpath("//input[@id='password1']");
    //finding sign in btn  by using locators............
    private By loginBtn = By.xpath("//button[normalize-space()='Sign in']");

    // declaring newuserlink method to click on new user ............
    public void  getNewUserLink()
    {
        utility.waitForElement(driver,newUserLink).click();
    }

    public void loginToApp(String uname, String pass){
        utility.waitForElement(driver,username).sendKeys(uname);
        utility.waitForElement(driver,password).sendKeys(pass);
        utility.waitForElement(driver,loginBtn).click();
//        driver.findElement(loginBtn).click();
    }

    public String getErrorMsg() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMsg)));



        //highlighting specific element
        WebElement el = utility.waitForElement(driver,errorMsg);
        String error_msg= utility.highlightWebElement(driver,el).getText();

       return error_msg;
    }
}
