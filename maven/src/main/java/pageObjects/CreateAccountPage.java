package pageObjects;

import org.openqa.selenium.WebDriver;

import utility.Constant;

public class CreateAccountPage {
	private WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean verifyCreateAccountPageTitle(){
		return driver.getTitle().contains(Constant.createAccountPageTitle);
	}
}
