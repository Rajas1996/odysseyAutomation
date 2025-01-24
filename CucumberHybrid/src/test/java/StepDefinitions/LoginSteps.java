package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps {
	static WebDriver driver;
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.manage().window().maximize();
	    driver.get("https://farmers.uat.agent.odysseynext.com/login");
	    Thread.sleep(4000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    
	}
	
	
	@When("^I enter value in (.*) field$")
	public void i_enter_value_in_email_field(String username) throws InterruptedException {
	    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/input[1]")).sendKeys(username);
	    Thread.sleep(4000);
	}
	    
	    @And("I Click Next Button")
	    public void i_click_next_button() throws InterruptedException {
	    	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/button[1]")).click();
	    	Thread.sleep(4000);
	    }

	    
	

	@And("^I enter values in (.*) field$")
	public void i_enter_values_in_password_field(String password ) throws InterruptedException {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/input[1]")).sendKeys(password);
		Thread.sleep(4000);
	    
	}

	@And("I click on enter Button")
	public void i_click_on_enter_button() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")).click();
	    
	}

	@Then("I should able to log into system")
	public void i_should_able_to_log_into_system() {
	    //Assert.assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]")));
	    
	}
	
	@Then("User click on quote button")
	public void user_click_on_quote_button() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
	    
	}

	@Then("user add home address")
	public void user_add_home_address() throws InterruptedException, FileNotFoundException {
	   //WebElement addressfld = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"));
	   //addressfld.click();
	   Thread.sleep(2000);
	   FileInputStream fis= new FileInputStream("C:\\Users\\Taurus11\\Desktop\\MobileAppium\\Test\\resource\\testdata\\Address sample.xlsx");
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
	
	public static void main(String args[]) throws FileNotFoundException, InterruptedException
	{
		
		
	}

}