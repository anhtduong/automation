/**
 * Author: Anh Duong
 * Test: Sign-in system with valid account
 * Step1: Launch browser
 * Step2: Load the web site.
 * Step3: Click Sign-in to navigate Sign-in page.Ensure Sign-in page is loaded.
 * Step4: Populate valid email address 
 * Step5: Populate valid password
 * Step6: Click Sign-in button. Ensure My Account page is loaded.
*/
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appModule.TestBaseSetup;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;
import utility.Log;

public class SignInPageTest extends TestBaseSetup {
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;

	@BeforeClass
	public void setUP() {
		driver = getDriver();
	}
	
	@Test
	public void verifySignInValidAccount() {
		Log.startTest("Sign-in with valid account");
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		myAccountPage = new MyAccountPage(driver);
		homePage.navigateSignInPage(driver);
		Assert.assertTrue("Sign-in page title not matching", signInPage.verifySignInPageTitle());
		signInPage.signIn(driver);
		Assert.assertTrue("My account page title not matching", myAccountPage.verifyMyAccountPageTitle() );
		Log.endTest("Sign-in with valid account");
	}
	@Test
	public void verifySignInInvalidAccount() {
		
	}

}
