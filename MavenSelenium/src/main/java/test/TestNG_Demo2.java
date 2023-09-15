package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	
	static WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public static void googleSearch() {
		
		//navigate to Google
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		
		//CLick search
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
					
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		//driver.close();
				
		System.out.println("Test completed successfully");
	}
}
