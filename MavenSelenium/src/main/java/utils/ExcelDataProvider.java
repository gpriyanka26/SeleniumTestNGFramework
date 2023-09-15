package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");	
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {

		System.out.println(username + " | " + password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys(username);
		//driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys(password);
		
		Thread.sleep(5000);

	}

	@DataProvider(name = "test1data")
	public Object[][] getData() {

		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "//testdata//Excel_XLSXfile.xlsx";
		Object data[][] = testdata(excelPath, "Sheet1");
		return data;

	}

	public static Object[][] testdata(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				// System.out.print(cellData+" | ");

				data[i - 1][j] = cellData;
			}
			// System.out.println();

		}
		return data;
	}

}
