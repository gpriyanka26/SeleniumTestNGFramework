package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleSearch();
		
	}

	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		
		//navigate to Google
		driver.get("https://google.com");
	
		GoogleSearchPage.textbox_search(driver).sendKeys("Melbourne, Australia");
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
						
		//close browser
		//driver.close();
		
		System.out.println("Test completed successfully");
				
	}
}
