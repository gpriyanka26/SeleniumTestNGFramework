package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo {
	
	static WebDriver driver = null;
	public static String browsername = null;
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//chromedriver//chromedriver.exe");
			driver = new ChromeDriver();	
			
		}
		else if (browsername.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//IEdriver//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		
	}
	
	@Test
	public static void googleSearch2() {
		
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
		PropertiesFile.setProperties();
	}
}
