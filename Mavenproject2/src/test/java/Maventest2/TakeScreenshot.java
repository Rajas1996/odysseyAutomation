package Maventest2;

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import java.io.File;  
import java.io.IOException;  
import org.apache.commons.io.FileUtils;  
import org.openqa.selenium.OutputType;  
import org.openqa.selenium.TakesScreenshot;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;  
  
public class TakeScreenshot {  
WebDriver drv;  
@BeforeClass  
public void setUp() throws Exception {  
FirefoxDriver driver = new FirefoxDriver();  
drv.get("https://google.com");  
}  
@After  
public void tearDown() throws Exception {  
drv.quit();  
}  
  
@Test  
public void test() throws IOException {  
//capture the screenshot  
File scrFile = ((TakeScreenshot)drv).getScreenshotAs(OutputType.FILE);  
// paste the screenshot in the desired location  
FileUtils.copyFile(scrFile, new File("C:\\Screenshot\\Scr.jpg")) ; 
}  
}  
