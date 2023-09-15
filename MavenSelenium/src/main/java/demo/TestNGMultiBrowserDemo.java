package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectpath = System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {

		System.out.println("Browser Name is " + browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {

			System.out.println(projectpath);
			System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.get("http://seleniumhq.org/");
		} else {

			System.out.println("Browser is not chrome");

		}

	}

	@Test
	public void test1() throws Exception {

		driver.get("https://google.com");
		Thread.sleep(4000);

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		System.out.println("Test Completed");

	}

}
