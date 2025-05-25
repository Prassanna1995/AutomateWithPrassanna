package Day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentStaticDropDown {
	/**
	 * Assignment --------------- 1) Handle country dropdown with/without using
	 * Select class:
	 * https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
	 * a) count total number of options b) print all the options c) select one
	 * option
	 * @throws InterruptedException 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String url = "https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/";

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);
		
		WebElement countryElement=driver.findElement(By.xpath("//select[@id='country-list']"));
		
		Select countryOptions=new Select(countryElement);
		
		int optionsSize=6;
		
		for(int i=1;i<optionsSize;i++) {
			String country=countryOptions.getOptions().get(i).getText();
			System.out.println(country);
		}
		
		countryOptions.selectByVisibleText("India");
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
