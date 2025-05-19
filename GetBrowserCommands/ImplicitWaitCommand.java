package Day27;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitCommand {
/*Implicit Wait - Waits for every element in driver instance*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.quit();
	}

}
