package seleniuminterviewquestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCollapsedAndExpandedObjectInSelenium {

	WebDriver driver;

	@Test
	public void verifyCollapsedAndExpandedObjectInSelenium() throws InterruptedException {
		// for Mac OS
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.hdfcbank.com/htdocs/nri_banking/payments/BillPay/BillPay.htm");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='nre_savings_acc']>ul>li>h3")));
		String style = driver.findElement(By.cssSelector("div[id='nre_savings_acc']>ul>li>h3")).getCssValue("background-image");
		System.out.println("Before Clicking" + style);
		if (style.contains("bg_collapsed_panel")) {
			Assert.assertTrue(true, style);
		} else {
			Assert.assertTrue(false, style);
		}
		driver.findElement(By.cssSelector("div[id='nre_savings_acc']>ul>li>h3")).click();
		Thread.sleep(5000);

		style = driver.findElement(By.cssSelector("div[id='nre_savings_acc']>ul>li>h3")).getCssValue("background-image");
		System.out.println("Before Clicking" + style);
		if (style.contains("bg_expanded_panel")) {
			Assert.assertTrue(true, style);
		} else {
			Assert.assertTrue(false, style);
		}

	}

}
