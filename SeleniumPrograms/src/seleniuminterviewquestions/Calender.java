package seleniuminterviewquestions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender {
	
	@Test
	public void selectDate() throws InterruptedException{
		
		String inputdate = "12/18/2017";
		Date d = new Date(inputdate);
		
		SimpleDateFormat dt1 = new SimpleDateFormat("MMMM/dd/yyyy");
		SimpleDateFormat dt2 = new SimpleDateFormat("yyyy/MM/dd");
		String date1 = dt1.format(d);
		String date2 = dt2.format(d);
		
		String[] split = date1.split("/");
		String[] split1 = date2.split("/");
		String month = split[0]+" "+split[2];
		String day = split1[0]+split1[1]+split1[2];
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.goibibo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#gi_oneway_label")).click();
		driver.findElement(By.cssSelector(".form-control.inputTxtLarge.widgetCalenderTxt")).click();
		Thread.sleep(2000);
		
		while(true){
			try {
				driver.findElement(By.xpath(".//div[contains(text(),'"+month+"')]")).isDisplayed();
				driver.findElement(By.cssSelector("#fare_"+day)).click();
			} catch (Exception e) {
				driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
			}
		}
		
	}

}
