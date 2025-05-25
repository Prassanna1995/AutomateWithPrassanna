package Day31;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		List<String> chromeOptions=new ArrayList<String>();
		chromeOptions.add("start-maximized");
		chromeOptions.add("incognito");
		options.addArguments(chromeOptions);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", country);
		Select selectCountry=new Select(country);
		List<WebElement> countryOptions=selectCountry.getOptions();
		System.out.println(countryOptions.size());
		for(WebElement ele:countryOptions) {
			System.out.println(ele.getText());
		}
		selectCountry.selectByVisibleText("India");
		Thread.sleep(2000);
		selectCountry.selectByValue("brazil");
		Thread.sleep(2000);
		selectCountry.selectByIndex(3);
		Thread.sleep(2000);
		
		//selectCountry.deselectByIndex(3);
//		Thread.sleep(3000);
		driver.quit();
}

}
