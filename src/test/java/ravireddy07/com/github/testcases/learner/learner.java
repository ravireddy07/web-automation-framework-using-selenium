package ravireddy07.com.github.testcases.learner;

import org.json.simple.*;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ravireddy07.com.github.utils.JsonParser;

public class learner extends BaseTest {
    @Test(enabled = true)
    @Description("Sign in to LMS through Learner Credentials")
    public void validateLearnerTabs1() throws Exception {
        try {
            JSONObject loginData = JsonParser.getTestData();
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.enterEmail(loginData.get("learnerEmail").toString());
            objLoginPage.enterPassword(loginData.get("password").toString());
            objLoginPage.clickSignInButton();
            Assert.assertTrue(objLoginPage.validateInvalidLoginCredentialsToaster());
            objLoginPage.enterPassword(loginData.get("password2").toString());
            objLoginPage.clickSignInButton();
            objLoginPage.clickCoursesTabLearner();
            objLoginPage.clickPathsTabLearner();
            objLoginPage.clickEventsTabLearner();
            objLoginPage.clickForumTab();
            objLoginPage.clickHomeTab();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test(enabled = true)
    @Description("Sign in to LMS through Learner Credentials 2")
    public void validateLearnerTabs2() throws Exception {
        try {
            JSONObject loginData = JsonParser.getTestData();
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.enterEmail(loginData.get("learnerEmail").toString());
            objLoginPage.enterPassword(loginData.get("password").toString());
            objLoginPage.clickSignInButton();
            Assert.assertTrue(objLoginPage.validateInvalidLoginCredentialsToaster());
            objLoginPage.enterPassword(loginData.get("password2").toString());
            objLoginPage.clickSignInButton();
            objLoginPage.clickCoursesTabLearner();
            objLoginPage.clickPathsTabLearner();
            objLoginPage.clickEventsTabLearner();
            objLoginPage.clickForumTab();
            objLoginPage.clickHomeTab();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
