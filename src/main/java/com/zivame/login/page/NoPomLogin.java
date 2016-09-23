package com.zivame.login.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NoPomLogin {
	
	public NoPomLogin(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	 driver.findElement(By.id("user_profile_name")).click();
	  
	  // existing user
	  driver.findElement(By.id("signin_txtview")).click();
	  
	  // user n paswrd fields 		  
	  driver.findElement(By.id("signin_email")).sendKeys("plm@gmail.com");
	  driver.findElement(By.id("signin_password")).sendKeys("qwerty");
	  
	  // Click on sign in button. 
	  driver.findElement(By.id("signin_tv")).click();

}
