package Day31;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		//Select the single option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		//2.Capture all options
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//label"));
		
		//3.printing options from dropdown
		
		for(WebElement op:options) {
			System.out.println(op.getText());
		}
		
		Thread.sleep(2000);
		
		//4.Selecting multiple options
		
		List<String> selectOptions=new ArrayList<String>();
		selectOptions.add("MySQL");
		selectOptions.add("Python");
		selectOptions.add("C#");
		Thread.sleep(2000);
		for(WebElement op:options) {
			if(selectOptions.contains(op.getText())) {
				op.click();
				Thread.sleep(1000);
			}
		}
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}
