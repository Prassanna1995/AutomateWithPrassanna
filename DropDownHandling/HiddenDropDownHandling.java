package Day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

		driver.findElement(By.xpath("//div/label[text()='Job Title']/parent::div/following-sibling::div")).click();

		List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']/span"));
		String role = "Automaton Tester";
		for (WebElement op : options) {
			String selectRole = op.getText();
			if (selectRole.equals(role)) {
				op.click();
				break;
			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/label[text()='Employment Status']/parent::div/following-sibling::div"))
				.click();
		List<WebElement> employmentStatus = driver.findElements(By.xpath("//div[@role='option']/span"));

		String employemntStatusRole = "Full-Time Contract";

		for (WebElement employmentStatusOption : employmentStatus) {
			String option = employmentStatusOption.getText();
			if (employemntStatusRole.equals(option)) {
				employmentStatusOption.click();
				break;
			}
		}
		Thread.sleep(2000);

		driver.quit();
	}

}
