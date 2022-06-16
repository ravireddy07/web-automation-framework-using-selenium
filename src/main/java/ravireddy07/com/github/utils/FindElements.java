package ravireddy07.com.github.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ravireddy07.com.github.BaseTest;

public class FindElements {
    public WebElement getWebElement(String type, String value) {
        switch(type) {
            case "data-testID": {
                return BaseTest.driver.findElement(By.xpath(value));
            }
            case "ID": {
                return BaseTest.driver.findElement(By.id(value));
            }
            case "CSS": {
                return BaseTest.driver.findElement(By.cssSelector(value));
            }
            case "TAGNAME": {
                return BaseTest.driver.findElement(By.tagName(value));
            }
            case "CLASSNAME": {
                return BaseTest.driver.findElement(By.className(value));
            }
            default: {
                return null;
            }
        }
    }

    public List<WebElement> getListWebElements(String type, String value) {
        switch(type) {
            case "data-testID": {
                return BaseTest.driver.findElements(By.xpath(value));
            }
            case "ID": {
                return BaseTest.driver.findElements(By.id(value));
            }
            case "CSS": {
                return BaseTest.driver.findElements(By.cssSelector(value));
            }
            case "TAGNAME": {
                return BaseTest.driver.findElements(By.tagName(value));
            }
            case "CLASSNAME": {
                return BaseTest.driver.findElements(By.className(value));
            }
            default: {
                return null;
            }
        }
    }
}
