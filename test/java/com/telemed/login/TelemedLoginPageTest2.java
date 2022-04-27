package com.telemed.login;

import static org.testng.Assert.assertFalse;

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



public class TelemedLoginPageTest2 extends ExtentReportManager {

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

		tcData = CommonMethods.readDataFromTC("loginPage");
	}

	@Test
	public void loginPageTest() throws InterruptedException {

		extent = ExtentReportManager.getReports();

		WebElement email = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sUser"));
		email.sendKeys(tcData.get("Label1"));

		WebElement password = driver.findElement(By.id("com.caduceususa.telemed2dev:id/sPass"));
		password.sendKeys(tcData.get("Label2"));

		WebElement login = driver.findElement(By.id("com.caduceususa.telemed2dev:id/login"));
		login.click();

		Thread.sleep(20000);

		//WebElement signOut = driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Out']"));
		//signOut.click();

		//List<WebElement> list = driver.findElements(By.id("com.caduceususa.telemed2dev:id/PatientNameTextView"));
		//System.out.println(list.size());		

		List<WebElement> firstNameElements = driver.findElements(By.id("com.caduceususa.telemed2dev:id/PatientNameTextView"));
		List<WebElement> vistCreationDates = driver.findElements(By.id("com.caduceususa.telemed2dev:id/DateOfServiceTextView")); 
		List<WebElement> branchNames = driver.findElements(By.id("com.caduceususa.telemed2dev:id/CompanyNameTextView"));

		for(WebElement firstNameElement: firstNameElements){
			for(WebElement vistCreationDate: vistCreationDates){
				for(WebElement branchName: branchNames){
					if (firstNameElement.getText().equalsIgnoreCase("Jasti Sreedhar") ||vistCreationDate.getText().equalsIgnoreCase("04/18/2022") || branchName.getText().equalsIgnoreCase("Test Demo, INC - Test Demo Branch1")) {
						System.out.println("Created Visit exists in Dashboard page :  " +firstNameElement.getText()+vistCreationDate.getText());
					}
				}
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
