package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * 
 * @ author deexa
 */

import org.testng.annotations.Test;

import com.zivame.login.page.LoginPage;

import io.appium.java_client.android.AndroidDriver;


public class LoginTest {
	
	WebDriver driver;

	@BeforeTest
		  
		  public void setUp() throws MalformedURLException {
			  
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			  capabilities.setCapability("deviceName", "Test"); 
			  
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
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
	}
		  
//		  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Test"); 
		  		  
//		// Set BROWSER_NAME desired capability. It's Android in our case here.
//		  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
//		  
//		// Set android VERSION desired capability. Set your mobile device's OS version.
//		  capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.0");
//		  
//		  // Set android platformName desired capability. It's Android in our case here.
//		  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID); 
//		  
//		  capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_PACKAGE, "com.zivame.consumer");
//		  capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".SplashActivity");
//		  // Created object of RemoteWebDriver will all set capabilities.
//		  // Set appium server address and port number in URL string. 
//		  // It will launch calculator app in 
		  
//		  driver = new AndroidDriver<WebElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		  
//}
	  	  
	  @Test
	  	 
     public void VerifyValidLogin() {
	  
	    LoginPage loginpage= new LoginPage(driver);
//		loginpage.fitCodeLogIn();
	  
		loginpage.zivameLogin("plm@gmail.com", "qwerty");
	  
//		loginpage.validSignIn("plm@gmail.com", "qwerty");
	    
		loginpage.userProfileName();
	  }
	  
//	  if(userprofile==("sunny bun"))
//	  {
//		  System.out.println("Fit profile flow Test case Passed");
//	  }
//	  
//	  else {	
//		  System.out.println("Fit profile flow Test case failed");
//		
//	}
	  
//	  public void ExplicitWait(WebElement element) {
//		  
//		  	(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
//	  }
//	  	  	  
//  }

@AfterTest 

public void End()
{
	  
	  driver.quit(); 
	  
}

}
