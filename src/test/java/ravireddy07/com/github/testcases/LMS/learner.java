package ravireddy07.com.github.testcases.LMS;

import org.json.simple.*;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageEvents.LoginPageEvents;
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
            LoginPageEvents objLoginPageEvents = new LoginPageEvents(driver);
            objLoginPageEvents.enterEmail(loginData.get("learnerEmail").toString());
            objLoginPageEvents.enterPassword(loginData.get("password").toString());
            objLoginPageEvents.clickSignInButton();
            Assert.assertTrue(objLoginPageEvents.validateInvalidLoginCredentialsToaster());
            objLoginPageEvents.enterPassword(loginData.get("password2").toString());
            objLoginPageEvents.clickSignInButton();
            objLoginPageEvents.clickCoursesTabLearner();
            objLoginPageEvents.clickPathsTabLearner();
            objLoginPageEvents.clickEventsTabLearner();
            objLoginPageEvents.clickForumTab();
            objLoginPageEvents.clickHomeTab();
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
            LoginPageEvents objLoginPageEvents = new LoginPageEvents(driver);
            objLoginPageEvents.enterEmail(loginData.get("learnerEmail").toString());
            objLoginPageEvents.enterPassword(loginData.get("password").toString());
            objLoginPageEvents.clickSignInButton();
            Assert.assertTrue(objLoginPageEvents.validateInvalidLoginCredentialsToaster());
            objLoginPageEvents.enterPassword(loginData.get("password2").toString());
            objLoginPageEvents.clickSignInButton();
            objLoginPageEvents.clickCoursesTabLearner();
            objLoginPageEvents.clickPathsTabLearner();
            objLoginPageEvents.clickEventsTabLearner();
            objLoginPageEvents.clickForumTab();
            objLoginPageEvents.clickHomeTab();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
