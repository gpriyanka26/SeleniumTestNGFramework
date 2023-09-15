package Selenium.MavenSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		/*
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.clear();
		search.sendKeys("Priyanka Gaikwad");
		
		WebElement search = driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("Patel Devang");
		*/
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		System.out.println("Count of input elements is "+count);
		
		Thread.sleep(3000);
		
		}

}
