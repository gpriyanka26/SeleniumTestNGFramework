package Selenium.MavenSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	private static WebDriver driver = null;

	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("ExtentReportTestNG.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test1() throws Exception {
		test1 = extent.createTest("Google Search Test one", "This is test to validate google serach validity");

		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://google.com");
		test1.pass("Entered in search box");

		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		test1.pass("Entered text in search textbox");

		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Pressed search button");
		test1.info("Test completed");

		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info failed test");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest
	public void tearDownTest() {

		// close browser
		// driver.close();

		System.out.println("Test completed successfully");
	}

	@AfterSuite
	public void teardown() {

		extent.flush();

	}
}
