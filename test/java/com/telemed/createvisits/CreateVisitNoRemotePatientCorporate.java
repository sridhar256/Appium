package com.telemed.createvisits;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class CreateVisitNoRemotePatientCorporate extends ExtentReportManager {

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
		cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		cap.setCapability("appPackage", "com.caduceususa.telemed2dev");
		cap.setCapability("appActivity", "com.caduceususa.telemed2.Login");

		tcData = CommonMethods.readDataFromTC("CreateVisitNoRemotePatientCorporate");
	}

	@Test
	public void loginPageTest() throws InterruptedException {

		extent = ExtentReportManager.getReports();

		WebElement email = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sUser"));
		email.sendKeys(tcData.get("Label1"));

		logger =extent.createTest("CreateVisitPage_TC_CVNRPC_02"); 
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_02): Validate 'Email' textbox in login page.",ExtentColor.BLUE));

		if (email.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'demosm06@demo.com' in email field in login page.",ExtentColor.GREEN));

		} else { 
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'demosm06@demo.com' in email field in login page.",ExtentColor.RED)); }

		WebElement password = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sPass"));
		password.sendKeys(tcData.get("Label2"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_03");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_03): Validate 'Password' textbox in login page.",ExtentColor.BLUE));	

		if (password.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'demo123' in password field in login page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'demo123' in password field in login page.",ExtentColor.RED));  
		}

		WebElement login = driver.findElement(By.id("com.caduceususa.telemed2dev:id/login"));
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_04");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_04): Verify LOG IN button in login page.",ExtentColor.BLUE));	

		if (login.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'LOG IN' button in login page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'LOG IN' button in login page.",ExtentColor.RED));  
		}

		login.click();
		Thread.sleep(10000);

		WebElement addUser = driver.findElement(By.id("com.caduceususa.telemed2dev:id/add_user_icon"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_05");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_05): Verify Create Visit Icon in dashboard page.",ExtentColor.BLUE));	
		
		if (addUser.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Create Visit' icon in dashboard page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Create Visit' icon in dashboard page.",ExtentColor.RED));  
		}
		
		addUser.click();
		Thread.sleep(8000);
		
		/*
		 * WebElement cancel =
		 * driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvCancel"));
		 * 
		 * logger = extent.createTest("CreateVisitPage_TC_CVNRPC_13");
		 * logger.log(Status.INFO,MarkupHelper.
		 * createLabel("TestCase(CreateVisitPage_TC_CVNRPC_13): Verify 'Cancel' button in create visit page."
		 * ,ExtentColor.BLUE));
		 * 
		 * if (cancel.isDisplayed()) { logger.log(Status.PASS,MarkupHelper.
		 * createLabel("User is able to click 'Cancel' button in create visit page."
		 * ,ExtentColor.GREEN));
		 * 
		 * } else { logger.log(Status.FAIL,MarkupHelper.
		 * createLabel("User is unable to click 'Cancel' button in create visit page."
		 * ,ExtentColor.RED)); }
		 * 
		 * cancel.click(); Thread.sleep(5000);
		 * 
		 * WebElement addUserAgain =
		 * driver.findElement(By.id("com.caduceususa.telemed2dev:id/add_user_icon"));
		 * addUserAgain.click(); Thread.sleep(8000);
		 */

		WebElement visitTypedropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/spVisitType"));
		visitTypedropdownOpen.click();
		
		Thread.sleep(1500);

		String visitTypedropdownValue = tcData.get("Label3");		
		WebElement corporate = driver.findElement(By.xpath("//*[@text='Corporate']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_14");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_14): Validate 'Visit Type' drop down in create visit page.",ExtentColor.BLUE));	
		
		if (corporate.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Corporate' option in 'Visit Type' drop down options in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'Corporate' option in 'Visit Type' drop down options in create visit page.",ExtentColor.RED));  
		}
		
		corporate.click();
		Thread.sleep(6000);
		
		WebElement purposeOfVisitdropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sppurpose"));
		purposeOfVisitdropdownOpen.click();

		String purposeOfVisitdropdownValue = tcData.get("Label4");		
		WebElement drugAlcoholTest = driver.findElement(By.xpath("//*[@text='Drug/Alcohol test']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_15");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_15): Validate 'Purpose of Visit' Type drop down in create visit page.",ExtentColor.BLUE));	
		
		if (drugAlcoholTest.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Drug/Alcohol test' option in 'Purpose of Visit' drop down in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'Drug/Alcohol test' option in 'Purpose of Visit' drop down in create visit page.",ExtentColor.RED));  
		}
		
		drugAlcoholTest.click();
		Thread.sleep(4000);
		
		WebElement drugTypedropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/spdrugtype"));
		drugTypedropdownOpen.click();

		String drugTypedropdownOpenValue = tcData.get("Label5");
		WebElement random = driver.findElement(By.xpath("//*[@text='Random']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_16");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_16): Validate 'Drug Type' drop down in create visit page.",ExtentColor.BLUE));	
		
		if (random.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Random' option in 'Drug Type' drop down in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'Random' option in 'Drug Type' drop down in create visit page.",ExtentColor.RED));  
		}
		
		random.click();

		WebElement branchdropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/spbranch"));
		branchdropdownOpen.click();

		String branchdropdownValue = tcData.get("Label6");
		WebElement testDemoBranch2 = driver.findElement(By.xpath("//*[@text='Test Demo Branch2']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_17");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_17): Validate 'Branch' drop down in create visit page.",ExtentColor.BLUE));	

		if (testDemoBranch2.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Test Demo Branch2' option in 'Branch' drop down options in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'Test Demo Branch2' option in 'Branch' drop down options in create visit page.",ExtentColor.RED));  
		}
		
		testDemoBranch2.click();
		Thread.sleep(2000);

		WebElement statedropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/spstate"));
		statedropdownOpen.click();

		String statedropdownValue = tcData.get("Label7");
		WebElement alaska = driver.findElement(By.xpath("//*[@text='Alaska']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_18");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_18): Validate 'State' drop down in create visit page.",ExtentColor.BLUE));	

		if (alaska.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'Alaska' option in 'State' drop down options in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'Alaska' option in 'State' drop down options in create visit page.",ExtentColor.RED));  
		}
		
		alaska.click();
		Thread.sleep(1500);

		Dimension dimension = driver.manage().window().getSize();

		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions)driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
		
		Thread.sleep(1000);

		WebElement socialSecurityNumber = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etSecurity_number"));
		socialSecurityNumber.sendKeys(tcData.get("Label8"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_19");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_19): Validate 'Social Security Number' textbox in create visit page.",ExtentColor.BLUE));	

		if (socialSecurityNumber.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '123456789' in 'Social Security Number' field in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input '123456789' in 'Social Security Number' field in create visit page.",ExtentColor.RED));  
		}

		WebElement firstName = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etFirstname"));
		firstName.sendKeys(tcData.get("Label9"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_20");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_20): Validate 'First Name' textbox in create visit page.",ExtentColor.BLUE));	

		if (firstName.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'CreateVisitJasti' in 'First Name' field in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'CreateVisitJasti' in 'First Name' field in create visit page.",ExtentColor.RED));  
		}

		WebElement lastName = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etLastname"));
		lastName.sendKeys(tcData.get("Label10"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_21");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_21): Validate 'Last Name' textbox in create visit page.",ExtentColor.BLUE));	

		if (lastName.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'NoRemotePatientCorporate' in 'Last Name' field in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'NoRemotePatientCorporate' in 'Last Name' field in create visit page.",ExtentColor.RED));  
		}

		WebElement phoneNumber = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etphonenumberNR"));
		phoneNumber.sendKeys(tcData.get("Label11"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_22");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_22): Validate 'Phone Number' textbox in create visit page.",ExtentColor.BLUE));	

		if (phoneNumber.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '9293116684' in 'Phone Number' field in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input '9293116684' in 'Phone Number' field in create visit page.",ExtentColor.RED));  
		}

		// scrollable
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Start New Visit\"));"));
		
		WebElement additionalEmails = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etPatient_ad_email"));
		additionalEmails.sendKeys(tcData.get("Label12"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_23");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_23): Validate 'Additional E-Mail(s)' textbox in create visit page.",ExtentColor.BLUE));	

		if (additionalEmails.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'demo123@gmail.com' in 'Additional E-Mail(s)' field in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'demo123@gmail.com' in 'Additional E-Mail(s)' field in create visit page.",ExtentColor.RED));  
		}

		WebElement patientEmail = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etPatient_email"));
		patientEmail.sendKeys(tcData.get("Label13"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_24");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_24): Validate 'Patient E-mail' textbox in create visit page.",ExtentColor.BLUE));	

		if (patientEmail.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input 'demo1234@gmail.com' in 'Patient E-mail' field in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to input 'demo1234@gmail.com' in 'Patient E-mail' field in create visit page.",ExtentColor.RED));  
		}

		WebElement dateOfBirth = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etDateofbirth"));
		dateOfBirth.click();

		String dateOfBirthDateValue = tcData.get("Label14");
		WebElement dateOfBirthDate = driver.findElement(By.xpath("//*[@content-desc='11 April 2009']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_25");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_25): Validate 'Date of Birth' textbox in create visit page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '11-Apr-09' in 'Date of Birth' field in create visit page.",ExtentColor.GREEN));  

		dateOfBirthDate.click();
		Thread.sleep(1000);

		WebElement dateOfBirthDateOk = driver.findElement(By.xpath("//*[@text='OK']"));
		dateOfBirthDateOk.click();
		Thread.sleep(1000);

		WebElement dateOfDrugTest = driver.findElement(By.id("com.caduceususa.telemed2dev:id/etDateofinjury"));
		dateOfDrugTest.click();

		String dateOfDrugTestValue = tcData.get("Label15");
		WebElement dateOfDrugTestDate = driver.findElement(By.xpath("//*[@content-desc='22 April 2022']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_26");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_26): Validate 'Date of Drug test' textbox in create visit page.",ExtentColor.BLUE));	
		logger.log(Status.PASS,MarkupHelper.createLabel("User is able to input '22-Apr-22' in 'Date of Drug test' field in create visit page.",ExtentColor.GREEN));  
		
		dateOfDrugTestDate.click();
		Thread.sleep(1000);

		WebElement dateOfDrugTestDateOk = driver.findElement(By.xpath("//*[@text='OK']"));
		dateOfDrugTestDateOk.click();
		Thread.sleep(1000);

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Start New Visit\"));"));
		
		WebElement startNewVisit = driver.findElement(By.id("com.caduceususa.telemed2dev:id/bncreatenewvisit"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_29");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_29): Verify 'Start New Visit' button in create visit page.",ExtentColor.BLUE));	

		if (startNewVisit.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Start New Visit' button in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Start New Visit' button in create visit page.",ExtentColor.RED));  
		}
		
		startNewVisit.click();
		
		WebElement noDocumentsInfo = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesCancel"));

		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_30");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_30): Verify 'No' button functionality in Document's info pop up in create visit page.",ExtentColor.BLUE));	

		if (noDocumentsInfo.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'No' button in Document's info pop up in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'No' button in Document's info pop up in create visit page.",ExtentColor.RED));  
		}
		
		noDocumentsInfo.click();
		Thread.sleep(2000);
		
		WebElement startNewVisitAgain = driver.findElement(By.id("com.caduceususa.telemed2dev:id/bncreatenewvisit"));
		startNewVisitAgain.click();
		
		Thread.sleep(2000);
		WebElement yesDocumentsInfo = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesOk"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_31");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_31): Verify 'Start New Visit' button in create visit page.",ExtentColor.BLUE));	

		if (yesDocumentsInfo.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Yes' button in Document's info pop up in create visit page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Yes' button in Document's info pop up in create visit page.",ExtentColor.RED));  
		}
		
		yesDocumentsInfo.click();
		Thread.sleep(2000);

		WebElement providerdropdownOpen = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tv"));
		providerdropdownOpen.click();

		WebElement demoMA2 = driver.findElement(By.xpath("//*[@text='demo MA2']"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_32");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_32): Verify 'Select a Provider' drop down in 'Select a Provider' page.",ExtentColor.BLUE));	

		if (demoMA2.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to select 'demo MA2' option in 'Select a Provider' drop down in 'Select a Provider' page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to select 'demo MA2' option in 'Select a Provider' drop down in 'Select a Provider' page.",ExtentColor.RED));  
		}
		
		demoMA2.click();
		Thread.sleep(2000);

		WebElement OkButton = driver.findElement(By.id("com.caduceususa.telemed2dev:id/btn_continue"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_33");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_33): Verify OK button functionality in 'Select a Provider' page.",ExtentColor.BLUE));	

		if (OkButton.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'OK' button in 'Select a Provider' page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'OK' button in 'Select a Provider' page.",ExtentColor.RED));  
		}
		
		OkButton.click();
		Thread.sleep(5000);

		WebElement endCall = driver.findElement(By.id("com.caduceususa.telemed2dev:id/bnEndCall"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_34");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_34): Verify End Call functionality.",ExtentColor.BLUE));	

		if (endCall.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'End Call' button.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'End Call' button.",ExtentColor.RED));  
		}
		
		endCall.click();
		Thread.sleep(2000);

		WebElement cancelVisit = driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesOk"));
		
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_35");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_35): Verify CANCEL button functionality in INFO pop up.",ExtentColor.BLUE));	

		if (cancelVisit.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'CANCEL' button in INFO pop up.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'CANCEL' button in INFO pop up.",ExtentColor.RED));  
		}
		
		cancelVisit.click();
		Thread.sleep(5000);

		/*
		 * WebElement deleteVisit =
		 * driver.findElement(By.id("com.caduceususa.telemed2dev:id/tvDesCancel"));
		 * 
		 * logger = extent.createTest("CreateVisitPage_TC_CVNRPC_36");
		 * logger.log(Status.INFO,MarkupHelper.
		 * createLabel("TestCase(CreateVisitPage_TC_CVNRPC_36): Verify DELETE button functionality in INFO pop up."
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
		 * deleteVisit.click(); Thread.sleep(5000);
		 */
		
		WebElement dashboardMenu = driver.findElement(By.id("com.caduceususa.telemed2dev:id/iv_menu"));
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_37");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_37): Verify Dashboard Menu in Dashboard page.",ExtentColor.BLUE));	

		if (dashboardMenu.isDisplayed()) { 
			logger.log(Status.PASS,MarkupHelper.createLabel("User is able to click 'Menu Items' in Dashboard page.",ExtentColor.GREEN));  

		} else {
			logger.log(Status.FAIL,MarkupHelper.createLabel("User is unable to click 'Menu Items' in Dashboard page.",ExtentColor.RED));  
		}

		dashboardMenu.click();

		WebElement signOut = driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Out']"));
		logger = extent.createTest("CreateVisitPage_TC_CVNRPC_38");
		logger.log(Status.INFO,MarkupHelper.createLabel("TestCase(CreateVisitPage_TC_CVNRPC_38): Verify Sign Out option in Menu Items.",ExtentColor.BLUE));	

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
