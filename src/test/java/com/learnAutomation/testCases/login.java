package com.learnAutomation.testCases;

import com.learnAutomation.constants.constants;
import com.learnAutomation.dataProvider.configReader;
import com.learnAutomation.dataProvider.dataProvider;
import com.learnAutomation.helper.baseClass;

import com.learnAutomation.pages.loginPage;


import org.testng.Assert;
import org.testng.annotations.Test;



public class login extends baseClass {

//(dataProvider = "loginTestApp", dataProviderClass = dataProvider.class)
    @Test
    public  void loginTes(){
        //creating object of loginPage

        loginPage page = new loginPage(driver);
        //passing values
        page.loginToApp(configReader.getProperty("username"),configReader.getProperty("password"));

        //chcecking actual error test .......
        boolean status =page.getErrorMsg().contains(constants.userDoesNotExits);
        page.getErrorMsg().contains(constants.emptyPassword);
        page.getErrorMsg().contains(constants.userPassMisMatch);
        Assert.assertTrue(status,"Error message is displayed as expected");


    }
}
