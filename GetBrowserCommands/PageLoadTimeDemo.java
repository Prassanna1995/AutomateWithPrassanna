package Day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();
		/*Here the page is getting loaded but element is not yet hence selenium throws exception*/
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.quit();
	}

}
