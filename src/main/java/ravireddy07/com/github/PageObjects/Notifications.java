package ravireddy07.com.github.PageObjects;

import ravireddy07.com.github.BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class Notifications extends BaseTest {
    public Notifications(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
