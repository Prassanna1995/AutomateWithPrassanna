package Day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepCommandPractice {
	
	/*Thread.sleep() --> Directly from Java which pauses the execution
	 * NoSuchElementException - Element is not present on the page . Synchronization
	 * ElementNotFoundException - Locators is not present
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);/*Very easy to use*/
		/*Disadvantage after lauching page and element loads with in 2 seconds now thread.sleep will wait until
		 * 5 seconds which is causing poor performance
		 * Thread.sleep is not dynamic which is not best to handle SYnchronization
		 */
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.quit();
		
		
	}

}
