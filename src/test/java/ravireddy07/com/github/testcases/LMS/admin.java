package ravireddy07.com.github.testcases.LMS;

import org.json.simple.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageEvents.LoginPageEvents;
import ravireddy07.com.github.utils.JsonParser;

public class admin extends BaseTest {
    @Test(enabled = true)
    @Description("Sign in to LMS through Admin Credentials")
    public void validateAdminTabs1() throws Exception {
        try {
            JSONObject loginData = JsonParser.getTestData();
            LoginPageEvents objLoginPageEvents = new LoginPageEvents(driver);
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

    @Test(enabled = true)
    @Description("Sign in to LMS through Admin Credentials 2")
    public void validateAdminTabs2() throws Exception {
        try {
            JSONObject loginData = JsonParser.getTestData();
            LoginPageEvents objLoginPageEvents = new LoginPageEvents(driver);
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
