package com.framework.my.PageObjects;

import com.aventstack.extentreports.Status;
import com.framework.my.BaseTest;
import com.framework.my.utils.ExtentReport;
import com.framework.my.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    TestUtils utils = new TestUtils();
    WebElement element = null;

    public static final By bySignInButton = By.xpath("//span[text()='Sign in']/ancestor::button[@data-testid='login-submit-btn']");
    public static final By bySignInSSOButton = By.xpath("//span[text()='Sign in with single sign on']/ancestor::button[@data-testid='normal-btn']");
    public static final By loginUsername = By.xpath("//div[@data-testid='login-username']/child::input");
    public static final By loginPassword = By.xpath("//div[@data-testid='login-password']/child::input");

    public void enterEmail(String userName) throws Exception {
        try {
            element = driver.findElement(loginUsername);
            element.clear();
            element.sendKeys(userName);
            utils.log().info("Entered Email Address Successfully");
            ExtentReport.getTest().log(Status.INFO, "Entered Email Address Successfully");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Enter Email Address");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Enter Email Address");
            throw new Exception("Error: Unable to Enter Email Address");
        }
    }

    public void enterPassword(String password) throws Exception {
        try {
            element = driver.findElement(loginPassword);
            element.clear();
            element.sendKeys(password);
            utils.log().info("Entered Password Successfully");
            ExtentReport.getTest().log(Status.INFO, "Entered Password Successfully");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Enter Password");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Enter Password");
            throw new Exception("Error: Unable to Enter Password");
        }
    }

    public void clickSignInButton() throws Exception {
        try {
            driver.findElement(bySignInButton).click();
            utils.log().info("Clicked on Sign in Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Sign in Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Sign in Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Sign in Button");
            throw new Exception("Error: Unable to Click on Sign in Button");
        }
    }

    public void clickSSOSignIn() throws Exception {
        try {
            driver.findElement(bySignInSSOButton).click();
            utils.log().info("Clicked on Sign in with SSO Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Sign in with SSO Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Sign in with SSO Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Sign in with SSO Button");
            throw new Exception("Error: Unable to Click on Sign in with SSO Button");
        }
    }
}
