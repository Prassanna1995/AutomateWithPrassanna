package Day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticTableAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://blazedemo.com/";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		
		WebElement fromPort=driver.findElement(By.name("fromPort"));
		
		Select fromPortOption=new Select(fromPort);
		
		fromPortOption.selectByVisibleText("Boston");
		
		WebElement toPort=driver.findElement(By.name("toPort"));
		
		Select toPortOption=new Select(toPort);
		
		toPortOption.selectByVisibleText("Berlin");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		int rowCount=driver.findElements(By.xpath("//table/tbody/tr")).size();
		double[] d=new double[rowCount];
		for(int i=1;i<=rowCount;i++) {
			WebElement ele=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]"));
			String price=ele.getText().replace('$',' ').trim();
			double priceValue=Double.parseDouble(price);
			d[i-1]=priceValue;
		}
		
		double min=Double.MAX_VALUE;
		
		for(double value:d) {
			if(min>value) {
				min=value;
			}
		}
		WebElement lowestPrice=driver.findElement(By.xpath("//td[contains(text(),'"+String.valueOf(min)+"')]/preceding-sibling::td[5]/input"));
		lowestPrice.click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputName")).sendKeys("Prassanna");
		driver.findElement(By.id("address")).sendKeys("Santhosapuram");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String message=driver.findElement(By.xpath("//h1")).getText();
		
		if(message.contains("Thank you")) {
			System.out.println("Test Successful");
		}
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}

}
