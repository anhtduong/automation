package pageObjects;

import org.openqa.selenium.WebDriver;


import utility.Constant;
import utility.Log;
public class MyAccountPage {
	private WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean verifyMyAccountPageTitle() {
		Log.info("My Account page navigating");
		return driver.getTitle().trim().contains(Constant.myAccountPageTitle);
	}
}
