package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Constant;
import utility.Log;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CreateAccountPage {
	private WebDriver _driver;
    private By radTitle = By.tagName("label");
    private By txtFNameAddress = By.id("firstname");
	private By txtLNameAddress  = By.id("lastname");
    private By txtEmail = By.id("email");
	private By txtFName = By.name("customer_firstname");
	private By txtLName = By.name("customer_lastname");
	private By txtPassword = By.id("passwd");
	private By lstDayOfBirth = By.id("days");
	private By lstMonthOfBirth = By.id("months");
	private By lstYearYearOfBirth = By.id("years") ;
	private By txtAddress = By.id("address1");
	private By txtCity = By.id("city");
	private By lstState = By.id("id_state");
	private By txtPostCode = By.id("postcode");
	private By lstCountry = By.id("id_country");
	private By txtMobilePhone = By.id("phone_mobile");
	private By txtAlias = By.id("alias");
	private By bRegister = By.id("submitAccount");


	public CreateAccountPage(WebDriver driver) {
		_driver= driver;
        _driver.manage().timeouts().implicitlyWait(Constant.WAIT_MAX_IN_SECOND, TimeUnit.SECONDS);
	}

	public void setTitle(String sTitle){
		List<WebElement> element = _driver.findElements(radTitle);
		if (!element.isEmpty()){
			for (int i=0; i<element.size();i++) {
				if (element.get(i).getText().trim().equalsIgnoreCase(sTitle.trim())){
					element.get(i).click();
					Log.info("Title is " + element.get(i).getText());
					break;
				}

			}
		}
		else{
			Log.error("Title radio not found");
		}
	}
	public String setFirstName(String firstName){
	    try{

            WebElement element = _driver.findElement(txtFName);
            element.clear();
            element.sendKeys(firstName);
            Log.info("First name is " + element.getAttribute("value"));
            return element.getAttribute("value");
        }catch (NoSuchElementException e){
            Log.error("First name not found");
	        return null;
        }
	}
	public String setLastName(String lastName){
		WebElement element = _driver.findElement(txtLName);
		if (element.isDisplayed() || element.isEnabled()){
			element.clear();
			element.sendKeys(lastName);
			Log.info("Last name is " + element.getAttribute("value"));
			return element.getAttribute("value");
		}
		else{
			Log.error("Last name not found");
			return null;
		}

	}
	//Email???
	public void setEmail(String sEmail){
        WebElement element = _driver.findElement(txtEmail);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(sEmail);
            Log.info("Email is " + element.getAttribute("value"));
        }
        else{
            Log.error("Email not found");
        }

    }

    public void setPassword(String password){
        WebElement element = _driver.findElement(txtPassword);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(password);
            Log.info("Password populated");
        }
        else{
            Log.error("Password not found");
        }

    }
    public void selectDayOfBirth(String sDay){
        WebElement element = _driver.findElement(lstDayOfBirth);

        if (element.isEnabled() || element.isDisplayed()){
            Select dropdown = new Select(element);
            try{
                dropdown.selectByValue(sDay);
                Log.info("Day of birth is "+sDay);

            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        else{
            Log.error("Day of birth not found");
        }

    }
    public void selectMonthOfBirth(String sMonth){
        WebElement element = _driver.findElement(lstMonthOfBirth);

        if (element.isEnabled() || element.isDisplayed()){
            Select dropdown = new Select(element);
            try{
                dropdown.selectByValue(sMonth);
                Log.info("Month of birth is "+sMonth);

            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        else{
            Log.error("Month of birth not found");
        }

    }
    public void selectYearOfBirth(String sYear){
        WebElement element = _driver.findElement(lstYearYearOfBirth);
        if (element.isEnabled() || element.isDisplayed()){
            Select dropdown = new Select(element);
            try{
                dropdown.selectByValue(sYear);
                Log.info("Year of birth is "+sYear);

            }catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        else{
            Log.error("Year of birth not found");
        }

    }
	public void getFirstNameAddress(){
       WebElement element = _driver.findElement(txtFNameAddress);
        if (element.isDisplayed() || element.isEnabled()){
            Log.info("Address-First Name equals to First Name - " + element.getAttribute("value"));
        }
        else{
            Log.error("Address - First Name not found");
        }
    }
    public void getLastNameAddress(){
       WebElement element = _driver.findElement(txtLNameAddress);
        if (element.isDisplayed() || element.isEnabled()){
                Log.info("Address-Last Name equals to Last Name - " + element.getAttribute("value"));
        }
        else{
                Log.error("Address - Last Name not found");
        }
    }
    public void setAddress(String sAddress){
        WebElement element = _driver.findElement(txtAddress);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(sAddress);
            Log.info("Address is " + element.getAttribute("value"));
        }
        else{
            Log.error("Address not found");

        }
    }

    public void setCity(String sCity){
        WebElement element = _driver.findElement(txtCity);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(sCity);
            Log.info("City is " + element.getAttribute("value"));

        }
        else{
            Log.error("City not found");

        }
    }
    public void setState(String sState){
	    WebElement element = _driver.findElement(lstState);
	    if (element.isDisplayed() || element.isEnabled()){
	        Select dropdown = new Select(element);
	        try{
                dropdown.selectByValue(sState);
	            Log.info("State is " + sState);

            }catch (NoSuchElementException e){
	            e.printStackTrace();
            }
        }
        else {
	        Log.error("State not found");
        }

    }

    public void setPostCode(String sPostCode){
        WebElement element = _driver.findElement(txtPostCode);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(sPostCode);
            Log.info("Post Code is " + element.getAttribute("value"));

        }
        else{
            Log.error("Post Code not found");

        }
    }
    public void setCountry(String sCountry){
        WebElement element = _driver.findElement(lstCountry);
        if (element.isDisplayed() || element.isEnabled()){
            Select dropdown = new Select(element);
            try{
                dropdown.selectByValue(sCountry);
                Log.info("Country is " + sCountry);

            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }
        else {
            Log.error("Country not found");
        }

    }
    public void setMobilePhone(String sMobilePhone){
        WebElement element = _driver.findElement(txtMobilePhone);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(sMobilePhone);
            Log.info("Mobile phone is " + element.getAttribute("value"));

        }
        else{
            Log.error("Mobile phone not found");

        }
    }
    public void setAddressAlias(String sAlias){
        WebElement element = _driver.findElement(txtAlias);
        if (element.isDisplayed() || element.isEnabled()){
            element.clear();
            element.sendKeys(sAlias);
            Log.info("Address alias is " + element.getAttribute("value"));

        }
        else{
            Log.error("Address alias not found");

        }
    }
    public void clickRegisterButton(){
	    WebElement element = _driver.findElement(bRegister);
	    if (element.isEnabled()||element.isDisplayed()){
            element.click();
            Log.info("Clicking Register");
        }
        else{
	        Log.error("Register button not found");
        }
    }
    public MyAccountPage createNewAccount(WebDriver driver,
                                          String sEmail, String sTitle, String sFName,
                                          String sLName, String sPass,
                                          String sDay, String sMonth, String sYear,
                                          String sAddress, String sCity, String sState,
                                          String sPostCode, String sCountry,
                                          String sMobilePhone, String sAlias){
        getLastNameAddress();
        setFirstName(sFName);
        getFirstNameAddress();
        setLastName(sLName);
        setTitle(sTitle);
        setEmail(sEmail);
        setPassword(sPass);
        selectDayOfBirth(sDay);
        selectMonthOfBirth(sMonth);
        selectYearOfBirth(sYear);
        setAddress(sAddress);
        setCity(sCity);
        setState(sState);
        setPostCode(sPostCode);
        setCountry(sCountry);
        setMobilePhone(sMobilePhone);
        setAddressAlias(sAlias);
        clickRegisterButton();
        return new MyAccountPage(driver);
    }
    public boolean verifyMyAccountPageTitle(){
        return _driver.getTitle().contains(Constant.myAccountPageTitle);
    }
}

