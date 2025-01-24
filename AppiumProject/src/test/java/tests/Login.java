package tests;

import org.openqa.selenium.By;

public class Login extends BaseClass  {
	
	public static void main(String args[]) throws InterruptedException {
		driver.wait(3000);
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("wipic16903@bawsny.com");
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("Rajas@123");
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]")).click();
}
}