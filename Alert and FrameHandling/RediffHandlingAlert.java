package Day30;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RediffHandlingAlert {
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
		driver.get("https://mypage.rediff.com/login/dologin");
		WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
		loginButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt=driver.switchTo().alert();
		staticWait();
		System.out.println(alt.getText());
		staticWait();
		alt.accept();
		driver.quit();
		
		
	}

}
