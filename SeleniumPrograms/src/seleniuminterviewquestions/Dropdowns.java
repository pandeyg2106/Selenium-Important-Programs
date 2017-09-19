package seleniuminterviewquestions;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dropdowns {
	@Test
	public void FindDuplicatesInDropdown() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		List<WebElement> month_list = driver.findElement(By.id("month")).findElements(By.tagName("option"));
		for (WebElement option : month_list) {
			HashSet<String> values = new HashSet<String>();
			if (values.contains(option.getText())) {
				System.out.println("Duplicate found of value " + values);
			} else {	
				values.add(option.getText());
			}
		}
		System.out.println("No Duplicates found");
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("C:\\test\\Screenshot"+".png"));

	}
	

}
