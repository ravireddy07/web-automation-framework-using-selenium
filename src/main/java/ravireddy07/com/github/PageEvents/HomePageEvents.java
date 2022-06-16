package ravireddy07.com.github.PageEvents;

import java.io.IOException;
import java.text.ParseException;

import com.aventstack.extentreports.Status;
import org.json.simple.JSONObject;
import org.testng.Assert;

import ravireddy07.com.github.PageObjects.HomePageElements;
import ravireddy07.com.github.PageObjects.LoginPageElements;
import ravireddy07.com.github.utils.ExtentReport;
import ravireddy07.com.github.utils.FindElements;
import ravireddy07.com.github.utils.JsonParser;

public class HomePageEvents {
    public void validateLoginPageOpenedOrNot() throws InterruptedException {
        FindElements findElement = new FindElements();
        ExtentReport.getTest().log(Status.INFO, "Validating that Login page is opened or not");
        if(findElement.getListWebElements("CLASSNAME", LoginPageElements.loginPageLabelClass).size() > 0) {
            ExtentReport.getTest().log(Status.INFO, "Login page is Opened!");
            Assert.assertTrue(true);
        } else {
            ExtentReport.getTest().log(Status.INFO, "Unexpected: Login page is NOT Opened!");
            Assert.assertTrue(false);
        }
    }

    public void enterEmailID() throws IOException, org.json.simple.parser.ParseException {
        JSONObject loginData = JsonParser.getTestData();
        FindElements findElement = new FindElements();
        findElement.getWebElement("ID", LoginPageElements.emailInputID).sendKeys(loginData.get("sampleEmail").toString());
        ExtentReport.getTest().log(Status.INFO, "Entered Email ID");
    }

    public void enterPassword() throws IOException, org.json.simple.parser.ParseException {
        JSONObject loginData = JsonParser.getTestData();
        FindElements findElement = new FindElements();
        findElement.getWebElement("ID", LoginPageElements.passwordID).sendKeys(loginData.get("samplePassword").toString());
        ExtentReport.getTest().log(Status.INFO, "Entered Email Password");
    }

    public void clickOnSignInButton() {
        FindElements findElement = new FindElements();
        findElement.getWebElement("ID", HomePageElements.signInID).click();
        ExtentReport.getTest().log(Status.INFO, "Clicked on SignIn Button");
    }

    public void clickOnContinueButton() {
        FindElements findElement = new FindElements();
        findElement.getWebElement("ID", LoginPageElements.continueID).click();
        ExtentReport.getTest().log(Status.INFO, "Clicked on Continue Button");
    }

    public void clickOnSignInSubmitButton() {
        FindElements findElement = new FindElements();
        findElement.getWebElement("ID", LoginPageElements.signInSubmitID).click();
        ExtentReport.getTest().log(Status.INFO, "Clicked on Sign in Submit Button");
    }
}
