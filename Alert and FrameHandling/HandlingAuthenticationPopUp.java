package Day30;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAuthenticationPopUp {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		List<String> chromeOptions=new ArrayList<String>();
		chromeOptions.add("start-maximized");
		//chromeOptions.add("incognito");
		options.addArguments(chromeOptions);
		WebDriver driver=new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com");
		Robot rb=new Robot();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Basic Auth"))).contextClick().build().perform();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> winHandles=driver.getWindowHandles();
		List<String> winHandlesIndex=new ArrayList<String>(winHandles);
		String childHandle=winHandlesIndex.get(1);
		driver.switchTo().window(childHandle);
		Thread.sleep(2000);
		String userName="admin";
		StringSelection userNameCopy=new StringSelection(userName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(userNameCopy, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.quit();
		
		
		
	}

}
