package Day30;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingFrames {
	public static void staticWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		List<String> chromeOptions=new ArrayList<String>();
		chromeOptions.add("start-maximized");
		chromeOptions.add("incognito");
		options.addArguments(chromeOptions);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ui.vision/demo/webtest/frames/");
		//Frame1
		WebElement frame1=driver.findElement(By.xpath("//frame[contains(@src,'frame_1')]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Prassanna");
		staticWait();
		//Frame2
		/*Directly we cannot switch from frame1 to frame2 hence we have to switch to default content*/
		driver.switchTo().defaultContent();
		WebElement frame2=driver.findElement(By.xpath("//frame[contains(@src,'frame_2')]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome");
		staticWait();
		//Frame 3
		driver.switchTo().defaultContent();
		WebElement frame3=driver.findElement(By.xpath("//frame[contains(@src,'frame_3')]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Programming");
		staticWait();
		//Switch to inner frame
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.xpath("//span[normalize-space()='I am a human']")).click();
		staticWait();
		driver.switchTo().defaultContent();
		staticWait();
		driver.quit();
	}

}
