package ravireddy07.com.github.PageObjects;

import ravireddy07.com.github.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
