package Selenium.MavenSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("*** "+projectpath);
		
		System.setProperty("webdriver.chrome.driver", projectpath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.grammarcheck.net/editor/");
		//driver.close();
	}

}
