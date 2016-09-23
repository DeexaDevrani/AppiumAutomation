package com.zivame.login.page;

import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


	public class Login {

		AndroidDriver<MobileElement> driver;

		public Login (AndroidDriver<MobileElement> driver)

		{ this.driver = driver; }
	
//  Menu sign in button
	@AndroidFindBy(id="user_profile_name")
	public WebElement signUpButton;
	
//  Zivame login for existing user
	 @AndroidFindBy(id="signin_txtview ")
	 public  WebElement ZivameLogin;
	  
	 @AndroidFindBy(id="signin_email")
	 public  WebElement EmailId;
	 
	 @AndroidFindBy(id="signin_password")
	 public WebElement Password;
	  
	 @AndroidFindBy(id="signin_tv")
	 public WebElement SignInButton;
	 
	 @AndroidFindBy(className="user_profile_name")
		public WebElement userName;

}
