package com.framework.my.PageObjects;

import com.framework.my.BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseTest {
    public ProfilePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
