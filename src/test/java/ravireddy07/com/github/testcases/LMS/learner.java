package ravireddy07.com.github.testcases.LMS;

import org.json.simple.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import org.testng.asserts.SoftAssert;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageEvents.LoginPageEvents;
import ravireddy07.com.github.utils.JsonParser;

public class learner extends BaseTest {
    LoginPageEvents objLoginPageEvents = new LoginPageEvents(driver);
    SoftAssert softAssert = new SoftAssert();
    @Test(enabled = true)
    @Description("Sign in to LMS through Learner Credentials")
    public void validateLearnerTabs() {
        try {
            JSONObject loginData = JsonParser.getTestData();
            objLoginPageEvents.enterEmail(loginData.get("learnerEmail").toString());
            objLoginPageEvents.enterPassword(loginData.get("password").toString());
            objLoginPageEvents.clickSignInButton();
            softAssert.assertTrue(objLoginPageEvents.validateInvalidLoginCredentialsToaster());
            objLoginPageEvents.enterPassword(loginData.get("password2").toString());
            objLoginPageEvents.clickSignInButton();
            objLoginPageEvents.clickCoursesTabLearner();
            objLoginPageEvents.clickPathsTabLearner();
            softAssert.assertTrue(objLoginPageEvents.validateInvalidLoginCredentialsToaster());
            objLoginPageEvents.clickEventsTabLearner();
            softAssert.assertTrue(objLoginPageEvents.validateInvalidLoginCredentialsToaster());
            objLoginPageEvents.clickForumTab();
            objLoginPageEvents.clickHomeTab();
            softAssert.assertAll();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
