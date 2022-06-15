package ravireddy07.com.github.testcases.amazon;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageEvents.HomePageEvents;

import java.io.IOException;

public class sample extends BaseTest {
    @Test
    public void sampleTestcase() throws IOException, ParseException {
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
