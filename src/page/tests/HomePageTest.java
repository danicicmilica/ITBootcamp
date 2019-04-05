package page.tests;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.HomePage;
import page.objects.PostPage;
import projekat.DataExcel;
import projekat.ExcelUtils;

public class HomePageTest {

	// Log out
	public static void logOut(WebDriver dr) {
		HomePage.clickLogOut(dr);
	}

	// Brisanje posta
	public static void deletePost(WebDriver dr, int p) {
		HomePage.clickMore(dr, p);
		HomePage.clickDelete(dr, p);
	}

	// Brisanje postova, p predstavlja koliko postova zelimo da obrisemo
	public static void deletePosts(WebDriver dr, int p) {
		for (int i = 0, j = 0; j < p; j++) {
			deletePost(dr, i);
		}
	}

	// Edit post, p predstavlja koji post zelite da edituje
	public static void editPost(WebDriver dr, int p) {
		Scanner sc = new Scanner(System.in);
		// More options button
		HomePage.clickMore(dr, p);
		// Edit button
		HomePage.clickEdit(dr, p);
		// Naziv
		System.out.println("Enter naziv:");
		String naziv = sc.nextLine();
		PostPage.clickENaziv(dr);
		PostPage.sendKeysENaziv(dr, naziv);
		// Lokacija
		System.out.println("Enter lokacija:");
		String lokacija = sc.nextLine();
		PostPage.clickELokacija(dr);
		PostPage.sendKeysELokacija(dr, lokacija);
		// Prevozno sredstvo
		System.out.println(
				"Select pSredstvo. For 'Walk' enter 1, for 'Car' enter 2, for 'Motorbike' enter 3, for 'Bicycle' enter 4 and for 'Bus' enter 5");
		String EPsredstvo = sc.nextLine();
		PostPage.selectEPSredstvo(dr, EPsredstvo);
		sc.nextLine();
		// Opis
		System.out.println("Enter opis:");
		String opis = sc.nextLine();
		PostPage.clickEOpis(dr);
		PostPage.sendKeysEOpis(dr, opis);
		// Confirm button to edit a post
		PostPage.clickEPostB(dr);
		sc.close();
	}

	// Edit post upotrebom excel tabele
	public static void editPostExcel(WebDriver dr, int p, int i) throws Exception {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME1);
		// More options button
		HomePage.clickMore(dr, p);
		// Edit button
		HomePage.clickEdit(dr, p);
		// Naziv
		data = ExcelUtils.getCellData(i, 1);
		PostPage.clickENaziv(dr);
		PostPage.sendKeysENaziv(dr, data);
		// Lokacija
		data = ExcelUtils.getCellData(i, 2);
		PostPage.clickELokacija(dr);
		PostPage.sendKeysELokacija(dr, data);
		// Opis
		data = ExcelUtils.getCellData(i, 0);
		PostPage.clickEOpis(dr);
		PostPage.sendKeysEOpis(dr, data);
		// Confirm button to edit a post
		PostPage.clickEPostB(dr);
	}

}
