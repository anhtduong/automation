package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.ExcelUtil;
import utility.Log;

public class SignInPage {

	private WebDriver driver;
	private static By emailNewAccountText = By.id("email_create");
	private static By createAccountButton = By.id("SubmitCreate");
	private static By emailText = By.id("email");
	private static By passwordText = By.id("passwd");
	private static By submitLoginButton = By.id("SubmitLogin");
	private static By errorMessage = By.className("alert alert-danger");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setEmailAddress(String emailAddress) {
		WebElement element = driver.findElement(emailText);
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
		WebElement element = driver.findElement(passwordText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(sPass);
			Log.info("Password populated ");
		}

		else
			Log.error("SignIn-password not found");
	}

	public void setEmailNewAccount(String emailAddress) {
		WebElement element = driver.findElement(emailNewAccountText);
		if (element.isDisplayed() || element.isEnabled()) {
			element.clear();
			element.sendKeys(emailAddress);
			Log.info("Email address is " + element.getText());
		}

		else
			Log.error("Create New Account - email not found");
	}

	public void clickLoginButton() {
		WebElement element = driver.findElement(submitLoginButton);
		if (element.isDisplayed() || element.isEnabled()) {
			element.click();
			Log.info("Clicking on Login button");
		}

		else
			Log.error("Login button not found");
	}

	public void clickCreateAccountButton() {
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
	public MyAccountPage signIn(WebDriver driver, String sheetName) {
		ExcelUtil.getExcelFile(sheetName);
		setEmailAddress(ExcelUtil.getCell(1,1));
		setPassword(ExcelUtil.getCell(1,2));
		clickLoginButton();
		ExcelUtil.setCell(1,3,Constant.testOutcome.PASS.name());
		return new MyAccountPage(driver);
	}
	
	// navigate Create-Account page
	public CreateAccountPage navigateCreateAccountPage() {
		setEmailNewAccount("user002@gmail.com");
		clickCreateAccountButton();
		return new CreateAccountPage(driver);
	}

	public boolean verifySignInPageTitle() {
		Log.info("Sign-in page navigating");
		return driver.getTitle().trim().contains(Constant.signInPageTitle);
		
		
	}

	public boolean verifySignInError() {
		WebElement  elementError = driver.findElement(errorMessage);
		if (elementError.isDisplayed()||elementError.isEnabled())
			return true;
		return false;
	}

}
