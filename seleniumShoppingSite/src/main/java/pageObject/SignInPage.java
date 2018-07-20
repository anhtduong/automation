package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Constant;
import utility.Log;

import java.util.concurrent.TimeUnit;

public class SignInPage {

	private WebDriver _driver;
	private static By emailNewAccountText = By.id("email_create");
	private static By createAccountButton = By.id("SubmitCreate");
	private static By emailText = By.id("email");
	private static By passwordText = By.id("passwd");
	private static By submitLoginButton = By.id("SubmitLogin");
	private static By errorMessage = By.xpath(".//html/body/div/div[2]/div/div[3]/div/div[1]");

	public SignInPage(WebDriver driver) {
		_driver = driver;
		_driver.manage().timeouts().implicitlyWait(Constant.WAIT_MIN_IN_SECOND, TimeUnit.SECONDS);
	}

	public void setEmailAddress(String emailAddress) {
		WebElement element = _driver.findElement(emailText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(emailAddress);
			Log.info("Email address is " + element.getAttribute("value"));
			
		}

		else
			Log.error("SignIn-email not found");
	}
	public String getEmailAddress() {
		return emailText.toString();
	}
	

	public void setPassword(String sPass) {
		WebElement element = _driver.findElement(passwordText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(sPass);
			Log.info("Password populated ");
		}

		else
			Log.error("SignIn-password not found");
	}

	public void setEmailNewAccount(String emailAddress) {
		WebElement element = _driver.findElement(emailNewAccountText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(emailAddress);
			Log.info("Email address is " + element.getAttribute("value"));
		}

		else
			Log.error("Create New Account - email not found");
	}

	public void clickLoginButton() {
		WebElement element = _driver.findElement(submitLoginButton);
		if (element.isDisplayed() || element.isEnabled()) {
			Log.info("Clicking on Login button");
			element.click();
			if (verifySignInError()) {
				Log.info("Signing with invalid email or/and password");
			}
		}
		else {
			Log.error("Login button not found");
		}

	}

	public void clickCreateAccountButton() {
		WebElement element = _driver.findElement(createAccountButton);
		if (element.isDisplayed() || element.isEnabled()) {
			element.click();
			Log.info("Clicking on Create Account button");
		}

		else
			Log.error("Create Account button not found");
	}
	// Sign in successfully, navigate MyAccount page
	// Need to improve with Data-driven
	public MyAccountPage signIn(WebDriver driver, String email, String password) {

		setEmailAddress(email);
		setPassword(password);
		clickLoginButton();
		return new MyAccountPage(driver);
	}
	
	// navigate Create-Account page
	public CreateAccountPage navigateNewAccountPage(WebDriver driver, String email) {
		setEmailNewAccount(email);
		clickCreateAccountButton();
		return new CreateAccountPage(driver);
	}

	public boolean verifySignInPageTitle() {
		Log.info("Sign-in page navigating");
		return _driver.getTitle().trim().contains(Constant.signInPageTitle);
	}

   	public boolean verifySignInError() {
		WebElement  elementError = _driver.findElement(errorMessage);
		if (elementError.isDisplayed()||elementError.isEnabled()) {
		    Log.info(elementError.getText());
			return true;
		}
		return false;
	}
    public boolean verifyCreateAccountPageTitle() {
        Log.info("Create account page navigating");
        return _driver.getTitle().trim().contains(Constant.createAccountPageTitle);
    }

}
