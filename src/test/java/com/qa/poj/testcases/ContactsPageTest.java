package com.qa.poj.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.poj.base.TestBase;
import com.qa.poj.pages.ContactsPage;
import com.qa.poj.pages.HomePage;
import com.qa.poj.pages.LoginPage;
import com.qa.poj.utils.TestUtils;

public class ContactsPageTest extends TestBase {
	
	TestUtils testUtils;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabelTest() throws InterruptedException {
		Assert.assertTrue(contactsPage.verifyContactsLable());
	}

	
	@Test(priority=2) 
	public void selectContactsByNameTest() { 
		contactsPage.selectContactsByName("Manoj Singh"); 
		
	}
	
	@Test(priority=3) 
	public void selectMultipleContactsByNameTest() { 
		contactsPage.selectContactsByName("Manoj Singh");
	    contactsPage.selectContactsByName("Himanshu Sharma"); 
	    
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = TestUtils.getTestData(prop.getProperty("SHEET_NAME"));
		return data;
	}
	
	@Test(priority=4, dataProvider="getTestData")
	public void validateCreateNewContacts(String ftName, String ltName, String company, String category) {
		contactsPage.clickOnNewContacts();
		//contactsPage.createNewContacts("Ram", "Kumar", "Google", "Lead");
		contactsPage.createNewContacts(ftName, ltName, company, category);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
