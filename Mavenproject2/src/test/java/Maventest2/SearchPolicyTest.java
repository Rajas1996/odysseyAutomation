package Maventest2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class SearchQuoteTest  {
	
	@Test
	public void quotesearch() throws InterruptedException {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\lib\\geckodriver.exe"); 
	//WebDriver driver = new ChromeDriver();
	WebDriver driver = new FirefoxDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	driver.get("https://farmers.uat.agent.odysseynext.com/login");
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,500)");
	driver.findElement(By.xpath("//div[@class='black-layout-children']//div[2]//input[1]")).sendKeys("rajas.pitale@thinktaurus.com");
	driver.findElement(By.xpath("(//input[@id='formBasicEmail'])[2]")).sendKeys("Rajas@123");
	driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[3]/div[1]/span[1]")).click();
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/input[1]")).sendKeys("test");
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/button[1]")).click();
  WebElement search_results = driver.findElement(By.className("ag-header-cell-text"));

  String search_result_text = search_results.getText();
  if(search_result_text.contains("Results for 'test'") && !search_result_text.contains("No Rows To Show")) {
  System.out.println("Search Test Passed");
  }
  else {
  System.out.println("Search Test Failed");
  }
  driver.close();
  	
	
	
}
}
