package Day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleOptionsCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Testing");
		Thread.sleep(5000);
		int count=driver.findElements(By.xpath("//ul[@role='listbox']/li")).size();
		System.out.println(count);
		driver.quit();
	}

}
