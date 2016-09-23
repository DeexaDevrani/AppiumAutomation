package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zivame.login.page.Login;
import com.zivame.login.page.LoginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LoginT {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	
	 public void setUp() throws MalformedURLException {	
	
	
	DesiredCapabilities cap= new DesiredCapabilities();
	
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
	
	driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 

}
	
	  
	  @Test
	  	 
   public void VerifyValidLogin() {
		  
		  Login loginpage= new Login(driver);
		  
		  loginpage
		  
		  
	  }
	  
	  
}
	  
	
	
