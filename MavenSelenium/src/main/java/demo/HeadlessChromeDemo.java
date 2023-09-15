package demo;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		test();

	}
	
	public static void test() throws Exception {
		
		WebDriver driver;
		String baseUrl;
		
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		
		baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--- headless ---");
		
		driver = new ChromeDriver(options);
		
		driver.get(baseUrl);
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

}
