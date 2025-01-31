package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateQuote {
	
	ChromeDriver driver;
	
	
		@Given("User is on dashboard page")
		public void user_is_on_dashboard_page() {
		     driver = new ChromeDriver();
		  
		}

		@When("User cliks on create quote button")
		public void user_cliks_on_create_quote_button() {
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		    
		}

		@And("User Inputs property address")
		public void user_inputs_property_address() throws InterruptedException, FileNotFoundException {
			   //WebElement addressfld = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
			   //addressfld.click();
			   Thread.sleep(2000);
			   FileInputStream fis= new FileInputStream("C:\\Users\\Taurus11\\Desktop\\gitOdyssey\\CucumberHybrid\\resource\\testdata\\Address sample.xlsx");
				try {
					XSSFWorkbook workbook = new XSSFWorkbook(fis);
					XSSFSheet sheet = workbook.getSheet("Test");
					int rowcount = sheet.getLastRowNum();
					int columncount=sheet.getRow(1).getLastCellNum();
					System.out.println("rowcount:"+rowcount+ "columncount:"+columncount);
					for(int i=0;i<=rowcount;)
					{
						for(int j=0;j<=i;) {
						WebElement addressfld1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
						XSSFRow celldata =sheet.getRow(i);
						String address = celldata.getCell(0).getStringCellValue();
						addressfld1.sendKeys(address);
						Thread.sleep(2000);
						addressfld1.sendKeys(Keys.ENTER);
						
						Thread.sleep(1000);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;

						  // Next button
						  driver.findElement(
						    By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/section/div/div/div[2]/div/div[2]/button"))
						    .click();

						  Thread.sleep(5000);
						  // Select Property type home
						  driver.findElement(By.xpath(
						    "//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]"))
						    .click();

						  js1.executeScript("window.scrollBy(0,800)");
						  Thread.sleep(2000);
						  // Click next
						  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div[2]/button[2]"));

						  Thread.sleep(2000);

						  // Property details click next
						  driver.findElement(
						    By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div[2]/button[2]"))
						    .click();

						  Thread.sleep(2000);

						  // Your Property Information
						  driver.findElement(
						    By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/section/div/div[2]/button[2]"))
						    .click();
						  Thread.sleep(500);
						  // Usage type
						  WebElement Usage = driver.findElement(By.xpath("//*[@id=\"formBasicEmail\"]"));
						  Select selectYear = new Select(Usage);
						  selectYear.selectByVisibleText("Primary");

						  Thread.sleep(2000);
						  // Confirm Your Property Information
						  driver.findElement(By.xpath("//*[@id=\"chakra-modal-:rn:\"]/footer/div/button[2]")).click();

						  Thread.sleep(2000);
						  // Estimate Premium screen
						  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div/div[2]/div/button[2]"))
						    .click();

						  Thread.sleep(2000);
						  // Additional Info
						  driver.findElement(By.xpath(
						    "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/section[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[4]/div[1]/input[1]"))
						    .sendKeys("test@mail.in");
						  driver.findElement(By.xpath(
						    "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/section[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[5]/div[1]/input[1]"))
						    .sendKeys("9899865478");

						  Thread.sleep(2000);
						  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div/div/button[2]"))
						    .click();

						  Thread.sleep(2000);
						  // Waiting Period
						  driver.findElement(
						    By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/section/div/div[2]/div/button[2]"))
						    .click();

						  Thread.sleep(2000);
						  // Construction Details
						  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div/div/button[2]"))
						    .click();

						  js1.executeScript("window.scrollBy(0,1000)");
						  Thread.sleep(1000);
						  // Construction Details2
						  driver.findElement(
						    By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/section/div[2]/div/button[2]"))
						    .click();

						  Thread.sleep(2000);
						  // Discounts
						  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div/div/button[2]"))
						    .click();

						  Thread.sleep(2000);
						  // Discounts2
						  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div/div/button[2]"))
						    .click();

						  Thread.sleep(2000);

						  WebElement Billto = driver.findElement(By.xpath("//*[@id=\"flood-pricing-plan-select\"]"));
						  Select selectMonth = new Select(Billto);
						  selectMonth.selectByIndex(1);

						  Thread.sleep(1000);
						  WebElement element = driver.findElement(By.xpath(
						    "//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/table/tbody/tr[8]/td[2]/div/button"));
						  Actions actions = new Actions(driver);

						  // Scroll until the element is in view
						  actions.moveToElement(element).click().perform();

						  Thread.sleep(3000);
							/*
							 * System.out.println( driver.findElement(By.xpath(
							 * "//*[@id=\"root\"]/div/div[3]/div/div[2]/div[1]/div/p")).getText());
							 */
						  if(driver.getPageSource().contains("Quote Saved Successfully"))
							 {
								 System.out.println("Quote Created Successfully ");
							 }
							 
							 else {
								 System.out.println("Quote Created failed ");
								 
							 }
						  Thread.sleep(2000);
						  
						  driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
						  Thread.sleep(2000);
						
						  j++;
						
					}
						i++;
					}
						
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			    
			}

		@Then("Quote successfully gets created")
		public void quote_successfully_gets_created() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

	}
