package com.framework.my;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

    public static RemoteWebDriver getDriver() {
        return dr.get();
    }

    public static RemoteWebDriver setWebDriver(RemoteWebDriver driver) {
        dr.set(driver);
        return driver;
    }
}
