package com.framework.my.testcases.admin;

import com.framework.my.BaseTest;
import com.framework.my.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class admin extends BaseTest {

    @Test(enabled = true)
    @Description("Sign in to LMS")
    public void login1() throws Exception {
        try {
            System.out.println("Started");
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.enterEmail("mobile-stag@getnada.com");
            objLoginPage.enterPassword("Mobile@123");
            objLoginPage.clickSignInButton();
            objLoginPage.clickSignInButton();
            Thread.sleep(2000);
            System.out.println("Ended");
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test(enabled = true)
    @Description("Sign in to LMS 2")
    public void login2() throws Exception {
        try {
            System.out.println("Started");
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.enterEmail("mobile-stag@getnada.com");
            objLoginPage.enterPassword("Mobile@123");
            objLoginPage.clickSignInButton();
            objLoginPage.clickSignInButton();
            Thread.sleep(2000);
            System.out.println("Ended");
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
