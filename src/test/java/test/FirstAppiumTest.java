package test;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FirstAppiumTest {

WebDriver driver;

@BeforeTest
	  
	  public void setUp() throws MalformedURLException {
		  
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Testg"); 
		  
		// Set BROWSER_NAME desired capability. It's Android in our case here.
		  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		  
		// Set android VERSION desired capability. Set your mobile device's OS version.
		  capabilities.setCapability(CapabilityType.VERSION, "4.3.1");
		  
		  // Set android platformName desired capability. It's Android in our case here.
		  capabilities.setCapability("platformName", "Android"); 
		  capabilities.setCapability("appPackage", "com.zivame.consumer");
		  capabilities.setCapability("appActivity", ".SplashActivity");
		  // Created object of RemoteWebDriver will all set capabilities.
		  // Set appium server address and port number in URL string. 
		  // It will launch calculator app in 
		  
		  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
	  
	  
	  @Test
	  
	  public void firstTest()
	  {
		  // Click on DELETE/CLR button to clear result text box before running test. 
		  //driver.findElements(By.xpath("//android.widget.Button")).get(0).click(); 
		  
		  //sign in button
		  driver.findElement(By.id("user_profile_name")).click();
		  
		  // existing user
		  driver.findElement(By.id("signin_txtview")).click();
		  
		  // user n paswrd fields 		  
		  driver.findElement(By.id("signin_email")).sendKeys("plm@gmail.com");
		  driver.findElement(By.id("signin_password")).sendKeys("qwerty");
		  
		  // Click on sign in button. 
		  driver.findElement(By.id("signin_tv")).click();
		
		 
		  } 
	  
	  
	  @AfterTest 
	  
	  public void End()
	  {
		  
		  driver.quit(); 
		  
	  }
	  
}