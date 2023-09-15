package PageObjects;

import org.openqa.selenium.By;import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObejects {
	
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_search = By.name("btnk");
	
	public GoogleSearchPageObejects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickOnSearchButton() {
		driver.findElement(textbox_search).sendKeys(Keys.RETURN);
		
	}
}
