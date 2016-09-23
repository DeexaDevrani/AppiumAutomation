package com.zivame.common.scenarios;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

public class ZivameBaseTest {
	
	@BeforeSuite
	
	public void BaseTest() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("cmd /c start D:\\files\\appiumstart.bat");
		
		Thread.sleep(1000);

	}

}
