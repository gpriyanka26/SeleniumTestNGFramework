package demo;

import java.time.Duration;
import java.util.NoSuchElementException;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {

		test();
	}

	public static void test() throws Exception {

		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/drivers/chromedriver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://google.com";

		driver.get(baseUrl);
		driver.findElement(By.name("q")).sendKeys("Melbourne, Australia");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		driver.findElement(By.linkText("Melbourne Zoo")).sendKeys(Keys.RETURN);

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.id("foo"));

				if (linkElement.isEnabled()) {
					System.out.println("Element found");
				}
				return linkElement;
			}
		});
		
		element.click();
	}

}
