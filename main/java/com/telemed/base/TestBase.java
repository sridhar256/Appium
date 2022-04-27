package com.telemed.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.telemed.util.TestUtil;
import com.telemed.util.WebEventListener;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public static Properties prop;
	public AndroidDriver driver;
	
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\sridhar.j\\eclipse-workspace\\Appium\\TelemedMaven\\src\\main\\java\\com\\telemed\\config\\config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() throws InterruptedException {
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
			
	}
}
