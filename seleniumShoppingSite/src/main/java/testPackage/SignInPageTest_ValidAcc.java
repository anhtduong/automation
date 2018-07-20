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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.SignInPage;
import utility.Constant;
import utility.Log;
import utility.ReadWriteJSON;

import java.io.IOException;
import java.util.Iterator;

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
	

	@Test(dataProvider = "valid_accounts")
	public void signInValidAccount(String email, String password) {
		Log.startTest(Constant.testNameEnum.SIGN_IN_VALID_ACC.name());
		homePage.navigateSignInPage(driver);
		assertTrue(signInPage.verifySignInPageTitle(),"Sign-in page title not matching");
		signInPage.signIn(driver, email, password);
		try {
			assertTrue(myAccountPage.verifyMyAccountPageTitle(), "My account page title not matching");
		}catch (Throwable t){
			Log.error("Error on sign-in page. Unable to navigate my account page");
			Assert.fail("Error on sign-in page. Unable to navigate my account page");
		}

		Log.endTest(Constant.testNameEnum.SIGN_IN_VALID_ACC.name());
	}
	@DataProvider
	public static Iterator<Object[]> valid_accounts()throws IOException {
		return ReadWriteJSON.getValidAccounts();
	}

	

}
