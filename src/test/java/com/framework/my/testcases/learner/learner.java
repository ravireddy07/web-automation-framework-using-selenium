package com.framework.my.testcases.learner;

import com.framework.my.PageObjects.LoginPage;
import org.testng.annotations.Test;

import static com.framework.my.BaseTest.driver;

public class learner {

    @Test
    public void testcase1(){
        LoginPage objLoginPage = new LoginPage(driver);
    }
}
