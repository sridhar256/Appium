package com.telemed.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemed.base.TestBase;
import com.telemed.util.TestUtil;

public class ChangePasswordPage extends TestBase {
	
	@FindBy(xpath = "//h3[contains(text(),'Change Password')]")
	WebElement changePasswordLabel;
	
	public String verifyChangePasswordTxt() {
		return changePasswordLabel.getText();
	}
	
	@FindBy(xpath="//input[@formcontrolname='oldPassword']")
	WebElement oldPasswordTxt;

	public void clearOldPassword() {
		oldPasswordTxt.clear();
	}

	public void enterOldPassword(String OldPassword) {
		oldPasswordTxt.sendKeys(OldPassword);
	}
	
	public boolean verifyoldPassword(){
		return oldPasswordTxt.isDisplayed();
	}
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement passwordTxt;

	public void clearPassword() {
		passwordTxt.clear();
	}

	public void enterPassword(String Password) {
		passwordTxt.sendKeys(Password);
	}
	
	public boolean verifyPassword(){
		return passwordTxt.isDisplayed();
	}

	@FindBy(xpath = "//input[@formcontrolname='confirmPassword']")
	WebElement confirmPasswordTxt;

	public void clearConfirmPassword() {
		confirmPasswordTxt.clear();
	}

	public void enterConfirmPassword(String ConfirmPassword) {
		confirmPasswordTxt.sendKeys(ConfirmPassword);
	}
	
	public boolean verifyConfirmPassword(){
		return confirmPasswordTxt.isDisplayed();
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement submitbtn;

	public void clickSubmitBtn() {
		submitbtn.click();
	}

	public boolean verifySubmitBtn(){
		return submitbtn.isDisplayed();
	}

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement cancelbtn;

	public void clickCancelBtn() {
		cancelbtn.click();
	}

	public boolean verifyCancelBtn(){
		return cancelbtn.isDisplayed();
	}
	
	
	@FindBy(xpath = "//mat-dialog-container[@id='mat-dialog-0']/app-information/mat-card/mat-card-actions/button")
	WebElement okbtn;
	
	public void clickOnOkbtn() {
		okbtn.click();
	}
	
	public boolean verifyokBtn() {
		return okbtn.isDisplayed();
	}
	
	public ChangePasswordPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
}
