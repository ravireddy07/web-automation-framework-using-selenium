package ravireddy07.com.github.testcases.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageEvents.HomePageEvents;

public class sample extends BaseTest {
    @Test(enabled = true)
    public void sampleTestcase() {
        try {
            HomePageEvents objHomePage = new HomePageEvents();
            objHomePage.clickOnSignInButton();
            objHomePage.validateLoginPageOpenedOrNot();
            objHomePage.enterEmailID();
            objHomePage.clickOnContinueButton();
            objHomePage.enterPassword();
            objHomePage.clickOnSignInSubmitButton();
        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
