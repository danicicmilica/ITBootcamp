package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IzletPage {

	public static final String URL = "http://localhost/izlet/index.php";
	private static final String FIRSTNAME = "//input[@name='firstname']";
	private static final String LASTNAME = "//input[@name='lastname']";
	private static final String USERNAME = "//form[@action='processregister.php']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//form[@action='processregister.php']//input[@name='password']";
	private static final String REG = "//input[@value='Register']";
	// l-log in polje
	private static final String LUSERNAME = "//input[@placeholder='username']";
	private static final String LPASSWORD = "//input[@placeholder='password']";
	private static final String LOGIN = "//input[@value='Log in']";

	// First name
	public static WebElement getFirstName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(FIRSTNAME));
		return wb;
	}

	public static void clickFirstName(WebDriver dr) {
		getFirstName(dr).click();
	}

	public static void sendKeysFirstName(WebDriver dr, String str) {
		getFirstName(dr).sendKeys(str);
	}

	// Last name
	public static WebElement getLastName(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LASTNAME));
		return wb;
	}

	public static void clickLastName(WebDriver dr) {
		getLastName(dr).click();
	}

	public static void sendKeysLastName(WebDriver dr, String str) {
		getLastName(dr).sendKeys(str);
	}

	// Username
	public static WebElement getRegUsername(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(USERNAME));
		return wb;
	}

	public static void clickRegUsername(WebDriver dr) {
		getRegUsername(dr).click();
	}

	public static void sendKeysRegUsername(WebDriver dr, String str) {
		getRegUsername(dr).sendKeys(str);
	}

	// Email
	public static WebElement getEmail(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EMAIL));
		return wb;
	}

	public static void clickEmail(WebDriver dr) {
		getEmail(dr).click();
	}

	public static void sendKeysEmail(WebDriver dr, String str) {
		getEmail(dr).sendKeys(str);
	}

	// Password
	public static WebElement getRegPassword(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(PASSWORD));
		return wb;
	}

	public static void clickRegPassword(WebDriver dr) {
		getRegPassword(dr).click();
	}

	public static void sendKeysRegPassword(WebDriver dr, String str) {
		getRegPassword(dr).sendKeys(str);
	}

	// Register button
	public static WebElement getRegister(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(REG));
		return wb;
	}

	public static void clickRegister(WebDriver dr) {
		getRegister(dr).click();
	}

	// Log in username
	public static WebElement getLUsername(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LUSERNAME));
		return wb;
	}

	public static void clickLUsername(WebDriver dr) {
		getLUsername(dr).click();
	}

	public static void sendKeysLUsername(WebDriver dr, String str) {
		getLUsername(dr).sendKeys(str);
	}

	// Log in password
	public static WebElement getLPassword(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LPASSWORD));
		return wb;
	}

	public static void clickLPassword(WebDriver dr) {
		getLPassword(dr).click();
	}

	public static void sendKeysLPassword(WebDriver dr, String str) {
		getLPassword(dr).sendKeys(str);
	}

	// Log in button
	public static WebElement getLogInButton(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOGIN));
		return wb;
	}

	public static void clickLogInButton(WebDriver dr) {
		getLogInButton(dr).click();
	}

	// Open page
	public static void openPage(WebDriver dr) {
		dr.get(URL);
	}

	// Navigate to Page
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(URL);
	}

}
