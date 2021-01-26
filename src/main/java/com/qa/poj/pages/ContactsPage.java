package com.qa.poj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.poj.base.TestBase;

public class ContactsPage extends TestBase{
	
	JavascriptExecutor ex = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement contactsLable;
	
	@FindBy(xpath="//a[@href='/contacts/new']/button")
	WebElement newContacts;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="category")
	WebElement categoryDropDown;
	
	@FindBy(xpath="//div[@name='company']/input")
	WebElement companyName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement contactsSaveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public boolean verifyContactsLable() throws InterruptedException {
		return contactsLable.isDisplayed();
		//return driver.findElement(By.xpath("//div[contains(@class,'ui header item mb5 light-black')]")).isDisplayed();
		
	}
	
	public void selectContactsByName(String name) {
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//preceding::td[1]//div[@class='ui fitted read-only checkbox']//input"));
		ex.executeScript("arguments[0].click();", element);
	}
	
	public void clickOnNewContacts() {
		//driver.findElement(By.xpath("//a[@href='/contacts/new']/button")).click();
		newContacts.click();
	}
	
	public void createNewContacts(String ftName, String ltName, String company, String category) {
		//driver.findElement(By.name("first_name")).sendKeys(ftName);
		//driver.findElement(By.name("last_name")).sendKeys(ltName);
		//driver.findElement(By.xpath("//div[@name='company']/input")).sendKeys(company);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(company);
		categoryDropDown.click();
		WebElement element = driver.findElement(By.xpath("//div[@class='visible menu transition']//span[contains(text(),'"+category+"')]"));
		ex.executeScript("arguments[0].click();", element);
		//driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
		contactsSaveBtn.click();
	}

}
