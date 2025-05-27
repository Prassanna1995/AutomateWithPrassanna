package Day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://testautomationpractice.blogspot.com/";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		List<WebElement> paginationElements=driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		int noOfPages=paginationElements.size();
		for(int p=1;p<=noOfPages;p++) {
			driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()="+p+"]")).click();
			Thread.sleep(2000);
			int noOfRows=driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
			for(int r=1;r<=noOfRows;r++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[2]")).getText());
				System.out.print("\t");
				System.out.print(driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[3]")).getText());
				driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[4]/input")).click();
				System.out.println();
				Thread.sleep(1000);
			}
			
		}
		Thread.sleep(1000);
		driver.quit();
	}

}
