package seleniumwjava.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModule.TestBaseSetup;
import utility.Constant;
import utility.Log;

public class PageObjectsExample {
	private static WebDriver driver = null;

	@Test
	public void Test() throws Exception {
		String sTestName = "SignIn";
		Log.startTest(sTestName);
		TestBaseSetup.SignIn(driver);
		Log.endTest(sTestName);
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.gecko.driver", "C:\\\\driver\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.sURL);
	}

	@AfterMethod
	public void afterMethod() {

		//Base_Module.CloseBrowser(driver);
		driver.quit();
	}
}
