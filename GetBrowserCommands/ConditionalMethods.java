package Day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.nopcommerce.com/register");
		//Thread.sleep(7000);
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		boolean logoDisplayStatus=logo.isDisplayed();
		System.out.println("Display Status :"+logoDisplayStatus);
		WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
		boolean firstNameEnabledStatus=firstName.isEnabled();
		if(firstNameEnabledStatus) {
			firstName.sendKeys("Prassanna");
		}
		WebElement maleRadioButton=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement femaleRadioButton=driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println("Select male and verify the status ");
		maleRadioButton.click();
		System.out.println("Male Selected Status: "+maleRadioButton.isSelected());
		System.out.println("Female Selected Status: "+femaleRadioButton.isSelected());
		Thread.sleep(2000);
		System.out.println("Select female and verify the status ");
		femaleRadioButton.click();
		System.out.println("Male Selected Status: "+maleRadioButton.isSelected());
		System.out.println("Female Selected Status: "+femaleRadioButton.isSelected());
		Thread.sleep(2000);
		WebElement newsLetterCheckBox=driver.findElement(By.xpath("//input[@id='Newsletter']"));
		System.out.println("Newsletter selection status:"+newsLetterCheckBox.isSelected());
		Thread.sleep(2000);
		driver.quit();
		
		
	
	}

}
