package BaseClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserName(String browserName,String Url)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrome\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(Url);
		return driver;
		
	}
	public static void assertFunction()
	{
		//WebElement ele1=driver.findElement(By.xpath("//span[contains(text(),'Unable to login')]]"));
	//	assertFalse(driver.findElement(By.xpath("//span[contains(text(),'+errormessagetext+')]")));
	//	assertFalse(ele1.isDisplayed(),"Valid Login");
		WebElement ele1=driver.findElement(By.xpath("//div[text()='ResRent']"));
		Boolean errormessage =ele1.isDisplayed();
		assertTrue(errormessage.TRUE);
	}
	

}
