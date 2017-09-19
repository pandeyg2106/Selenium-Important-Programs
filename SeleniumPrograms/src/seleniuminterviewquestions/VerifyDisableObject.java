package seleniuminterviewquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDisableObject {
	
	@Test
	public void verifyDisabledObject(){
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.olx.in/pune/cars/q-swift/");
		String classname = driver.findElement(By.cssSelector("#param_model")).getAttribute("class");
		Assert.assertEquals(classname, "param paramSelect disabled");	
}
}
