package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String[] args) {

		seleniumWaits();

	}

	public static void seleniumWaits() {

		
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//250 ms
		
		String baseUrl = "https://google.com";

		driver.get(baseUrl);
		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("XYZ")));
		
		driver.findElement(By.name("XYZ")).sendKeys(Keys.RETURN);

	}

}
