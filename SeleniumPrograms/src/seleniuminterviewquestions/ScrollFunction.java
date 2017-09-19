package seleniuminterviewquestions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollFunction {
	
	@Test
	public void scrollVerify() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.olx.in/pune/cars/q-swift/");
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

}
