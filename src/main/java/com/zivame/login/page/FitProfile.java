/**
 * 
 */
package com.zivame.login.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Deexa
 *
 */
public class FitProfile {
	
	
	public FitProfile(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="proceed_to_questions2")
	public WebElement fitCodePopUP;
	

	 @AndroidFindBy(id="sign_in_to_get_fitcode ")
	 public  WebElement FitCodeSignIn;
	  
	 public void fitCodeLogIn() {
		 fitCodePopUP.click();
		 FitCodeSignIn.click();
		}
}
