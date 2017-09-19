package seleniuminterviewquestions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindBrokenLinks {

	public static List FindAllLinks(WebDriver driver) {

		List<WebElement> elementList = new ArrayList<>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));

		List finalList = new ArrayList<>();

		for (WebElement element : elementList) {
			if (element.getAttribute("href") != null) {
				finalList.add(element);
			}
		}

		return finalList;
	}

	public static boolean isLinkBroken(URL url) throws IOException

	{

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.connect();
		int responsecode = connection.getResponseCode();

		if (responsecode >= 400) {

			return true;
		}

		else {
			return false;
		}
	}

	public static void main(String[] args) throws MalformedURLException, Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pande\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		List<WebElement> allImages = FindAllLinks(driver);

		System.out.println("Total number of link found:" + allImages.size());
		int count = 0;

		for (WebElement element : allImages) {

			if (isLinkBroken(new URL(element.getAttribute("href")))) {

				System.out.println("URL:" + element.getAttribute("href") + " is broken");
				count = count + 1;
			}

		}

		System.out.println("Total number of broken links are: " + count);
		driver.quit();

	}
}
