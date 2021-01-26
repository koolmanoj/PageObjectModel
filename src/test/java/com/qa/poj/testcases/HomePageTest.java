package com.qa.poj.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.poj.base.TestBase;
import com.qa.poj.pages.ContactsPage;
import com.qa.poj.pages.DealsPage;
import com.qa.poj.pages.HomePage;
import com.qa.poj.pages.LoginPage;
import com.qa.poj.pages.TasksPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent of each other
	//before each test case -- launch the browser and login
	//execute test cases
	//after each test case -- close the browser
	@BeforeMethod
	public void setUp() {
		intialization();
		tasksPage = new TasksPage();
		dealsPage = new DealsPage();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page tite not matched"); //On test case failure 'Home Page title not matched' will be printed
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void verifydealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifytasksLinkTest() {
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
