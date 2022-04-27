package com.telemed.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemed.base.TestBase;
import com.telemed.util.TestUtil;

public class ForgotPasswordPage extends TestBase {

	@FindBy(name="email")
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

	@FindBy(xpath="//mat-icon[contains(text(),'vpn_key')]")
	WebElement forgotPasswordBtn;

	public void clickforgotPasswordBtn() {
		forgotPasswordBtn.click();
	}
	
	public boolean verifyforgotPasswordBtn() {
		return forgotPasswordBtn.isDisplayed();
	}
	
	@FindBy(name="password")
	WebElement passwordTxt;

	public void clearPassword() {
		passwordTxt.clear();
	}

	public void enterPassword(String pwd) {
		passwordTxt.sendKeys(pwd);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInBtn;

	public void clickLoginBtn() {
		signInBtn.click();
	}

	public ForgotPasswordPage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	
}
