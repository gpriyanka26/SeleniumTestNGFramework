package Selenium.MavenSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test one","This is test to validate google serach validity");
        
        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		
		// log(Status, details)
        test1.log(Status.INFO, "Starting test case");
        //navigate to Google
		driver.get("https://google.com");
		test1.pass("Navigated in search box");
		
		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		test1.pass("Entered text in search textbox");
		
		//Click search
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Pressed search button");
		
		test1.info("Test completed");
		
		// calling flush writes everything to the log file
        extent.flush();
	}

}
