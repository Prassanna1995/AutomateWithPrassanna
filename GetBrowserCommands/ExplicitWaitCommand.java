package Day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		/*Explicit wait declaration*/
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebElement userName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		userName.sendKeys("Admin");
		WebElement passWord=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		passWord.sendKeys("admin123");
		WebElement loginBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(normalize-space(),'Login')]")));
		loginBtn.click();
		driver.quit();		
		
	}

}
