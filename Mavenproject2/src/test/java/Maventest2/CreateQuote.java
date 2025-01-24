package Maventest2;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CreateQuote {
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub

			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\lib\\chromedriver.exe");;
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().window().maximize();
			driver.get("https://farmers.uat.agent.odysseynext.com/login");// URL
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,500)");
			driver.findElement(By.xpath("//div[@class='black-layout-children']//div[2]//input[1]")).sendKeys("admin@farmers.com");// mailid
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys("Hiren@123456");// pass
			
			//js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/button[1]")).click();// login buttom
			Thread.sleep(3000);

			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/div[1]/div[2]/div[2]/button[1]")).click();
			WebElement searchBox = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"));

			searchBox.sendKeys("11515 Colima Road, Whittier, CA, USA");

			Thread.sleep(2000);
			searchBox.sendKeys(Keys.ENTER);



}
}
