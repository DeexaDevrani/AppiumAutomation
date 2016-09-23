//package test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.zivame.login.page.LoginPage;
//
//public class POMTest {
//	
//	WebDriver driver;
//
//	@BeforeTest
//		  
//		  public void setUp() throws MalformedURLException {
//			  
//			  DesiredCapabilities capabilities = new DesiredCapabilities();
//			  capabilities.setCapability("deviceName", "Test"); 
//			  
//			// Set BROWSER_NAME desired capability. It's Android in our case here.
//			  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
//			// Set android VERSION desired capability. Set your mobile device's OS version.
//			  capabilities.setCapability(CapabilityType.VERSION, "4.3.1");
//			  // Set android platformName desired capability. It's Android in our case here.
//			  capabilities.setCapability("platformName", "Android"); 
//			  capabilities.setCapability("appPackage", "com.zivame.consumer");
//			  capabilities.setCapability("appActivity", ".SplashActivity");
//			  // Created object of RemoteWebDriver will all set capabilities.
//			  // Set appium server address and port number in URL string. 
//			  // It will launch calculator app in 
//			  
//			  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
//		  
//	
//	@Test
//	public void SimpleTest() {
//
//		LoginPage login = new LoginPage(driver);
//
//		login.validSignIn("plm@gmail.com", "qwerty");
//
//		if (login.VerifyResult(""))
//			System.out.println("PASSED Test");
//		else
//			System.out.println("FAILED Test");
//
//	}
//	
//}
