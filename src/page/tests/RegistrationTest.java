package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;


import page.objects.IzletPage;
import projekat.DataExcel;
import projekat.ExcelUtils;

public class RegistrationTest {

	// registracija pomocu Scanner-a
	public static void fillform(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		// unos first name
		System.out.println("Unesite first name");
		String str = sc.nextLine();
		IzletPage.clickFirstName(dr);
		IzletPage.sendKeysFirstName(dr, str);
		// unos last name
		System.out.println("Unesite last name");
		str = sc.nextLine();
		IzletPage.clickLastName(dr);
		IzletPage.sendKeysLastName(dr, str);
		// unos username
		System.out.println("Unesite username");
		str = sc.nextLine();
		IzletPage.clickRegUsername(dr);
		IzletPage.sendKeysRegUsername(dr, str);
		// unos email
		System.out.println("Unesite email");
		str = sc.nextLine();
		IzletPage.clickEmail(dr);
		IzletPage.sendKeysEmail(dr, str);
		// unos password
		System.out.println("Unesite password");
		str = sc.nextLine();
		IzletPage.clickRegPassword(dr);
		IzletPage.sendKeysRegPassword(dr, str);
		// Confirming button to register
		IzletPage.clickRegister(dr);
		sc.close();

	}

	// registracija iz Excel-a, biranjem odredjenog reda (int i)
	public static void fillForm(WebDriver dr, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME);
		IzletPage.clickFirstName(dr);
		data = ExcelUtils.getCellData(i, 0);
		IzletPage.sendKeysFirstName(dr, data);

		IzletPage.clickLastName(dr);
		data = ExcelUtils.getCellData(i, 1);
		IzletPage.sendKeysLastName(dr, data);

		IzletPage.clickRegUsername(dr);
		data = ExcelUtils.getCellData(i, 2);
		IzletPage.sendKeysRegUsername(dr, data);

		IzletPage.clickEmail(dr);
		data = ExcelUtils.getCellData(i, 3);
		IzletPage.sendKeysEmail(dr, data);

		IzletPage.clickRegPassword(dr);
		data = ExcelUtils.getCellData(i, 4);
		IzletPage.sendKeysRegPassword(dr, data);

		IzletPage.clickRegister(dr);
	}

	// registracija iz Excel tabele
	public static void testWithAllData(WebDriver dr) throws Exception {
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME);
		for (int i = 1; i < ExcelUtils.getWSheet().getLastRowNum() + 1; i++) {
			RegistrationTest.fillForm(dr, i);
			IzletPage.navigateTo(dr);
		}

	}
}
