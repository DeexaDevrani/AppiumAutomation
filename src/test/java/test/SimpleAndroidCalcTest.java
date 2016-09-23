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

	public class SimpleAndroidCalcTest  {
		
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
			  capabilities.setCapability("appPackage", "com.example.calcapplication");
			  capabilities.setCapability("appActivity", ".MainActivity");
			  // Created object of RemoteWebDriver will all set capabilities.
			  // Set appium server address and port number in URL string. 
			  // It will launch calculator app in 
			  
			  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }
		  
		  
		  @Test
		  
		  public void Sum()
		  {
			  // Click on DELETE/CLR button to clear result text box before running test. 
			  //driver.findElements(By.xpath("//android.widget.Button")).get(0).click(); 
			  
			  // Click on number 2 button. 
			  driver.findElement(By.id("edtno1")).sendKeys("2");
			  // Click on + button.
			  driver.findElement(By.id("edtno2")).sendKeys("5");
			  // Click on number 5 button.
			  driver.findElement(By.id("rdAdd")).click();
			  // Click on = button. 
			// String reult= driver.findElement(By.id("resulttxtView")).getAttribute("value");
			  // Get result from result text box. 
			  String result = driver.findElement(By.className("android.widget.TextView")).getText();
			  System.out.println("Number sum result is : " + result);
			  } 
		  
		  
		  @AfterTest 
		  
		  public void End()
		  {
			  
			  driver.quit(); 
			  
		  }
		  
	}

}
