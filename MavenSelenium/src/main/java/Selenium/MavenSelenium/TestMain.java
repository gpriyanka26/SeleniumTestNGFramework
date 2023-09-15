package Selenium.MavenSelenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty(
		            "webdriver.chrome.driver",
		            "C:\\Selenium Webdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  
		        ChromeDriver driver = new ChromeDriver();
		  
		        // Maximize the browser
		        // using maximize() method
		        driver.manage().window().maximize();
		  
		        // Launching website
		        driver.get("https://www.geeksforgeeks.org/");
	}

}
