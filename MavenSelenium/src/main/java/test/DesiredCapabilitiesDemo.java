package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesiredCapabilitiesDemo {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

	}

}
