package Day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//get() -Opens application url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//getTitle() - returns title of webpage
		System.out.println(driver.getTitle());
		//getCurrentUrl() - returns url in form of string
		System.out.println(driver.getCurrentUrl());
		//getPageSource() - returns the page source as String
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.partialLinkText("OrangeHRM")).click();
		Thread.sleep(5000);
		Set<String> windowids=driver.getWindowHandles();
		System.out.println(windowids);
		driver.close();
		List<String> getWinHandles=new ArrayList<String>(windowids);
		driver.switchTo().window(getWinHandles.get(1));
		Thread.sleep(5000);
		System.out.println(driver.getWindowHandle());
		driver.quit();

	}

}
