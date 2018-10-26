package seleniuminterviewquestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Practice {
	
	WebDriver driver;
	
	public void FacebookLogin() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("rockstargrv@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.cssSelector("input[value = 'Log In']")).click();
		
	}
	@Test
	public void MouseOverTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement electronics = driver.findElement(By.cssSelector("a[title='Electronics']>span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(electronics).perform();
	}

}
