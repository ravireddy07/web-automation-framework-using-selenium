package ravireddy07.com.github.testcases.admin;

import org.json.simple.*;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import ravireddy07.com.github.utils.JsonParser;

public class admin extends BaseTest {
    @Test(enabled = true)
    @Description("Sign in to LMS through Admin Credentials")
    public void validateAdminTabs1() throws Exception {
        try {
            JSONObject loginData = JsonParser.getTestData();
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.enterEmail(loginData.get("adminEmail").toString());
            objLoginPage.enterPassword(loginData.get("password").toString());
            objLoginPage.clickSignInButton();
            objLoginPage.clickCoursesTab();
            objLoginPage.clickPathsTab();
            objLoginPage.clickEventsTab();
            objLoginPage.clickInsightsTab();
            objLoginPage.clickBranchTab();
            objLoginPage.clickReportsTab();
            objLoginPage.clickForumTab();
            objLoginPage.clickPeopleTab();
            objLoginPage.clickHomeTab();
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
            LoginPage objLoginPage = new LoginPage(driver);
            objLoginPage.enterEmail(loginData.get("adminEmail").toString());
            objLoginPage.enterPassword(loginData.get("password").toString());
            objLoginPage.clickSignInButton();
            objLoginPage.clickCoursesTab();
            objLoginPage.clickPathsTab();
            objLoginPage.clickEventsTab();
            objLoginPage.clickInsightsTab();
            objLoginPage.clickBranchTab();
            objLoginPage.clickReportsTab();
            objLoginPage.clickForumTab();
            objLoginPage.clickPeopleTab();
            objLoginPage.clickHomeTab();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
