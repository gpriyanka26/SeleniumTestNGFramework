package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		
		System.out.println("I am inside Test1");
		
	}
	
	@Test
	public void test2() {
		
		System.out.println("I am inside Test2");
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
					
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		
	}
	
	@Test
	public void test3() {
		
		System.out.println("I am inside Test3");
		throw new SkipException("This test has been skipped");
				
	}

}
