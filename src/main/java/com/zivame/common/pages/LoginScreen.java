package com.zivame.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zivame.common.pages.BaseClass;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author Deexa
 *
 */

public class LoginScreen extends BaseClass{


		public LoginScreen(AndroidDriver<WebElement> adriver, String TEST_MODE) {
		super(adriver, TEST_MODE);
		System.out.println("Inside LoginScreen Constructor")
	}
		
		By hambugermenuicon = readObjectLoc("hambuger.main.tab");
		By hambugerNewsTab = readObjectLoc("hambuger.main.news.tab");
		By hambugerBooksTab = readObjectLoc("hambuger.main.books.tab");
		By hambugerSettingsTab = readObjectLoc("hambuger.main.setting.tab");
		//hambuger your profile tab can be change to signin/signout
		By hambugerProfileTxt = readObjectLoc("hambuger.your_profile.text");
		By hambugerProfileTab = readObjectLoc("hambuger.main.your_profile.tab");
		//By hambugerToggletab = readObjectLoc("hambuger.main.toggle.tab");
		
	}

