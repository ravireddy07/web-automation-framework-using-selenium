package ravireddy07.com.github.testcases.LMS;

import org.json.simple.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageEvents.LoginPageEvents;
import ravireddy07.com.github.utils.JsonParser;

public class admin extends BaseTest {
    LoginPageEvents objLoginPageEvents = new LoginPageEvents(driver);

    @Test(enabled = true)
    @Description("Sign in to LMS through Admin Credentials 2")
    public void validateAdminTabs() {
        try {
            JSONObject loginData = JsonParser.getTestData();
            objLoginPageEvents.enterEmail(loginData.get("adminEmail").toString());
            objLoginPageEvents.enterPassword(loginData.get("password").toString());
            objLoginPageEvents.clickSignInButton();
            objLoginPageEvents.clickCoursesTab();
            objLoginPageEvents.clickPathsTab();
            objLoginPageEvents.clickEventsTab();
            objLoginPageEvents.clickInsightsTab();
            objLoginPageEvents.clickBranchTab();
            objLoginPageEvents.clickReportsTab();
            objLoginPageEvents.clickForumTab();
            objLoginPageEvents.clickPeopleTab();
            objLoginPageEvents.clickHomeTab();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
