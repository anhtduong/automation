package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utility.Constant;
import utility.Log;
public class MyAccountPage {
	private WebDriver driver;
	private static By infoAccount = By.className("info-account");
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean verifySignedInAccount() {
		return driver.findElement(infoAccount).getText().trim().
				contains(Constant.myAccountPageInfo);
		
	}
	public boolean verifyMyAccountPageTitle() {
		Log.info("My Account page navigating");
		System.out.println(driver.getTitle().trim());
		return driver.getTitle().trim().contains(Constant.myAccountPageTitle);
	}
}
