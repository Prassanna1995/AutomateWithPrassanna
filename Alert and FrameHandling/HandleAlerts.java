package Day30;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {
	public static String verificationText(WebDriver driver) {
		return driver.findElement(By.id("result")).getText();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		List<String> chromeOptions = new ArrayList<String>();
		//chromeOptions.add("start-maximized");
		chromeOptions.add("incognito");
		chromeOptions.add("headless");
		options.addArguments(chromeOptions);

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		// Normal alert with Ok button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Alert']")).click();
		 * wait.until(ExpectedConditions.alertIsPresent()); Thread.sleep(5000); Alert
		 * alert=driver.switchTo().alert(); alert.accept();
		 * //driver.switchTo().defaultContent();
		 * if(verificationText(driver).equals("You successfully clicked an alert")) {
		 * System.out.println("Test Passed"); }
		 */

		// 2)confirmation alert -OK and Cancel Button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		 * wait.until(ExpectedConditions.alertIsPresent()); Thread.sleep(2000); Alert
		 * alert=driver.switchTo().alert(); System.out.println(alert.getText());
		 * alert.dismiss(); Thread.sleep(2000);
		 * if(verificationText(driver).equals("You clicked: Cancel")) {
		 * System.out.println("Test Passed"); }
		 */
		// 3) Prompt alert
		String name = "Prassanna";
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		Alert alert = driver.switchTo().alert();
		String expectedText = "I am a JS prompt";
		if (expectedText.equals(alert.getText())) {
			System.out.println("Test 1 Passed");
		}
		Thread.sleep(5000);
		alert.sendKeys(name);
		alert.accept();

		Thread.sleep(5000);

		if (verificationText(driver).equals("You entered: " + name)) {
			System.out.println("Test 2 Passed");
		}
		Thread.sleep(5000);
		driver.quit();

	}

}
