package com.telemed.createvisits;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import io.appium.java_client.remote.MobileCapabilityType;



public class RescheduleVisitPatient extends ExtentReportManager {

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

		tcData = CommonMethods.readDataFromTC("RescheduleVisitPatient");
	}

	@Test
	public void loginPageTest() throws InterruptedException {

		extent = ExtentReportManager.getReports();

		WebElement email = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sUser"));
		email.sendKeys(tcData.get("Label1"));

		logger =extent.createTest("RescheduleVisitPatient_TC_RVP_02"); 
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_02): Validate Email textbox in login page.",ExtentColor.BLUE));

		if (email.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'sreedhar.jasti@commerztech.biz' in email field in login page.",ExtentColor.GREEN));

		} else { 
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'sreedhar.jasti@commerztech.biz' in email field in login page.",ExtentColor.RED)); }

		
		
		WebElement password = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sPass"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_03): Validate Password textbox in login page.",ExtentColor.BLUE));	

		if (password.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'demo123' in password field in login page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'demo123' in password field in login page.",ExtentColor.RED));  
		}

		WebElement login = driver.findElement(By.id("com.caduceususa.telemed2dev:id/login"));

		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_04): Verify LOG IN button in login page.",ExtentColor.BLUE));	

		if (login.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'LOG IN' button in login page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'LOG IN' button in login page.",ExtentColor.RED));  
		}

		login.click();
		Thread.sleep(10000);	

		
		WebElement rescheduleIcon = driver.findElement(By.xpath("//*/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.ImageView"));
		
		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_05): Verify Reschedule Visit functionality for patient in dashboard page.",ExtentColor.BLUE));	

		if (rescheduleIcon.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Reschedule' icon in dashboard page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Reschedule' icon in dashboard page.",ExtentColor.RED));  
		}
		
		rescheduleIcon.click();
		Thread.sleep(2000);
		
		WebElement cancelReschedule = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesCancel"));
		
		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_06");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_06): Verify Cancel button functionality in Reschedule Telemed Visit pop up.",ExtentColor.BLUE));	

		if (cancelReschedule.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Cancel' button in Reschedule Telemed Visit pop up.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Cancel' button in Reschedule Telemed Visit pop up.",ExtentColor.RED));  
		}
		
		cancelReschedule.click();
		Thread.sleep(2000);
		
		WebElement rescheduleIconAgain = driver.findElement(By.xpath("//*/android.widget.LinearLayout[8]/android.widget.LinearLayout[2]/android.widget.ImageView"));
		rescheduleIconAgain.click();
		Thread.sleep(2000);
		
		WebElement rescheduleTo = driver.findElement(By.id("com.caduceususa.telemed2dev:id/txt_pop_scheduleto"));
		
		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_07");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_07): Verify Save button functionality in Reschedule Telemed Visit pop up.",ExtentColor.BLUE));	

		rescheduleTo.click();

		String rescheduleToValue = tcData.get("Label14");
		WebElement rescheduleToDate = driver.findElement(By.xpath("//*[@content-desc='30 April 2022']"));
		
		rescheduleToDate.click();
		Thread.sleep(1000);
		
		WebElement rescheduleToDateOk = driver.findElement(By.xpath("//*[@text='OK']"));
		rescheduleToDateOk.click();
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '30-Apr-22' in 'Reschedule To' in Reschedule Telemed Visit pop up.",ExtentColor.GREEN));  

		Thread.sleep(1000);
		
		WebElement saveRescheduleToDate = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesOk"));
		
		if (saveRescheduleToDate.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Save' button in Reschedule Telemed Visit pop up.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Save' button in Reschedule Telemed Visit pop up.",ExtentColor.RED));  
		}
		
		saveRescheduleToDate.click();
		Thread.sleep(1000);
		
		WebElement dashboardMenu = driver.findElement(By.id("com.caduceususa.telemed2dev:id/iv_menu"));
		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_08");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_08): Verify Dashboard Menu in Dashboard page.",ExtentColor.BLUE));	

		if (dashboardMenu.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Menu Items' in Dashboard page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Menu Items' in Dashboard page.",ExtentColor.RED));  
		}

		dashboardMenu.click();

		WebElement signOut = driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Out']"));
		logger = extent.createTest("RescheduleVisitPatient_TC_RVP_09");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(RescheduleVisitPatient_TC_RVP_09): Verify Sign Out option in Menu Items.",ExtentColor.BLUE));	

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
		// driver.quit();
	}
}
