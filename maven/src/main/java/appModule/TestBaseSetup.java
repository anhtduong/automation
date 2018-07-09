package appModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utility.Constant;
import utility.Log;

public class TestBaseSetup {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String webURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(webURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(webURL);
			break;
		default:
			Log.warn(browserType + " is invalid. Launching firefox profile by default");
			driver = initFirefoxDriver(webURL);
		}

	}

	private WebDriver initChromeDriver(String webURL) {
		Log.info("Launching browser Chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(webURL);
		return driver;
	}

	private WebDriver initFirefoxDriver(String webURL) {
		Log.info("Launching browser Firefox");
		System.setProperty("webdriver.gecko.driver", Constant.driverPath + "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,15);
		driver.navigate().to(webURL);
		return driver;
	}
	
	@Parameters({ "browserType", "webURL"})

	@BeforeClass
	public void initTestBaseSetup(String browserType, String webURL) {
		try {
			setDriver(browserType,webURL);

		} catch (Exception e) {
			Log.error(e.getStackTrace().toString());
		}
	}

	@AfterClass
	public void tearDown() {
		Log.info("Closing all browsers");
		driver.quit();

	}
}
