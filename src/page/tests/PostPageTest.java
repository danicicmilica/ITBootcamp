package page.tests;


import java.util.Scanner;


import org.openqa.selenium.WebDriver;


import page.objects.PostPage;
import projekat.DataExcel;
import projekat.ExcelUtils;

public class PostPageTest {

	// Post data pomocu Scanner-a
	public static void makePost(WebDriver dr) {
		Scanner sc = new Scanner(System.in);
		// Make a new post button
		PostPage.clickMakeAPost(dr);
		// Post naziv
		System.out.println("Unesite naziv");
		String str = sc.nextLine();
		PostPage.clickNaziv(dr);
		PostPage.sendKeysNaziv(dr, str);
		// Post lokacija
		System.out.println("Unesite lokaciju");
		str = sc.nextLine();
		PostPage.clickLokacija(dr);
		PostPage.sendKeysLokacija(dr, str);
		// Post prevozno sredstvo
		System.out.println("Odaberite prevozno sredstvo");
	    str = sc.nextLine();
		PostPage.selectPSredstvo(dr, str);
	    sc.nextLine();
		// Post opis
		System.out.println("Unesite opis");
		str = sc.nextLine();
		PostPage.clickOpis(dr);
		PostPage.sendKeysOpis(dr, str);
		// Confirming button to make a post
		PostPage.clickPostB(dr);
		sc.close();
	}

	// Postavljanje post-a upotrebom excel tabele biranjem reda (int i)
	public static void makePost(WebDriver dr, int i) throws Exception {
		String data;
		// Setting excel file
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME1);
		// Clicking make a new post button
		PostPage.clickMakeAPost(dr);
		// Post naziv
		data = ExcelUtils.getCellData(i, 1);
		PostPage.clickNaziv(dr);
		PostPage.sendKeysNaziv(dr, data);
		// Post lokacija
		data = ExcelUtils.getCellData(i, 2);
		PostPage.clickLokacija(dr);
		PostPage.sendKeysLokacija(dr, data);
		// Post opis
		data = ExcelUtils.getCellData(i, 0);
		PostPage.clickOpis(dr);
		PostPage.sendKeysOpis(dr, data);
		// Confirming button to make a post
		PostPage.clickPostB(dr);
	}

	// Postavljanje postova koriscenjem excel tabele
	public static void multiplePosts(WebDriver dr) throws Exception {
		// Setting excel file
		ExcelUtils.setExcelFile(DataExcel.PATH_TESTDATA + DataExcel.FILE_TESTDATA, DataExcel.SHEET_NAME1);
		for (int i = 1; i < ExcelUtils.getWSheet().getLastRowNum()+1; i++) {
			makePost(dr, i);
		}
	}

	
}
