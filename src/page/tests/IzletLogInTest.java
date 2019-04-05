package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.HomePage;
import page.objects.IzletPage;
import projekat.DataExcel;
import projekat.ExcelUtils;

public class IzletLogInTest {

	// Ubacivanje podataka pomocu Scanner-a
	public static void logIn(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		// Username
		System.out.println("Unesi username ");
		String str = sc.nextLine();
		IzletPage.clickLUsername(dr);
		IzletPage.sendKeysLUsername(dr, str);
		// Password
		System.out.println("Unesite password");
		str = sc.nextLine();
		IzletPage.clickLPassword(dr);
		IzletPage.sendKeysLPassword(dr, str);
		// Log in button
		IzletPage.clickLogInButton(dr);
		sc.close();
	}

	// Log in upotrebom excel tabele biranjem reda (int i)
	public static void logInE(WebDriver dr, int i) throws Exception {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME);
		// Username
		data = ExcelUtils.getCellData(i, 2);
		IzletPage.clickLUsername(dr);
		IzletPage.sendKeysLUsername(dr, data);
		// Password
		data = ExcelUtils.getCellData(i, 4);
		IzletPage.clickLPassword(dr);
		IzletPage.sendKeysLPassword(dr, data);
		// Log in button
		IzletPage.clickLogInButton(dr);

	}

	// Log in vise korisnika koristeci podatke iz Excel-a i unete
	// Pass or Fail u Excel-u u poseban (i) red
	// Ako je log in bio neuspesan, program se preusmerava nazad na stranicu
	// log in,tako da moze da se reg sl korisnik
	public static void AllLogIn(WebDriver dr) throws Exception {
		// Setting excel file
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME);
		for (int i = 1; i < ExcelUtils.getWSheet().getLastRowNum() + 1; i++) {
			logInE(dr, i);
			if (dr.getCurrentUrl().equals(HomePage.URL)) {
				HomePageTest.logOut(dr);
			} else
				IzletPage.navigateTo(dr);

		}
	}
}
