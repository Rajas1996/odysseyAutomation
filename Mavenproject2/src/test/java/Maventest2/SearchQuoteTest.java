package Maventest2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class SearchQuoteTest  {
	
	@Test
	public void quotesearch() throws InterruptedException, IOException {
		//FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--headless");
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\lib\\geckodriver.exe");
	//WebDriver driver = new ChromeDriver();
	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.manage().window().maximize();
	
	Properties obj = new Properties();					
    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\path.properties");									
    obj.load(objfile);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	driver.get("https://farmers.uat.agent.odysseynext.com/login");
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,500)");
	driver.findElement(By.id(obj.getProperty("login"))).sendKeys("rajas.pitale@thinktaurus.com");
	driver.findElement(By.id(obj.getProperty("password"))).sendKeys("Rajas@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[2]/div[1]/span[1]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("TMP240614603012");
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[10]/button[1]")).click();
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[contains(text(),'TMP240617036553')]")).click();
	//*[@id="cell-s_PolicyQuoteNo-840"]/div
	/*
	 * WebElement search_results =
	 * driver.findElement(By.xpath("//div[@class='css-1m8a2xx']"));
	 * 
	 * String search_result_text = search_results.getText();
	 * if(search_result_text.contains("TMP240614603012")) {
	 * 
	 * }
	 */
	  
	//driver.close();
	
	
	
}
}


