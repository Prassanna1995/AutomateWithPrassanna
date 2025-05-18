package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathLocator {
/*xpath syntax //tagname[@attribute='value'] or if the tag name is not known
 * use //*[@attribute='value']*/
	public static void staticWait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		/*Get the element of first name using xpath*/
		
		WebElement firstName=driver.findElement(By.xpath("//input[@id='userName']"));
		if(firstName.isDisplayed()) {
			System.out.println("Element located using xpath");
		}
		/*xpath with multiple attribute
		 *Syntax //tag[@attribute1='value'][@attribute2='value']
		 * Here in both the attributes should be correct else it won't locate element
		 **/
		WebElement email=driver.findElement(By.xpath("//input[@id='userEmail'][@placeholder='name@example.com']"));
		if(email.isDisplayed()) {
			System.out.println("Element located using multiple attribute xpath");
		}
		/*and or xpath
		 * Syntax //tag[@attribute='value' and @attribute='value']
		 * //tag[@attribute='value' or @attribute='value']
		 * It works similar to logical and or
		 */
		WebElement currentAddress=driver.findElement(By.xpath("//textarea[@id='currentAddress' and @placeholder='Current Address']"));
		if(currentAddress.isDisplayed()) {
			System.out.println("Element located and xpath");
		}
		/*Simlarly xpath can be located using or*/
		
		/*Xpath with inner text 
		 * Syntax //tag[text()='value']
		 */
		WebElement fullNameLabel=driver.findElement(By.xpath("//label[text()='Full Name']"));
		if(fullNameLabel.isDisplayed()) {
			System.out.println("Element located using inner Text Xpath");
		}
		
		/*xpath with contains
		 * Syntax //tag[contains(@attribute,'partial text of element')]
		 * 
		 * */
		WebElement permanentAddress=driver.findElement(By.xpath("//textarea[contains(@id,'nentAddress')]"));
		
		if(permanentAddress.isDisplayed()) {
			System.out.println("Element located using contains xpath");
		}
		WebElement permanentAddressWithStartsWith=driver.findElement(By.xpath("//textarea[starts-with(@id,'permanent')]"));
		
		if(permanentAddressWithStartsWith.isDisplayed()) {
			System.out.println("Element located using starts with xpath");
		}
		/*Chained xpath if there are no attributes and values 
		 * Syntax //parenttag[@attribute='value']/child
		 */
		WebElement permanentAddressLabel=driver.findElement(By.xpath("//div[@id='permanentAddress-wrapper']/div/label"));
		String actualLabelText=permanentAddressLabel.getText();
		String expectedLabelText="Permanent Address";
		if(actualLabelText.equalsIgnoreCase(expectedLabelText)) {
			System.out.println("Test Passed");
		}
		staticWait();
		closeBrowser(driver);
		
		
		
		
	}

}
