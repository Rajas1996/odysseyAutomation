package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.opentelemetry.api.logs.Logger;

public class BaseClass {
	
	static AppiumDriver driver;
	
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		
		
		
		setup();
	}
	
	
	
	@BeforeTest
	public static AppiumDriver setup() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("platformName", "ANDROID");
		caps.setCapability("deviceName", "Nothing phone(1)");
		caps.setCapability("uuid", "P12278000659");
		caps.setCapability("platformversion", "14");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("appPackage", "com.odysseynext.unionmutual");
		caps.setCapability("appActivity", "com.odysseynext.unionmutual.MainActivity");
		//caps.setCapability("appPackage", "com.ubercab");
		//caps.setCapability("appActivity", "com.ubercab.presidio.app.core.root.RootActivity");
		//caps.setCapability("app", "C:\\Users\\Taurus11\\Downloads");
		
		
		URL uri = URI.create("http://127.0.0.1:4723").toURL();
		driver = new AppiumDriver(uri,caps);
		
		System.out.println("Application started");
		/*
		 *
		 * System.out.println("Application started"); //Thread.sleep(3000);
		 * Thread.sleep(3000); //driver.findElement(new
		 * AppiumBy.ByAndroidUIAutomator("android.widget.EditText")).sendKeys(
		 * "rajaspitale"); driver.findElement(By.xpath(
		 * "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"
		 * )).click();
		 * 
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"
		 * )).sendKeys("test"); driver.findElement(By.xpath(
		 * "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"
		 * )).click(); Thread.sleep(3000); driver.findElement(By.xpath(
		 * "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"
		 * )).click();
		 */
		/*
		 * Thread.sleep(2000);
		 * driver.findElement(By.id("com.google.android.gms:id/main_title")).click();
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/container\"])[2]/android.widget.LinearLayout"
		 * )).click();
		 */
		Thread.sleep(10000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@resource-id=\"main_top_app_bar_search\"]/android.view.View/android.view.View/android.widget.Button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.reddit.frontpage:id/search")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.view.View[@resource-id=\"search_typeahead_item\"])[1]")).click();
		
		return driver;
		//driver.quit();
	
	}

}
