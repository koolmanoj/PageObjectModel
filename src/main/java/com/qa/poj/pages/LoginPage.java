package com.qa.poj.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.poj.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or OR
		@FindBy(name="email")
		@CacheLookup
		WebElement userName;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement password;
		
		@FindBy(xpath="//div[contains(text(),'Login')]")
		@CacheLookup
		WebElement loginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//div[contains(text(),'Classic FreeCRM or CRMPro User?  Login to ')]")
		WebElement crmLogo;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);	
		}
		
		public String validatePageTitle() {
			return driver.getTitle();
		}
		
		public boolean validateCRMImage() {
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) {
			userName.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();
		}

}
