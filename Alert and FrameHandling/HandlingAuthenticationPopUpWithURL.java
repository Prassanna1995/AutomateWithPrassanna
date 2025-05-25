package Day30;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAuthenticationPopUpWithURL {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		List<String> chromeOptions=new ArrayList<String>();
		chromeOptions.add("start-maximized");
		chromeOptions.add("incognito");
		options.addArguments(chromeOptions);
		WebDriver driver=new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String url="http://the-internet.herokuapp.com/basic_auth";
		/*Syntax http://username:password@url*/
		String userName="admin";
		String password="admin";
		String[] splittedUrl=url.split("//");
		String authenticatedUrl=splittedUrl[0]+"//"+userName+":"+password+"@"+splittedUrl[1];
		
		driver.get(authenticatedUrl);
		Thread.sleep(2000);
		
		
		driver.quit();
		
	}

}
