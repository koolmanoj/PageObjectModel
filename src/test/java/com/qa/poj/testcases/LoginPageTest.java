package com.qa.poj.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.poj.base.TestBase;
import com.qa.poj.pages.HomePage;
import com.qa.poj.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public static Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
  
  @BeforeMethod
  public void setUp() {
	intialization();
	loginPage = new LoginPage();
	  }	
	
  @Test(priority=1)
  public void loginPageTitletest() {
	  String title = loginPage.validatePageTitle();
	  Assert.assertEquals(title, "Cogmento CRM1");
	  
	  log.info("************************* loginPageTitletest Passed********************************");
  }
  
  @Test(priority=2)
  public void crmImgLogoTest() {
	  boolean flag = loginPage.validateCRMImage();
	  Assert.assertTrue(false);
	  
	  log.info("************************* crmImgLogoTest Passed********************************");
  }
  
  @Test(priority=3)
  public void loginTest() {
	  homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  
	  log.info("************************* loginTest Passed********************************");  
	  
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
 

}
