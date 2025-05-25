package Day30;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameHandlingAssignment {
	public static void staticWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		List<String> chromeOptions=new ArrayList<String>();
		chromeOptions.add("start-maximized");
		chromeOptions.add("incognito");
		options.addArguments(chromeOptions);
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://ui.vision/demo/webtest/frames/");
		WebElement fifthFrame=driver.findElement(By.xpath("//frame[contains(@src,'frame_5')]"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(fifthFrame));
		staticWait();
		driver.findElement(By.tagName("a")).click();
		staticWait();
		driver.findElement(By.xpath("//a[@id='logo']")).isDisplayed();
		staticWait();
		driver.switchTo().defaultContent();
		driver.quit();
		
		
		
		
		
	}

}
