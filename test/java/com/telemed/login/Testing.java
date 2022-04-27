package com.telemed.login;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.commonmethods.CommonMethods;
import com.telemed.ExtentReportListener.ExtentReportManager;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class Testing extends ExtentReportManager {

	CommonMethods cm = new CommonMethods();
	HashMap<String, String> tcData;

	@BeforeMethod
	public void setUp() throws Exception {

		tcData = CommonMethods.readDataFromTC("createVisits");
	}

	@Test
	public void loginPageTest() throws Exception {
		System.out.println(tcData.get("Label1"));
		System.out.println(tcData.get("Label5"));
		System.out.println(tcData.get("Label3"));
		System.out.println(tcData.get("Label4"));
		System.out.println(tcData.get("Label14"));
		System.out.println(tcData.get("Label15"));
		System.out.println(tcData.get("Label20"));
		System.out.println(tcData.get("Label19"));
	}


	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
