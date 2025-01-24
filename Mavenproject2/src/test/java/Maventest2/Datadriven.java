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

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class Datadriven {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\lib\\chromedriver.exe");;
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://farmers.uat.agent.odysseynext.com/login");// URL
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("admin@farmers.com");// mailid
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div/div/div/div[3]/input")).sendKeys("Hiren@123456");// pass
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/button[1]")).click();// login buttom
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/div[1]/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("11515 dutch iris");
		driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-create\"]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div/div/div[2]/div/div/div/div/div")).click();
		Thread.sleep(200);

		// Manual Address entry
		driver.findElement(By.xpath("//*[@id=\"custom-checker\"]")).click();// Manual Add entry

		FileInputStream fis = new FileInputStream("C:\\Users\\ramesh\\Desktop\\Test Excel.xlsx");
		HSSFWorkbook wk = new HSSFWorkbook(fis);
		HSSFSheet sh = wk.getSheet("Sheet1");

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			HSSFRow rw = sh.getRow(i);
			HSSFCell sn = rw.getCell(0);
			HSSFCell stn = rw.getCell(1);
			HSSFCell zp = rw.getCell(2);
			HSSFCell zs = rw.getCell(3);
			HSSFCell cn = rw.getCell(4);
			HSSFCell st = rw.getCell(5);
			HSSFCell ct = rw.getCell(6);
			HSSFCell res = rw.createCell(8);

			System.out.println("SreetNum....." + sn);
			System.out.println("Streename....." + stn);
			System.out.println("Zipcode....." + zp);
			System.out.println("ZipSuffix....." + zs);
			System.out.println("Country....." + cn);
			System.out.println("State....." + st);
			System.out.println("City....." + ct);
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[1]/div[1]/div/input"))
					.sendKeys(sn.toString());
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[1]/div[2]/div/input"))
					.sendKeys(stn.toString());
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[2]/div[1]/div/input"))
					.sendKeys(zp.toString());
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[2]/div[2]/div/input"))
					.sendKeys(zs.toString());
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[2]/div[3]/div/input"))
					.sendKeys(cn.toString());
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[2]/div[4]/div/input"))
					.sendKeys(st.toString());
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div[3]/section/div/div/div[2]/form/div/div[2]/div[5]/div/input"))
					.sendKeys(ct.toString());
			
			driver.findElement(By.id("primary-colored-btn")).click();// next button

			// Select Property
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[3]/div/div/div/div/div/div[2]/div")).click();// HomeType
			Thread.sleep(5000);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Previous

			WebElement element = driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			element.click();

			//driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click();// Next
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div/button[2]")).click();// Pop up Next

			// Starting Estimate
			Thread.sleep(5000);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Back
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click();// Next

			// Please Add Policy holder/Member Contact Information
			Thread.sleep(2000);
			WebElement textBox =  driver.findElement(By.xpath("//*[@id=\"formBasicEmail\"]"));
			textBox.clear();
			textBox.sendKeys("Leena Brandy");
			driver.findElement(By.xpath("//*[@id=\"formBasicPassword\"]")).sendKeys("test@mail.in");
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/div[4]/section/div/div/div/div/div[1]/div/form/div/div[3]/div/input"))
					.sendKeys("8888899999");

			Thread.sleep(200);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click();// Next

			// Waiting Period
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click(); // Next

			// Construction
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();// Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click(); // Next

			// Construction
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click();// Next

			Thread.sleep(2000);
			// DiscountS
			// driver.findElement(By.xpath("//*[@id="primary-grey-btn-flood"]")).click();//Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click();// Next

			Thread.sleep(2000);
			// Discount
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click();

			// Coverage options
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@id=\"primary-grey-btn-flood\"]")).click();//Previous
			driver.findElement(By.xpath("//*[@id=\"primary-colored-btn\"]")).click(); // 1st Select coverage
			
						
			
			try {
				driver.findElement(By.xpath("//*[@id=\"img-profile\"]")).click();
				Thread.sleep(5000);
				driver.findElement(By.linkText("Log out")).click();
				res.setCellValue("Valid");
				System.out.println("valid");
			} catch (Exception e) {
				System.out.println("Invalid");
				res.setCellValue("Invalid");
			}

		}

		fis.close();
		FileOutputStream outputStream = new FileOutputStream("output.xlsx");
            wk.write(outputStream);
           



	}
	}


	
