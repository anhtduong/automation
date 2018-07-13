/**
 * Author: Anh Duong
 * Test: Sign-in system with valid account
 * Step1: Launch browser
 * Step2: Load the web site.
 * Step3: Click Sign-in to navigate Sign-in page.Ensure Sign-in page is loaded.
 * Step4: Populate invalid email address or password
 * Step5: Click Sign-in button. Sign-in page retains. Error message is displayed.
*/
package testPackage;

import appModule.TestBaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SignInPage;
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
		Assert.assertTrue(signInPage.verifySignInPageTitle(),"Sign-in page title not matching");
		signInPage.signIn(driver, Constant.sheetSignInNotValidData);
		Assert.assertTrue(signInPage.verifySignInError(), "SignedInWithInvalidAccount failed");
		Log.endTest("Sign-in with invalid account");
	}

}
