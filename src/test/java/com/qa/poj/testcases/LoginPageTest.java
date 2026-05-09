package com.qa.poj.testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.poj.base.TestBase;
import com.qa.poj.pages.HomePage;
import com.qa.poj.pages.LoginPage;
import com.qa.poj.utils.RetryAnalyzer;

@Listeners(com.qa.poj.utils.WebListener.class)
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
	 String text2="Apple iPhone 14 (128 GB)";
	List<WebElement> wb =  driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 14 (128 GB)')]"));
	Iterator<WebElement> it = wb.iterator();
	//driver.manage.Timeouts.implicitlyWait(Duration.ofSeconds(30));
	while(it.hasNext()) {
		String text = it.next().getText().toString();
		System.out.println("Testing" +text);
		
		if(!text.isEmpty()) {
			List<WebElement> d=driver.findElements(By.xpath("(//span[contains(text(),'"+text+"')]//preceding::h2//parent::div//following-sibling::div)[4]//span[@class='a-price']//span"));
			Iterator<WebElement> i =d.iterator();
			while(i.hasNext()) {
				String text1=i.next().getText().toString();
				System.out.println("text111" +text1);
			}
		}
		
	}
	  }
  
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
}