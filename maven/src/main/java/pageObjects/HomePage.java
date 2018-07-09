package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.Log;

public class HomePage {
	private WebDriver driver;
	
	private static By signInLink = By.partialLinkText("Sign");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage navigateSignInPage (WebDriver driver)
	{
		Log.info("Clicking on Sign-in link");
		WebElement signInLinkElement = driver.findElement(signInLink);
		if (signInLinkElement.isDisplayed()|| signInLinkElement.isEnabled())
			signInLinkElement.click();
		else 
			Log.info("Sign-in link not found");
		return new SignInPage(driver);
	}
	public boolean verifyHomePageTitle() {
		Log.info("Home page navigating");
		return driver.getTitle().trim().contains(Constant.homePageTitle);
	}

}
