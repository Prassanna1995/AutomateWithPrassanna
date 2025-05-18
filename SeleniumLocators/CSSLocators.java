package Day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
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
		String url="https://demo.nopcommerce.com/";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		/*CSS Selector id selector
		 * tag id
		 * tag#id*/
		WebElement searchBox=driver.findElement(By.cssSelector("input#small-searchterms"));
		searchBox.sendKeys("T-shirts");
		staticWait();
		/*CSS Selector class selector
		 * tag class
		 * tag.class
		 * Accessing Search box in above site using class
		 * class="button-1 search-box-button"
		 * planning to use button.search-box-button as it is uniquely identifying Search Button*/
		
//		WebElement searchButton=driver.findElement(By.cssSelector("button.search-box-button"));
//		searchButton.click();
		/*Commenting above line of code because it is asking for verifying human*/
		
		/*CSS Selector with tag and Attribute
		 * trying to get the title for Show products in category Electronics with tag a
		 * h2  a[title='Show products in category Electronics']
		 * here why h2 is used kindly check from your end for answer as this might be one of interview question*/
		
		WebElement electronics=driver.findElement(By.cssSelector("h2  a[title='Show products in category Electronics']"));
		String textToVerify=electronics.getText();
		
		System.out.println(textToVerify);
		
		driver.quit();
		
		
		
		

	}

}
