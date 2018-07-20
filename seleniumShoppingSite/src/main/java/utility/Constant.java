package utility;

public class Constant {
    public static final String driverPath = "C:\\driver\\geckodriver-v0.20.1-win64\\";
    public static final String dataFile = "./testdata.json";
    public static final String homePageTitle = "My Store";
    public static final String signInPageTitle = "Login - My Store";
    public static final String myAccountPageTitle = "My account - My Store";
    public static final String myAccountPageInfo = "Welcome to your account. Here you can manage all of your personal information and orders.";
    public static final String createAccountPageTitle = "Login - My Store";

    public enum browserTypeEnum {CHROME, FIRE_FOX}
    public enum jValidAccEnum{email, pass}
    public enum jInvalidAccEnum{invalid_email, invalid_pass}
    public enum jNewAccEnum {title, first_name, last_name, new_email, new_pass, day, month, year, address,
        city, state, zip_code, country, mobile_phone, address_alias}
    public enum jKeySetEnum {valid_accounts, invalid_accounts, new_accounts}
    public enum testNameEnum{SIGN_IN_INVALID_ACC, SIGN_IN_VALID_ACC, SIGN_IN_NEW_ACC}

    public static final int WAIT_MIN_IN_SECOND = 8;
    public static final int WAIT_MAX_IN_SECOND = 15;
}
