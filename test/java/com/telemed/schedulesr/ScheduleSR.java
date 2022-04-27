package com.telemed.schedulesr;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.commonmethods.CommonMethods;
import com.telemed.ExtentReportListener.ExtentReportManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;



public class ScheduleSR extends ExtentReportManager {

	AndroidDriver driver;
	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {

		File f = new File("C:\\APKFiles\\dev_4.6.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel5API30Jasti");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"5000");
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		cap.setCapability(MobileCapabilityType.FULL_RESET, "false");

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		cap.setCapability("appPackage", "com.caduceususa.telemed2dev");
		cap.setCapability("appActivity", "com.caduceususa.telemed2.Login");

		tcData = CommonMethods.readDataFromTC("ScheduleSR");
	}

	@Test (priority=1)
	public void loginPageTest() throws InterruptedException, AWTException {

		extent = ExtentReportManager.getReports();

		WebElement email = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sUser"));
		email.sendKeys(tcData.get("Label1"));

		logger =extent.createTest("ScheduledSR_TC_SSR_02"); 
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_02): Validate Email textbox in login page.",ExtentColor.BLUE));

		if (email.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'sreedhar.jasti@commerztech.biz' in email field in login page.",ExtentColor.GREEN));

		} else { 
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'sreedhar.jasti@commerztech.biz' in email field in login page.",ExtentColor.RED)); }



		WebElement password = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sPass"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("ScheduledSR_TC_SSR_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_03): Validate Password textbox in login page.",ExtentColor.BLUE));	

		if (password.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'demo123' in password field in login page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'demo123' in password field in login page.",ExtentColor.RED));  
		}

		WebElement login = driver.findElement(By.id("com.caduceususa.telemed2dev:id/login"));

		logger = extent.createTest("ScheduledSR_TC_SSR_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_04): Verify LOG IN button in login page.",ExtentColor.BLUE));	

		if (login.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'LOG IN' button in login page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'LOG IN' button in login page.",ExtentColor.RED));  
		}

		login.click();
		Thread.sleep(10000);	

		WebElement dashboardMenu = driver.findElement(By.id("com.caduceususa.telemed2dev:id/iv_menu"));
		logger = extent.createTest("ScheduledSR_TC_SSR_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_05): Verify Dashboard Menu in Dashboard page.",ExtentColor.BLUE));	

		if (dashboardMenu.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Menu Items' in Dashboard page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Menu Items' in Dashboard page.",ExtentColor.RED));  
		}

		dashboardMenu.click();
		Thread.sleep(2000);


		WebElement scheduledSR = driver.findElement(By.xpath("//android.widget.TextView[@text='Scheduled SR']"));
		logger = extent.createTest("ScheduledSR_TC_SSR_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_06): Verify Scheduled SR functionality in Menu Items.",ExtentColor.BLUE));	

		if (scheduledSR.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Scheduled SR' option in Menu Items.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Scheduled SR' option in Menu Items.",ExtentColor.RED));  
		}

		scheduledSR.click();
		Thread.sleep(2000);


		WebElement searchPatientCriteria = driver.findElement(By.xpath("//android.widget.EditText[@text='Search Patient']")); 
		logger =extent.createTest("ScheduledSR_TC_SSR_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_08): Verify Search Patient functionality for valid patient data in Scheduled SR page.",ExtentColor.BLUE));

		if (searchPatientCriteria.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '2022 SRcreate' in search patient field in Scheduled SR page.",ExtentColor.GREEN));

		} else { 
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input '2022 SRcreate' in search patient field in Scheduled SR page.",ExtentColor.RED)); }

		searchPatientCriteria.click();
		driver.getKeyboard().pressKey(tcData.get("Label3"));
		
		
		WebElement noPatientsOK = driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")); 
		
		if (noPatientsOK.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'OK' button in Info pop up(No patient(s) found) in Scheduled SR page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'OK' button in Info pop up(No patient(s) found) in Scheduled SR page.",ExtentColor.RED));  
		}
		
		noPatientsOK.click();
		Thread.sleep(2000);
		
		searchPatientCriteria.clear();
		Thread.sleep(1500);
		driver.getKeyboard().pressKey(tcData.get("Label4"));

		
		WebElement filteredSearchPatient = driver.findElement(By.xpath("//android.widget.TextView[@text='2104 SRcreate']")); 
		
		logger =extent.createTest("ScheduledSR_TC_SSR_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_08): Verify Search Patient functionality for valid patient data in Scheduled SR page.",ExtentColor.BLUE));

		if (filteredSearchPatient.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click '2104 SRcreate' patient from the filtered search criteria in Scheduled SR page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click '2104 SRcreate' patient from the filtered search criteria in Scheduled SR page.",ExtentColor.RED));  
		}
		
		filteredSearchPatient.click();
		Thread.sleep(2000);
		
	
		WebElement searchPatientDetails = driver.findElement(By.xpath("//android.widget.TextView[@text='2104 SRcreate']")); 
		
		logger =extent.createTest("ScheduledSR_TC_SSR_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_09): Verify click on Patient functionality in Scheduled SR page.",ExtentColor.BLUE));
		
		if (searchPatientDetails.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click '2104 SRcreate' patient in Scheduled SR page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click '2104 SRcreate' patient in Scheduled SR page.",ExtentColor.RED));  
		}
		
		searchPatientDetails.click();
		Thread.sleep(2000);


		WebElement providerdropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tv"));
		providerdropdownOpen.click();

		WebElement demoMA2 = driver.findElement(By.xpath("//*[@text='demo MA2']"));

		logger = extent.createTest("ScheduledSR_TC_SSR_10");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_10): Verify Select a MA Provider Dropdown in 'Select a MA Provider' page.",ExtentColor.BLUE));	

		if (demoMA2.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'demo MA2' option in 'Select a MA Provider' drop down in 'Select a MA Provider' page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'demo MA2' option in 'Select a MA Provider' drop down in 'Select a MA Provider' page.",ExtentColor.RED));  
		}

		demoMA2.click();
		Thread.sleep(2000);

		WebElement OkButton = driver.findElement(By.id("com.caduceususa.telemed2dev:id/btn_continue"));

		logger = extent.createTest("ScheduledSR_TC_SSR_11");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_11): Validate Ok button functionality in 'Select a MA Provider' page.",ExtentColor.BLUE));	

		if (OkButton.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'OK' button in 'Select a MA Provider' page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'OK' button in 'Select a MA Provider' page.",ExtentColor.RED));  
		}

		OkButton.click();
		Thread.sleep(5000);

		WebElement endCall = driver.findElement(By.id("com.caduceususa.telemed2dev:id/bnEndCall"));

		logger = extent.createTest("ScheduledSR_TC_SSR_12");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_12): Verify End Call functionality.",ExtentColor.BLUE));	

		if (endCall.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'End Call' button.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'End Call' button.",ExtentColor.RED));  
		}

		endCall.click();
		Thread.sleep(2000);

		WebElement cancelVisit = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesOk"));

		logger = extent.createTest("ScheduledSR_TC_SSR_13");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_13): Verify CANCEL button functionality in INFO pop up.",ExtentColor.BLUE));	

		if (cancelVisit.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'CANCEL' button in INFO pop up.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'CANCEL' button in INFO pop up.",ExtentColor.RED));  
		}

		cancelVisit.click();
		Thread.sleep(2000);
		
		/*
		 * WebElement deleteVisit =
		 * driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesCancel"));
		 * 
		 * logger = extent.createTest("ScheduledSR_TC_SSR_14");
		 * logger.log(Status.INFO,MarkupHelper.
		 * createLabel("TestCase(ScheduledSR_TC_SSR_14): Verify DELETE button functionality in INFO pop up."
		 * ,ExtentColor.BLUE));
		 * 
		 * if (deleteVisit.isDisplayed()) { logger.log(Status.PASS,MarkupHelper.
		 * createLabel("User is able to click 'DELETE' button in INFO pop up."
		 * ,ExtentColor.GREEN));
		 * 
		 * } else { logger.log(Status.FAIL,MarkupHelper.
		 * createLabel("User is unable to click 'DELETE' button in INFO pop up."
		 * ,ExtentColor.RED)); }
		 * 
		 * deleteVisit.click(); 
		 * Thread.sleep(5000);
		 */
		
		WebElement dashboardMenuAgain = driver.findElement(By.id("com.caduceususa.telemed2dev:id/iv_menu"));
		logger = extent.createTest("ScheduledSR_TC_SSR_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_05): Verify Dashboard Menu in Dashboard page.",ExtentColor.BLUE));	

		if (dashboardMenuAgain.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Menu Items' in Dashboard page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Menu Items' in Dashboard page.",ExtentColor.RED));  
		}

		dashboardMenuAgain.click();
		Thread.sleep(2000);

		WebElement signOut = driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Out']"));
		logger = extent.createTest("ScheduledSR_TC_SSR_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(ScheduledSR_TC_SSR_15): Verify Sign Out option in Menu Items.",ExtentColor.BLUE));	

		if (signOut.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Sign Out' option in Menu Items.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Sign Out' option in Menu Items.",ExtentColor.RED));  
		}

		signOut.click();
		Thread.sleep(3000);
	} 



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
