package Day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class StaticTable {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		/*//table[@name='BookTable']/tbody/tr*/
		
		List<WebElement> staticWebTable=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		
		int rows=staticWebTable.size();
		
		/*Get the column count*/
		//int cols=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th")).size();
		
		
		/*Getting value from specific row and column*/
		
		/*Say 5th row and first column*/
		
		/*String bookName=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[5]/td[1]")).getText();
		System.out.println(bookName);
		/*read all data*/
		/*
		for(int r=2;r<=rows;r++) {
			for(int c=1;c<=cols;c++) {
				System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td["+c+"]")).getText()+'\t'+'\t');
			}
			System.out.println();
		}
		*/
		/*
		String targetAuthor="Mukesh";
		for(int r=2;r<=rows;r++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[2]")).getText();
			if(author.equalsIgnoreCase(targetAuthor)) {
				System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[text()='"+author+"']/preceding-sibling::td")).getText());
			}
		}
		*/
		
		/*find the total price*/
		int total=0;
		for(int r=2;r<=rows;r++) {
			String price=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td[4]")).getText();
			int priceValue=Integer.parseInt(price);
			total+=priceValue;
		}
		System.out.println(total);
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
