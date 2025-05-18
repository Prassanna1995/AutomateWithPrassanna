package Day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LocatorsDemo {

	public static void staticWait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		staticWait();
		//id locator is used to locate based on the id attribute of tag it is unique and if a tag has id attribute please use that
		WebElement userName = driver.findElement(By.id("inputUsername"));
		System.out.println(userName.isDisplayed());
		userName.sendKeys("Prassanna");
		staticWait();
		//This is the relativelocator which was introduced in Selenium version 4
		WebElement pwd = driver.findElement(RelativeLocator.with(By.tagName("input")).below(userName));
		// isDisplayed method is used to check if element under test is displayed in UI or not. It returns boolean value
		System.out.println(pwd.isDisplayed());
		pwd.sendKeys("Pwd");
		staticWait();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		// isDisplayed method is used to check if element under test is displayed in UI or not. It returns boolean value
		boolean resumeAssitance = driver
				.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).isDisplayed();
		System.out.println(resumeAssitance);
		// isDisplayed method is used to check if element under test is displayed in UI or not. It returns boolean value
		boolean qaSummitLink = driver.findElement(By.partialLinkText("Rahul Shetty @Pune")).isDisplayed();
		System.out.println(qaSummitLink);
//		try {
//			driver.findElement(By.tagName("img"));
//		}catch (NoSuchElementException e){
//			e.printStackTrace();
//		}
		List<WebElement> imgs=driver.findElements(By.tagName("id"));
		System.out.println(imgs.size());
		driver.quit();

	}

}
