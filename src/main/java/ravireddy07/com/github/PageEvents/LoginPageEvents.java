package ravireddy07.com.github.PageEvents;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import ravireddy07.com.github.BaseTest;
import ravireddy07.com.github.PageObjects.HomePageElements;
import ravireddy07.com.github.PageObjects.LoginPageElements;
import ravireddy07.com.github.utils.ExtentReport;
import ravireddy07.com.github.utils.TestUtils;

public class LoginPageEvents extends BaseTest {
    TestUtils utils = new TestUtils();
    Actions objActions;
    WebElement element = null;

    public LoginPageEvents(RemoteWebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
        objActions = new Actions(driver);
    }

    public void enterEmail(String userName) throws Exception {
        try {
            element = driver.findElement(LoginPageElements.loginUsername);
            element.clear();
            driver.findElement(LoginPageElements.loginUsername).sendKeys(userName);
            utils.log().info("Entered the email Address Successfully");
            ExtentReport.getTest().log(Status.INFO, "Entered the email Address Successfully");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Enter Email Address");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Enter Email Address");
            throw new Exception("Error: Unable to Enter Email Address");
        }
    }

    public boolean validateEnteredEmail(String userName) throws Exception {
        String text = driver.findElement(LoginPageElements.loginUsername).getText();
        System.out.println(text);
        utils.log().info(text);
        try {
            if(text.equalsIgnoreCase(userName)) {
                utils.log().info("Entered Email Address is validated successfully");
                ExtentReport.getTest().log(Status.INFO, "Entered Email Address is validated successfully");
                return true;
            }
            utils.log().info("Entered Email Address is NOT validated successfully");
            ExtentReport.getTest().log(Status.INFO, "Entered Email Address is NOT validated successfully");
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to find entered email address");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to find entered email address");
            throw new Exception("Error: Unable to find entered email address");
        }
    }

    public void enterPassword(String password) throws Exception {
        try {
            element = driver.findElement(LoginPageElements.loginPassword);
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

    public boolean validateInvalidLoginCredentialsToaster() {
        if(driver.findElements(LoginPageElements.byInvalidEmailPass).size() > 0) {
            utils.log().info("Invalid Email or Password toaster found");
            ExtentReport.getTest().log(Status.INFO, "Invalid Email or Password toaster found");
            return true;
        }
        utils.log().info("Invalid Email or Password toaster NOT found");
        ExtentReport.getTest().log(Status.INFO, "Invalid Email or Password toaster NOT found");
        return false;
    }

    public void clickSignInButton() throws Exception {
        try {
            driver.findElement(LoginPageElements.bySignInButton).click();
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
            driver.findElement(LoginPageElements.bySignInSSOButton).click();
            utils.log().info("Clicked on Sign in with SSO Button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Sign in with SSO Button");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Click on Sign in with SSO Button");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Click on Sign in with SSO Button");
            throw new Exception("Error: Unable to Click on Sign in with SSO Button");
        }
    }

    public void hoverTrainingTab() throws Exception {
        try {
            objActions.moveToElement(driver.findElement(HomePageElements.byTrainingDropDown)).build().perform();
            utils.log().info("Hovering on Training Tab");
            ExtentReport.getTest().log(Status.INFO, "Hovering on Training Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Find or Hover on Training Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Find or Hover on Training Tab");
            throw new Exception("Error: Unable to Find or Hover on Training Tab");
        }
    }

    public void hoverAnalyticsTab() throws Exception {
        try {
            objActions.moveToElement(driver.findElement(HomePageElements.byAnalyticsDropDown)).build().perform();
            utils.log().info("Hovering on Analytics Tab");
            ExtentReport.getTest().log(Status.INFO, "Hovering on Analytics Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Find or Hover on Analytics Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Find or Hover on Analytics Tab");
            throw new Exception("Error: Unable to Find or Hover on Analytics Tab");
        }
    }

    public void hoverCompanyTab() throws Exception {
        try {
            objActions.moveToElement(driver.findElement(HomePageElements.byCompanyDropDown)).build().perform();
            utils.log().info("Hovering on Training Tab");
            ExtentReport.getTest().log(Status.INFO, "Hovering on Company Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to Find or Hover on Company Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to Find or Hover on Company Tab");
            throw new Exception("Error: Unable to Find or Hover on Company Tab");
        }
    }

    public void clickHomeTab() throws Exception {
        try {
            driver.findElement(HomePageElements.byHomeTab).click();
            utils.log().info("Clicked on Home Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Home Tab");
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Home Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Home Tab");
            throw new Exception("Error: Unable to click on Home Tab");
        }
    }

    public void clickCoursesTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byTrainingDropDown).size() != 0) {
                hoverTrainingTab();
            }
            driver.findElement(HomePageElements.byCoursesTab).click();
            utils.log().info("Clicked on Courses Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Courses Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Courses Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Courses Tab");
            throw new Exception("Error: Unable to click on Courses Tab");
        }
    }

    public void clickCoursesTabLearner() throws Exception {
        try {
            driver.findElement(HomePageElements.byCoursesTab).click();
            utils.log().info("Clicked on Courses Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Courses Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Courses Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Courses Tab");
            throw new Exception("Error: Unable to click on Courses Tab");
        }
    }

    public void clickPathsTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byTrainingDropDown).size() != 0) {
                hoverTrainingTab();
            }
            driver.findElement(HomePageElements.byPathsTab).click();
            utils.log().info("Clicked on Paths Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Paths Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Paths Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Paths Tab");
            throw new Exception("Error: Unable to click on Paths Tab");
        }
    }

    public void clickPathsTabLearner() throws Exception {
        try {
            driver.findElement(HomePageElements.byPathsTab).click();
            utils.log().info("Clicked on Paths Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Paths Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Paths Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Paths Tab");
            throw new Exception("Error: Unable to click on Paths Tab");
        }
    }

    public void clickEventsTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byTrainingDropDown).size() != 0) {
                hoverTrainingTab();
            }
            driver.findElement(HomePageElements.byEventsTab).click();
            utils.log().info("Clicked on Events Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Events Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Events Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Events Tab");
            throw new Exception("Error: Unable to click on Events Tab");
        }
    }

    public void clickEventsTabLearner() throws Exception {
        try {
            driver.findElement(HomePageElements.byEventsTab).click();
            utils.log().info("Clicked on Events Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Events Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Events Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Events Tab");
            throw new Exception("Error: Unable to click on Events Tab");
        }
    }

    public void clickPeopleTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byCompanyDropDown).size() != 0) {
                hoverCompanyTab();
            }
            driver.findElement(HomePageElements.byPeopleTab).click();
            utils.log().info("Clicked on People Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on People Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on People Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on People Tab");
            throw new Exception("Error: Unable to click on People Tab");
        }
    }

    public void clickInsightsTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byAnalyticsDropDown).size() != 0) {
                hoverAnalyticsTab();
            }
            driver.findElement(HomePageElements.byInsightsTab).click();
            utils.log().info("Clicked on Insights Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Insights Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Insights Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Insights Tab");
            throw new Exception("Error: Unable to click on Insights Tab");
        }
    }

    public void clickReportsTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byAnalyticsDropDown).size() != 0) {
                hoverAnalyticsTab();
            }
            driver.findElement(HomePageElements.byReportsTab).click();
            utils.log().info("Clicked on Reports Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Reports Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Reports Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Reports Tab");
            throw new Exception("Error: Unable to click on Reports Tab");
        }
    }

    public void clickBranchTab() throws Exception {
        try {
            if(driver.findElements(HomePageElements.byCompanyDropDown).size() != 0) {
                hoverCompanyTab();
            }
            driver.findElement(HomePageElements.byBranchTab).click();
            utils.log().info("Clicked on Branches Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Branches Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Branches Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Branches Tab");
            throw new Exception("Error: Unable to click on Branches Tab");
        }
    }

    public void clickForumTab() throws Exception {
        try {
            driver.findElement(HomePageElements.byForumTab).click();
            utils.log().info("Clicked on Forums Tab");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Forums Tab");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch(Exception e) {
            e.printStackTrace();
            utils.log().info("Error: Unable to click on Forums Tab");
            ExtentReport.getTest().log(Status.INFO, "Error: Unable to click on Forums Tab");
            throw new Exception("Error: Unable to click on Forums Tab");
        }
    }
}
