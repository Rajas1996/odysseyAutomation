package Maventest2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public static void invoke() throws InterruptedException {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\lib\\geckodriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://farmers.uat.agent.odysseynext.com/login");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='black-layout-children']//div[2]//input[1]")).sendKeys("rajas.pitale@thinktaurus.com");
		driver.findElement(By.xpath("(//input[@id='formBasicEmail'])[2]")).sendKeys("Rajas@123");
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
		
	
		
	
	

		
		
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[2]/div[1]/span[1]")).click();
		/*
		 * Thread.sleep(5000); driver.findElement(By.xpath(
		 * "/html/body/div[1]/div/div[3]/div/div/div[2]/section/div/div/div[2]/div/div[1]/div/div/div[1]"
		 * )).sendKeys("11515 dutch");
		 */
//		Select drpdwn = new Select(driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]")));
//        drpdwn.selectByVisibleText("11515 dutch iris");
		
		
		
		
			
			
		
	

	
	


