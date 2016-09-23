package com.zivame.login.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage  {
	
	// Page Initialization  
	
		
//	public LoginPage(WebDriver driver) {
//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}

//	 @AndroidFindBy(id="proceed_to_questions2")
//		public WebElement fitCodePopUP;
//		
//
//	 @AndroidFindBy(id="sign_in_to_get_fitcode")
//		public  WebElement FitCodeSignIn;
//	 
	 
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
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
	 
	  
//		 public void fitCodeLogIn() {
//			 fitCodePopUP.click();
//			 FitCodeSignIn.click();
//			}
	 
		public void userProfile() {
			 signUpButton.click();
			}
		 
		 public void zivameLogin(String uid, String pwd) {
			 ZivameLogin.click();
			 
			  EmailId.sendKeys(uid);
			   Password.sendKeys(pwd);
			   SignInButton.click();
		 }
		 
//		 public void validSignIn( String uid, String pwd){
//			   EmailId.sendKeys(uid);
//			   Password.sendKeys(pwd);
//			   SignInButton.click();
//			}
		 
		 public void userProfileName(){
			 
			 String userPName= userName.getText();
			 
			  System.out.println("Actual Result Text is = " + userPName);
			 
		 }
		 
//		 public boolean verifyfitRecomScreen(String result) {
//			 
//			 if(recommandadtionsTxt.equals(result)){
//			return true;
//			 }
//			
//			else{
//				return false;
//			}
//			
//		}
}
		 
		 
	 
//   Zivame Registration
//	 @AndroidFindBy(id="register_txtview");
//	 public WebElement ZivameReg;
//	 
//	 @AndroidFindBy(id="register_fname");
//	 public WebElement FirstName;
//	 
//	 @AndroidFindBy(id="register_lname");
//	 public WebElement LastName;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement regemailId;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement password;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement gender;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement zsignup;
//	 
////   G+ login
//	 
//	 @AndroidFindBy(id="layout_google");
//	 public WebElement Glogin;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement Gmailid;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement Gpwd;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement Gsignin;
//	 
////   FB login
//	 
//	 @AndroidFindBy(id="layout_facebook");
//	 public WebElement FBlogin;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement FBmailid;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement FBpwd;
//	 
//	 @AndroidFindBy(id="");
//	 public WebElement FBsignin;
	 
//	 public void gmailLogin() {
//			
//		}
//	 
//	 public void facebookLogin(String uid, String pwd) {
//			
//		}
//	 
//	 public void newResistration() {
//			
//		}
	 
//	 public void profileDetails() {
//		 
//		 WebElement txtResult;
//		   
//		}
//		 
//	public boolean VerifyResult(String result) {
//			if (txtResult.getText().equals(result))
//				return true;
//			else
//				return false;
//		}

	 
