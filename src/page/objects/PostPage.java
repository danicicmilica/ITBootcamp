package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPage {
	public static final String URL = "http://localhost/izlet/";

	private static final String MAKEAPOST = "//a[contains(text(),'Make a post')]";
	private static final String NAZIV = "//input[@placeholder='Naziv']";
	private static final String LOKACIJA = "//input[@placeholder='Lokacija']";
	private static final String PREVOZNOSREDSTVO = "//select[@name='transport']";
	private static final String OPIS = "//textarea[@placeholder='Opis']";
	private static final String POST = "//input[@value='Post']";

	private static final String EDITNAZIV = "//input[@id='title']";
	private static final String EDITLOKACIJA = "//input[@id='location']";
	private static final String EDITPSREDSTVO = "//div[@class='popupEdit']//select[@name='transport']";
	private static final String EDITOPIS = "//textarea[@id='description']";
	private static final String EDITPOST = "//div[@class='popupEdit']//input[@value='Post']";

	// metoda koja vraca na web element
	// Make a post
	public static WebElement getMakeAPost(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(MAKEAPOST));
		return wb;
	}

	public static void clickMakeAPost(WebDriver dr) {
		getMakeAPost(dr).click();
	}

	// Naziv posta
	public static WebElement getNaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(NAZIV));
		return wb;
	}

	public static void clickNaziv(WebDriver dr) {
		getNaziv(dr).click();
	}

	public static void sendKeysNaziv(WebDriver dr, String str) {
		getNaziv(dr).sendKeys(str);
	}

	// Postavljanje lokacije
	public static WebElement getLokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(LOKACIJA));
		return wb;
	}

	public static void clickLokacija(WebDriver dr) {
		getLokacija(dr).click();
	}

	public static void sendKeysLokacija(WebDriver dr, String str) {
		getLokacija(dr).sendKeys(str);
	}

	// Post select prevozno sredstvo
	public static void selectPSredstvo(WebDriver dr, String str) {
		Select prevoz = new Select(dr.findElement(By.xpath(PREVOZNOSREDSTVO)));
		prevoz.selectByVisibleText(str);

	}

	// Postavljanje opisa
	public static WebElement getOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(OPIS));
		return wb;
	}

	public static void clickOpis(WebDriver dr) {
		getOpis(dr).click();
	}

	public static void sendKeysOpis(WebDriver dr, String str) {
		getOpis(dr).sendKeys(str);
	}

	// Post button
	public static WebElement getPostB(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(POST));
		return wb;
	}

	public static void clickPostB(WebDriver dr) {
		getPostB(dr).click();
	}

	// Edit Naziv in specific post
	public static WebElement getENaziv(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDITNAZIV));
		return wb;
	}

	public static void clickENaziv(WebDriver dr) {
		getENaziv(dr).click();

	}

	public static void sendKeysENaziv(WebDriver dr, String str) {
		getENaziv(dr).clear();
		getENaziv(dr).sendKeys(str);
	}

	// Edit Lokacija in specific post
	public static WebElement getELokacija(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDITLOKACIJA));
		return wb;
	}

	public static void clickELokacija(WebDriver dr) {
		getELokacija(dr).click();
	}

	public static void sendKeysELokacija(WebDriver dr, String str) {
		getELokacija(dr).clear();
		getELokacija(dr).sendKeys(str);
	}

	// Edit Prevozno sredstvo in specific post
	public static void selectEPSredstvo(WebDriver dr, String str) {
		Select prevoz = new Select(dr.findElement(By.xpath(EDITPSREDSTVO)));
		prevoz.selectByVisibleText(str);

	}

	// Edit Opis in specific post
	public static WebElement getEOpis(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDITOPIS));
		return wb;
	}

	public static void clickEOpis(WebDriver dr) {
		getEOpis(dr).click();
	}

	public static void sendKeysEOpis(WebDriver dr, String str) {
		getEOpis(dr).clear();
		getEOpis(dr).sendKeys(str);
	}

	// Post button
	public static WebElement getEPostB(WebDriver dr) {
		WebElement wb = dr.findElement(By.xpath(EDITPOST));
		return wb;
	}

	public static void clickEPostB(WebDriver dr) {
		getEPostB(dr).click();
	}

	// Open page
	public static void openPage(WebDriver dr) {
		dr.get(URL);
	}

	// Navigate to page
	public static void navigateTo(WebDriver dr) {
		dr.navigate().to(URL);
	}

}
