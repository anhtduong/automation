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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SignInPage;
import utility.Constant;
import utility.Log;
import utility.ReadWriteJSON;

import java.io.IOException;
import java.util.Iterator;

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
	
	@Test(dataProvider = "invalid_accounts")
	public void signInNotValidAccount(String email, String pass) {
		Log.startTest(Constant.testNameEnum.SIGN_IN_INVALID_ACC.name());
		homePage.navigateSignInPage(driver);
		Assert.assertTrue(signInPage.verifySignInPageTitle(),"Sign-in page title not matching");
		signInPage.signIn(driver, email, pass);
		Assert.assertTrue(signInPage.verifySignInError(), "Testing SignedInWithInvalidAccount failed");
		Log.endTest(Constant.testNameEnum.SIGN_IN_INVALID_ACC.name());
	}
	@DataProvider
	public static Iterator<Object[]> invalid_accounts()throws IOException {
		return ReadWriteJSON.getInValidAccounts();
	}

}
