package com.zivame.login.page;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;

public class StartApplication  {
	
private static AndroidDriver< RemoteWebElement > driver; {
	
}
	
	 @SuppressWarnings("unchecked")
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
		  
		  driver = (AndroidDriver<RemoteWebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
	 }
	 
	  

}
