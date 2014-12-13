/**
 * 
 */
package testproject;

/**
 * @author jyotibajaj
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonAddToCartTests {

	WebDriver driver = null;

	@BeforeClass
	@Parameters({ "url", "browserType" })
	public void initialize(String myURL,  String myBrowser) {
		String currentDirPath = System.getProperty("user.dir");
		System.out.println("The URL is  : " + myURL);
		System.out.println("The browser is : " + myBrowser);
		System.setProperty("webdriver.chrome.driver",
				currentDirPath +"/libs/Chrome/chromedriver");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("ignore-certifcate-errors");
		capabilities.setCapability("chrome.binary",
				currentDirPath +"/libs/Chrome/chromedriver");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(myURL);

	}

	@Test
	public void addToCartTest() throws InterruptedException {
		// To type laptop in amazon search field -- Identify the web element and

		// let webdriver know this is the unique identifier

		By searchFieldLocator = By.name("field-keywords");

		WebElement textField = driver.findElement(searchFieldLocator);

		textField.sendKeys("Laptop");
		Thread.sleep(2000);
		WebElement goButton = driver.findElement(By
				.className("nav-submit-input"));
		goButton.click();
		Thread.sleep(4000);

	}

	 @AfterClass
	 public void closeBrowser() {
	
	 driver.close();
	
	 driver.quit();
	
	 }

}
