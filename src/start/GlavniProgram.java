package start;

import java.util.Scanner;

//GDE TI JE EXCEL FILE?
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.HomePage;
import page.objects.IzletPage;
import page.tests.HomePageTest;
import page.tests.IzletLogInTest;
import page.tests.PostPageTest;
import page.tests.RegistrationTest;

public class GlavniProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		try {
			// Method that opens page
			IzletPage.openPage(dr);

			// Metoda koja popunjava usere iz excel tabele
			RegistrationTest.testWithAllData(dr);

			// Metoda za log out user
			HomePageTest.logOut(dr);
			// Metoda za log in iz excel tabele
			IzletLogInTest.AllLogIn(dr);
			// Metoda za log in iz excel tabele iz drugog reda
			IzletLogInTest.logInE(dr, 2);

			// Metoda make posts iz excel tabele
			PostPageTest.multiplePosts(dr);
			// Metoda koja brise 2 posta
			HomePageTest.deletePosts(dr, 2);

		} catch (Exception e) {

			e.printStackTrace();
		}
		sc.close();
	}

}
