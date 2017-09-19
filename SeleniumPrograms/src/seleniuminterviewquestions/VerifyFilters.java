package seleniuminterviewquestions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class VerifyFilters {
	
	@Test
	public void verifyFilters() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.olx.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#cityField")).click();
		driver.findElement(By.cssSelector("a[data-name='Pune']>span")).click();
		driver.findElement(By.cssSelector("a[id='cat-5'][data-code='vehicles']>span")).click();
		driver.findElement(By.cssSelector("a[id='cat-84'][data-id='84']>span")).click();
		driver.findElement(By.cssSelector("input[id='search-text']")).sendKeys("swift");
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#autosuggest-div>ul>li>a")).click();
		
		List<WebElement> alldata = driver.findElements(By.cssSelector("#offers_table>tbody>tr>td>table>tbody>tr>td:nth-child(2)>h3>a>span"));
		Iterator<WebElement> itr = alldata.iterator();
		
		while(itr.hasNext()){
			
			String data = itr.next().getText();
			if(data.toLowerCase().contains("swift")){				
			}
			else{
				Assert.assertTrue(data, false);
			}
		}
		
		
		
}

}
