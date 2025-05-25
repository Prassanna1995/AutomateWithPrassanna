package Day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingMultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://testautomationpractice.blogspot.com/";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		WebElement colorOptions=driver.findElement(By.xpath("//select[@id='colors']"));
		Select options=new Select(colorOptions);
		
		options.selectByVisibleText("Red");
		options.selectByVisibleText("Blue");
		
		Thread.sleep(2000);
		
		options.deselectAll();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}

}
