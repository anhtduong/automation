package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.Log;

public class SignInPage {

	private WebDriver driver;
	private static By emailNewAccountText = By.id("email_create");
	private static By createAccountButton = By.id("SubmitCreate");
	private static By emailText = By.id("email");
	private static By passwordText = By.id("passwd");
	private static By submitLoginButton = By.id("SubmitLogin");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	private void enterEmailAddress(String emailAddress) {
		WebElement element = driver.findElement(emailText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(emailAddress);
			Log.info("Email address is " + element.getAttribute("value"));
			System.out.println(element.getAttribute("value"));
			System.out.println(element.getText());
		}

		else
			Log.error("SignIn-email not found");
	}

	private void enterPassword(String sPass) {
		WebElement element = driver.findElement(passwordText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(sPass);
			Log.info("Password populated ");
		}

		else
			Log.error("SignIn-password not found");
	}

	private void enterEmailNewAccount(String emailAddress) {
		WebElement element = driver.findElement(emailNewAccountText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(emailAddress);
			Log.info("Email address is " + element.getText());
		}

		else
			Log.error("Create New Account - email not found");
	}

	private void clickLoginButton() {
		WebElement element = driver.findElement(submitLoginButton);
		if (element.isDisplayed() || element.isEnabled()) {
			element.click();
			Log.info("Clicking on Login button");
		}

		else
			Log.error("Login button not found");
	}

	private void clickCreateAccountButton() {
		WebElement element = driver.findElement(createAccountButton);
		if (element.isDisplayed() || element.isEnabled()) {
			element.click();
			Log.info("Clicking on Create Account button");
		}

		else
			Log.error("Create Account button not found");
	}
	// Sign in successfully, navigate MyAccount page
	// Need to improve with Data-driven
	public MyAccountPage signIn(WebDriver driver) {
		enterEmailAddress("user001@gmail.com");
		enterPassword("password01");
		clickLoginButton();
		return new MyAccountPage(driver);
	}

	// navigate Create-Account page
	public CreateAccountPage navigateCreateAccountPage() {
		enterEmailNewAccount("user002@gmail.com");
		clickCreateAccountButton();
		return new CreateAccountPage(driver);
	}

	public boolean verifySignInPageTitle() {
		Log.info("Sign-in page navigating");
		return driver.getTitle().trim().contains(Constant.signInPageTitle);
		
		
	}

}
