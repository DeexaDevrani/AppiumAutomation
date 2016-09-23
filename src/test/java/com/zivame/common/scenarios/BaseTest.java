//package com.zivame.common.scenarios;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//import org.apache.commons.exec.CommandLine;
//import org.apache.commons.exec.DefaultExecuteResultHandler;
//import org.apache.commons.exec.DefaultExecutor;
//import org.ini4j.Ini;
//import org.ini4j.Profile;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//
//import com.zivame.common.scenarios.ExcelReport;
//import com.zivame.utils.CommonUtils;
//
//import com.relevantcodes.extentreports.DisplayOrder;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.GridType;
//import com.relevantcodes.extentreports.LogStatus;
//
//
//public class BaseTest extends TestListenerAdapter
//{
//	
//		//Global Section 
//		private String APP_PKG;
//		private String APP_ACTIVITY;
//		private String PLATFORM_NAME;
//		private String DEVICE;	
//		private String RESULTS_DIR;
//		
//		//From Device Version Section
//		private String APPIUM_HOST;
//		private String APPIUM_PORT;
//		private String PLATFORM_VERSION;
//		private String DEVICE_NAME;
//		protected  String TEST_MODE;
//		private String AUTOMATION_NAME;
//		private String SELENDROID_PORT;
//		private String BOOTSTRAP_PORT;
//		private String CHROMEDRIVER_PORT;
//		protected String APPLICATION_NAME;
//		
//		//From Appium Server Section
//		private String NODE_PATH; 
//		private String APPIUM_JS_PATH;
//		
//			
//		private URL SERVER_URL;
//		private DesiredCapabilities capabilities = new DesiredCapabilities();
//		protected  ExtentReports extent = ExtentReports.get(BaseTest.class);
//		public String reportLocation = System.getProperty("user.dir");
//		protected AndroidDriver<WebElement> adriver;
//		private static String dirName;
//		
//		@BeforeSuite
//		public static void initReporting()
//		{
//			Long Id = CommonUtils.getCurrentTimeStamp();
//			dirName = System.getProperty("user.dir") + "\\Reports\\SuiteRun_"+Id;
//			
//			System.out.println(dirName);
//			
//			File file = new File(dirName);
//			if (!file.exists()) 
//			{
//				if (file.mkdir())
//				{
//					System.out.println("Directory is created!");
//					ExcelReport ex = new ExcelReport();
//					ex.CreateExcel(dirName);
//				}
//				else 
//				{
//					System.out.println("Failed to create directory!");
//				}
//			}
//		}
//		
//		@Parameters({ "test-name" })
//		@BeforeTest
//		public void testLevelReport(String testName)
//		{
//			//Initialize Reporting per Test			
//			System.out.println("Calling Init Reporting "+dirName);
//			extent.init(dirName+"\\TestReport_"+testName+"_"+Thread.currentThread().getId()+".html", true, DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);			     
//	        extent.config().documentTitle("Newshunt Mobile Automation Run Summary");	         
//	        extent.config().reportHeadline("Newshunt Mobile Automation Run Summary");
//		}
//		@Parameters({ "test-name","version" })
//		@BeforeClass
//		public void setup(String testName, String version) throws Exception
//		{
//		
//			/*//Initialize Reporting per Test			
//			System.out.println("Calling Init Reporting "+dirName);
//			extent.init(dirName+"\\TestReport_"+testName+"_"+Thread.currentThread().getId()+".html", true, DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);			     
//	        extent.config().documentTitle("Newshunt Mobile Automation Run Summary");	         
//	        extent.config().reportHeadline("Newshunt Mobile Automation Run Summary");*/
//			
//	        //Start Test			
//			extent.startTest("Setup for "+testName,"Initializes a test : Maps the device to a server / Starts Appium Server / Initializes a driver");
//	      	      
//			try 
//			{
//				System.out.println("Loading Config Properties Files");
//				extent.log(LogStatus.INFO, "<span class='label info'>info</span> Loading Config Properties Files");
//				loadConfig(version);
//				
//			}
//			catch(Exception e)
//			{
//				extent.log(LogStatus.FATAL, "<span class='label failure'>failure</span>Unable to load the config property files<pre>"+e+"</pre");
//				throw new IOException("Unable to load the config property files", e);
//			}
//		
//			Long id = Thread.currentThread().getId();
//			String Id = testName+"_"+id;
//			System.out.println("Starting Appium Server : "+Id);
//			extent.log(LogStatus.INFO, "<span class='label info'>info</span> Starting Appium Server");
//			startAppiumServer(Id);		
//			
//			try 
//			{			
//				adriver = getDriver();
//			} 
//			catch (MalformedURLException e)
//			{
//				e.printStackTrace();
//				extent.log(LogStatus.FATAL, "<span class='label failure'>failure</span>Unable to load driver !!<pre>"+e+"</pre");
//				throw new MalformedURLException("Unable to load driver !!");
//			}
//		
//			  extent.endTest();
//			
//		}
//		
//		public void loadConfig(String version) throws IOException
//		{
//			   System.out.println("Loading Config INI File");
//			   extent.log(LogStatus.INFO, "<span class='label info'>info</span> Loading Config Ini File");
//				try
//				{
//					System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.ini");
//					FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.ini");
//					Ini ini = new Ini();
//					ini.load(fis);
//					
//						//Load the Global Section
//						Profile.Section  global = ini.get("Global_Appium");
//						
//						this.PLATFORM_NAME = global.fetch("platform.name");
//						this.DEVICE = global.fetch("device");	
//						this.RESULTS_DIR = global.fetch("ResultsDir"); 
//						System.out.println("Loading Config INI File "+RESULTS_DIR );
//					// Load the version section passed 
//					   Profile.Section deviceVersion = ini.get(version);
//					   
//					    this.APP_PKG = deviceVersion.fetch("application.pkg");
//						this.APP_ACTIVITY = deviceVersion.fetch("application.activity");
//						this.APPIUM_HOST = deviceVersion.fetch("appiumHost");
//						this.APPLICATION_NAME = System.getProperty("user.dir")+"\\src\\test\\resources\\app\\"+deviceVersion.fetch("appName");
//						this.APPIUM_PORT = deviceVersion.fetch("appiumPort");
//						this.PLATFORM_VERSION = version;
//						this.DEVICE_NAME = deviceVersion.fetch("deviceName");
//						this.TEST_MODE = deviceVersion.fetch("testMode");
//						System.out.println("Loading Config INI File "+TEST_MODE );
//						if(this.TEST_MODE.equalsIgnoreCase("APP"))
//						{
//							this.AUTOMATION_NAME = "Appium";
//							if (!deviceVersion.fetch("selendroidPort").equalsIgnoreCase("NOPORT"))
//							{
//								this.SELENDROID_PORT="NOPORT";
//							}
//						}
//						else if(this.TEST_MODE.equalsIgnoreCase("SEL"))
//						{
//							AUTOMATION_NAME = "Selendroid";
//							if (deviceVersion.fetch("selendroidPort").equalsIgnoreCase("NOPORT"))
//							{
//								System.out.println("Please enter a valid Selendroid Port Number");
//							}
//							else
//							{
//								SELENDROID_PORT = deviceVersion.fetch("selendroidPort");
//							}
//						}
//						
//						this.BOOTSTRAP_PORT = deviceVersion.fetch("bootstrapPort");
//						this.CHROMEDRIVER_PORT = deviceVersion.fetch("chromeDriverPort");	
//				
//				    // Load the Appium Server Section depending on Appium Host entry
//						Profile.Section serverVersion = ini.get(APPIUM_HOST);
//										
//						this.NODE_PATH = serverVersion.fetch("nodeExe");
//						this.APPIUM_JS_PATH = serverVersion.fetch("appiumJS");
//						System.out.println(NODE_PATH);
//						System.out.println(APPIUM_JS_PATH);
//					
//									
//					fis.close();
//				
//				}
//				catch(IOException e)
//				{
//					//System.out.println("Unable to read property from  Device Mapping Properties File!!");
//					//e.printStackTrace();
//					extent.log(LogStatus.FATAL, "<span class='label failure'>failure</span> Unable to read property from  Device Mapping Properties File!!");
//					throw new IOException("Unable to read property from  Device Mapping Properties File!!", e);
//				}	
//				
//					
//		}
//		
//		 // This method Is responsible for starting appium server. 
//		public void startAppiumServer(String Id) throws Exception
//		{
//			//System.out.println("Starting Appium Server");
//			
//			 // Created object of apache CommandLine class.
//			// It will start command prompt In background.
//			
//			CommandLine command = new CommandLine("cmd");
//			
//			 // Add different arguments In command line which requires to start appium server. 
//			command.addArgument("/k");
//			command.addArgument("\""+NODE_PATH+"\"");
//			command.addArgument("\""+APPIUM_JS_PATH+"\"");
//			
//			//set server address
//			command.addArgument("--address");
//			// appium host is 127.0.0.1
//			command.addArgument(APPIUM_HOST);
//			
//			// set port			
//			command.addArgument("--port");
//			
//			//4723
//			command.addArgument(APPIUM_PORT);
//			
//			//selendroid instrumentation
//			command.addArgument("--bootstrap-port");
//			command.addArgument(BOOTSTRAP_PORT);
//			command.addArgument("--chromedriver-port");
//			command.addArgument(CHROMEDRIVER_PORT);
//			
//			
//			if( this.TEST_MODE.equalsIgnoreCase("SEL"))
//			{
//				command.addArgument("--selendroid-port");
//				command.addArgument(SELENDROID_PORT);
//			}
//			
//			command.addArgument("--udid");
//			command.addArgument(DEVICE_NAME);
//			
//			//logging the status of appium server
//			command.addArgument("--full-reset");
//			command.addArgument("--log");
//			command.addArgument(RESULTS_DIR+"\\appiumLogs_"+Id+".txt");
//			
//			//Execute command line arguments to start appium server.
//			
//			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
//			DefaultExecutor executor = new DefaultExecutor();
//			try 
//			{
//				executor.setExitValue(1);
//				//int status = executor.execute(command);
//				executor.execute(command,resultHandler);
//				
//				 // Wait for 15 minutes so that appium server can start properly before going for test execution.
//				// Increase this time If face any error. 
//				
//				Thread.sleep(10000);
//				//return status;
//				
//			}
//			catch (Exception e)
//			{
//				tearDown();
//				extent.log(LogStatus.FATAL, "<span class='label failure'>failure</span>Unable to bring up the Appium Server!! Exception "+e+"thrown");
//				throw new  Exception("Unable to bring up the Appium Server!!", e);
//			}
//		}
//		
//		
//		
//		
//		public void setCapabilities(BaseTest base)
//		{
//				System.out.println("Setting Capaibilities");
//				/*capabilities.setCapability(MobileCapabilityType.APP_WAIT_ACTIVITY, commonUtils.SETUP_WAIT_TIME);
//				capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, commonUtils.SETUP_WAIT_TIME);
//				capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, commonUtils.SETUP_WAIT_TIME);
//				capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, commonUtils.SETUP_WAIT_TIME);*/
//			
//				capabilities.setCapability(MobileCapabilityType.APP, this.APPLICATION_NAME);
//				capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, this.APP_ACTIVITY);
//				capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, this.APP_PKG);
//				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,this.PLATFORM_NAME);
//				capabilities.setCapability("device",this.DEVICE);
//				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,this.DEVICE_NAME);
//				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,this.PLATFORM_VERSION);
//				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,this.AUTOMATION_NAME);	
//				System.out.println("Setting Capabilities Complete");	
//			
//		}
//		
//		public  AndroidDriver<WebElement> getDriver() throws Exception
//		{
//			
//			extent.log(LogStatus.INFO, "<span class='label info'>info</span> Initializing Appium driver");
//			setCapabilities(this);
//			SERVER_URL = new URL("http://"+APPIUM_HOST +":"+APPIUM_PORT + "/wd/hub");		
//			try
//			{
//				adriver = new AndroidDriver<WebElement>(SERVER_URL, capabilities);
//			}
//			catch (Exception e)
//			{
//				//System.out.println("getDriver : Appium Port is "+this.APPIUM_PORT + " testName = "+this.TEST_MODE);
//				tearDown();
//				extent.log(LogStatus.FATAL, "<span class='label failure'>failure</span> Server URL or capabilities incorrect!! Please check again!! <pre>"+e+"</pre>");
//				e.printStackTrace();
//				throw new Exception("Server URL or capabilities maybe incorrect!! Please check again. Server URL used is "+SERVER_URL+"Exception seen is ",e);
//			}
//						
//			adriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		
//			return adriver;
//		}
//		
//		// Stop the appium serevr
//				public boolean stopAppiumServer() throws IOException, InterruptedException
//				{
//					//System.out.println("Appium Port is "+this.APPIUM_PORT + " testName = "+this.TEST_MODE);
//					String command = "cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in" 
//					                         + " (`netstat -nao ^| findstr /R /C:\"" + this.APPIUM_PORT + "\"`) do (FOR /F \"usebackq\" %b in"
//					                         + " (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)";
//					
//					Process p;
//					try {
//						 	p = Runtime.getRuntime().exec(command);
//						 	Thread.sleep(5000);
//						 	//System.out.println("Exit Value is "+p.exitValue());
//						 	if (p.exitValue() !=-1)
//						 	{
//						 		return (true);
//						 	}
//						 	else  return (false);
//						}
//					catch(IOException e)
//					{
//						extent.log(LogStatus.FAIL, "<span class='label failure'>failure</span> Appium Server failed to stop.!!");
//						throw new IOException("Appium Server running on port "+APPIUM_PORT+" has failed to stop. Please stop it manually. Exception thrown is as follows: ",e );				
//					}
//					
//					
//				}
//				
//		
//		@AfterClass
//		public void tearDown() throws IOException, InterruptedException
//		{
//			if (adriver!=null)
//				adriver.quit();
//			Boolean status = stopAppiumServer();
//			if (status)
//			{
//				System.out.println("TearDown : Appium Server Stop on Port "+APPIUM_PORT+"successfull. Driver also shutdown sucessfully.");
//				extent.log(LogStatus.INFO, "<span class='label info'>info</span> Appium Server Shutdown successfull");
//			}	
//			
//		}
//		 
//			
//		@Override
//		public void onTestFailure(ITestResult result) 
//		{
//			try
//			 {
//				// System.out.println("Inside Test Failure");
//				 tearDown() ;
//			 } 
//			 catch (Exception e) 
//			 {
//				e.printStackTrace();
//			 }
//		}
//		
//		@Override
//		public void onConfigurationFailure(ITestResult result) 
//		{
//			try
//			 {
//				
//				// System.out.println("Inside Configuration Failure");
//				 tearDown() ;
//			 } 
//			 catch (Exception e) 
//			 {
//				e.printStackTrace();
//			 }
//		}
//}
//
