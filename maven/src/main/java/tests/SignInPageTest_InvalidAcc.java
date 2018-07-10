/**
 * Author: Anh Duong
 * Test: Sign-in system with valid account
 * Step1: Launch browser
 * Step2: Load the web site.
 * Step3: Click Sign-in to navigate Sign-in page.Ensure Sign-in page is loaded.
 * Step4: Populate invalid email address or password
 * Step5: Click Sign-in button. Sign-in page retains. Error message is displayed.
*/
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appModule.TestBaseSetup;

import junit.framework.Assert;
import pageObjects.HomePage;

import pageObjects.SignInPage;
import utility.Constant;
import utility.Log;

public class SignInPageTest_InvalidAcc extends TestBaseSetup {
	private WebDriver driver;
	private HomePage homePage ;
	private SignInPage signInPage ;


	@BeforeClass
	public void setUP() {
		driver = getDriver();
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
	
	}
	
	@Test
	public void signInNotValidAccount() {
		Log.startTest("Sign-in with invalid account");
		homePage.navigateSignInPage(driver);
		Assert.assertTrue("Sign-in page title not matching", signInPage.verifySignInPageTitle());
		signInPage.signIn(driver, Constant.sheetSignInNotValidData);
		Assert.assertTrue("SignedInWithInvalidAccount failed", signInPage.verifySignInError());
		Log.endTest("Sign-in with invalid account");
	}

}
