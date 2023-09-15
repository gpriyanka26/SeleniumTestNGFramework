package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AUtoITDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		test();

	}
	
	public static void test() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
		
		String baseUrl = "https://ps.uci.edu/~franklin/doc/file_upload.html";
		
		driver.get(baseUrl);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/form[1]/input[1]")).click();
		//driver.findElement(By.name("userfile")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:/Users/91787/Documents/QA Priyanka/Selenium/FileUploadScript.exe");
		
		Thread.sleep(3000);
		
	}

}
