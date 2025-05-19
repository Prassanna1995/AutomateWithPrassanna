package Day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class FluentWaitCommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		Wait<WebDriver> wait= new FluentWait<>(driver)
              .withTimeout(Duration.ofSeconds(10))
              .pollingEvery(Duration.ofSeconds(5))
              .ignoring(NoSuchElementException.class);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement userName=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@placeholder='Username']"));
			}
		});
		userName.sendKeys("Admin");
		Thread.sleep(2000);
		driver.quit();
	}

}
