package objectsKontrolni3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class sortiranje{
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenijum\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();

	}
	
	@Test
	public void testLoginBtn() {
		driver.navigate().to("https://www.saucedemo.com/");
	
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testRegForm(String username) {
		
		File f = new File("kontrolni.xlsx"); 
		try {
			InputStream inp = new FileInputStream(f); 
	
			
			
			
			SoftAssert sa = new SoftAssert();
			
			for (int i = 0; i < 7; i++) {
				
				Sheet sheet = null;
				Row row = sheet.getRow(i);
				
				Cell c1 = row.getCell(0);
				Cell c2 = row.getCell(1);
				Cell c3 = row.getCell(2);
				Cell c4 = row.getCell(3);
				Cell c5 = row.getCell(4);
				Cell c6 = row.getCell(5);
				Cell c7 = row.getCell(6);
				
				String username1 = c1.toString();
				String password = c2.toString();
				
				
				driver.navigate().to(GlavnaHome.URL);
				driver.findElement(By.xpath(username1));
			driver.findElement(By.xpath(password));
			
				
			GlavnaHome.submit(driver);
				
				String actual = driver.getCurrentUrl();
				String expected = "https://www.saucedemo.com/";
				
				sa.assertEquals(actual, expected, username1);
				
				sa.assertAll();
			}
			
			
              FileOutputStream wb = null;
			wb.close();
			
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
			driver.navigate().to(GlavnaHome.URL);
			String actual = driver.getCurrentUrl();
			String expected = "https://www.saucedemo.com/";
			//sa.assertEquals(actual, expected, username1);
			
		//	GlavnaHome.inputUsername(driver, username);
		
		
		//GlavnaHome.inputPassword(driver, password);
			
			//GlavnaHome.submit(driver);
			
			
			
		} 
	}
	
}





