package ravireddy07.com.github;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import ravireddy07.com.github.utils.Constants;
import ravireddy07.com.github.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public static RemoteWebDriver driver = null;

    public BaseTest() {
        this.driver = DriverManager.getDriver();
    }
    Boolean headlessMode = false;
    TestUtils utils = new TestUtils();
    protected static ThreadLocal<String> platform = new ThreadLocal<String>();
    protected static ThreadLocal<String> browserName = new ThreadLocal<String>();

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getBrowserName() {
        return browserName.get();
    }

    public void setBrowserName(String browserName2) {
        browserName.set(browserName2);
    }

    @Parameters({"browserName"})
    @BeforeSuite
    public void beforeSuite(@Optional String browserName) {
        setPlatform("Mac");
        setBrowserName(browserName);
        utils.log().info("Before Suite Executed Successfully");
    }

    @AfterSuite
    public void afterSuite() {
        utils.log().info("After Suite Executed Successfully");
    }

    @BeforeClass
    public void beforeClass() {
        utils.log().info("Before Class Executed Successfully");
    }

    @AfterClass
    public void afterClass() {
        utils.log().info("After Class Executed Successfully");
    }

    @BeforeTest
    public void beforeTest() {
        utils.log().info("Before Test Executed Successfully");
    }

    @AfterTest
    public void afterTest() {
        utils.log().info("After Test Executed Successfully");
    }

    @BeforeGroups
    public void beforeGroups() {
        utils.log().info("Before Groups Executed Successfully");
    }

    @AfterGroups
    public void afterGroups() {
        utils.log().info("After Groups Executed Successfully");
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(@Optional String browserName) {
        driver = driverInitialization(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.launchURL2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait Example
        utils.log().info("Before Method Executed Successfully");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        utils.log().info("After Method Executed Successfully");
    }

    public RemoteWebDriver driverInitialization(String targetBrowser) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(targetBrowser);

            // Selenium Grid
            if(System.getenv("BROWSER_GRID_URL") != null) {
                System.out.println("Running in grid mode with Grid Url: " + System.getenv("BROWSER_GRID_URL"));
                utils.log().info("Running in grid mode with Grid Url: " + System.getenv("BROWSER_GRID_URL"));
                driver = new RemoteWebDriver(new URL(System.getenv("BROWSER_GRID_URL")), capabilities);
            } else {
                // Local
                if(targetBrowser.equalsIgnoreCase("firefox")) {
                    //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "firefox.exe");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    utils.log().info("Firefox Driver Initialized");
                } else if(targetBrowser.equalsIgnoreCase("edge")) {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    utils.log().info("Edge Driver Initialized");
                } else {
                    // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("window-size=1200x600");
                    if(headlessMode) {
                        driver = new ChromeDriver(options);
                    } else {
                        driver = new ChromeDriver();
                    }
                    utils.log().info("Chrome Driver Initialized");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return DriverManager.setWebDriver(driver);
    }
}
