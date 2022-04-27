package com.telemed.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemed.base.TestBase;
import com.telemed.util.TestUtil;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends TestBase {
	

	@FindBy(id="com.caduceususa.telemed2dev:id/sUser")
	WebElement emailTxt;

	public void clearEmail() {
		emailTxt.clear();
	}

	public void enterEmail(String email) {
		emailTxt.sendKeys(email);
	}
	
	public boolean verifyEmail(){
		return emailTxt.isDisplayed();
	}

	@FindBy(id="com.caduceususa.telemed2dev:id/sPass")
	WebElement passwordTxt;

	public void clearPassword() {
		passwordTxt.clear();
	}

	public void enterPassword(String pwd) {
		passwordTxt.sendKeys(pwd);
	}


	@FindBy(id="com.caduceususa.telemed2dev:id/login")
	WebElement signInBtn;

	public void clickLoginBtn() {
		signInBtn.click();
	}


	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public HomePage loginToSite(String email, String pwd) throws Exception {

		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(pwd);
		signInBtn.click();

		return new HomePage();	
	}
}
