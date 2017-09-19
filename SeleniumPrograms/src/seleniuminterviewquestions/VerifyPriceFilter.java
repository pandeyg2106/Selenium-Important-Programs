package seleniuminterviewquestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPriceFilter {

	@Test
	public void verifyPriceFilter() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#block_top_menu>ul>li:nth-child(2)>a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.cssSelector("#selectProductSort")));
		select.selectByVisibleText("Price: Lowest first");
		Thread.sleep(5000);
		List<WebElement> allPrices = driver.findElements(By
				.cssSelector("ul[class='product_list grid row']>li>div>div:nth-child(2)>div.content_price>span.price"));
		ArrayList<Integer> array = new ArrayList<Integer>();
		Iterator<WebElement> itr = allPrices.iterator();
		while(itr.hasNext()){
			
			String p = itr.next().getText();
			System.out.println(p);
			if(p.contains("$")){
				String actualprice = p.substring(1);
				Double price = Double.parseDouble(actualprice);
				int productPrice = price.intValue();
				array.add(productPrice);
			}			
		}
		
		for(int i = 0; i<array.size()-1; i++){
			if(array.get(i) < array.get(i+1)){
				System.out.println(array.get(i));
			}
			else{
				Assert.assertTrue(false);
			}
		}
	}

}
