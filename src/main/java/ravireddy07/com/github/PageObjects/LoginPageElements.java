package ravireddy07.com.github.PageObjects;

import org.openqa.selenium.By;

public interface LoginPageElements {
    By bySignInButton = By.xpath("//span[text()='Sign in']/ancestor::button[@data-testid='login-submit-btn']");
    By bySignInSSOButton = By.xpath("//span[text()='Sign in with single sign on']/ancestor::button[@data-testid='normal-btn']");
    By loginUsername = By.xpath("//div[@data-testid='login-username']/child::input");
    By loginPassword = By.xpath("//div[@data-testid='login-password']/child::input");
    By byInvalidEmailPass = By.xpath("//div[@role='alert' and text() ='Uh oh! The email address or password entered is not valid.']");

    String emailInputID = "ap_email";
    String loginPageLabelClass = "a-form-label";
    String continueID = "continue";
    String passwordID = "ap_password";
    String signInSubmitID = "signInSubmit";
}
