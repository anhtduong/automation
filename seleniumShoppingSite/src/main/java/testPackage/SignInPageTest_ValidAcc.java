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
package testPackage;

import appModule.TestBaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.SignInPage;
import utility.Constant;
import utility.Log;

import static org.testng.Assert.assertTrue;

public class SignInPageTest_ValidAcc extends TestBaseSetup {
	private WebDriver driver;
	private HomePage homePage ;
	private SignInPage signInPage ;
	private MyAccountPage myAccountPage ;

	@BeforeClass
	public void setUP() {
		driver = getDriver();
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		myAccountPage = new MyAccountPage(driver);
	}
	
	@Test
	public void signInValidAccount() {
		Log.startTest("Sign-in with valid account");
		homePage.navigateSignInPage(driver);
		assertTrue(signInPage.verifySignInPageTitle(),"Sign-in page title not matching");
		signInPage.signIn(driver, Constant.sheetSignInValidData);
		assertTrue(myAccountPage.verifyMyAccountPageTitle(),"My account page title not matching" );
		Log.endTest("Sign-in with valid account");
	}
	

}
