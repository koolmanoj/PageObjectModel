package com.qa.poj.testcases;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBusChallenge {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		/*
		 * Date date = new Date(); System.out.println(date.setMonth(0));
		 */
		
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal.mo);
		
		List<String> list = getHolidays("March 2024");

	}
	
	public static List getHolidays(String month) {
		
		driver.get("www.google.com");
		
		driver.findElement(By.cssSelector(".dateText")).click();
		
		String mon = "//div[contains(text(),'Mar')]";
		driver.findElement(By.xpath(mon)).isDisplayed();
		
		String hol =	"//div[contains(text(),'Mar')]/div";
		String holiday = driver.findElement(By.xpath(hol)).getText();
		
		for(int i=0; i<4; i++) {
		
		
		
		//span[@class='DayTilesWrapper__SpanContainer-sc-19pz9i8-0 hQhlTG']/div/span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 fgdqFw']
		for(int j=1; j<=4; j++) {
		String sat = "(//span[@class='DayTilesWrapper__SpanContainer-sc-19pz9i8-0 hQhlTG']/div[6]/span[not(contains(@class,'DayTiles__CalendarDaysSpan-sc-1xum02u-1 hVMWpe')) and not(contains(@class,'DayTiles__CalendarDaysSpan-sc-1xum02u-1 gigHYE'))])["+j+"]";
		String Saturday = driver.findElement(By.xpath(sat)).getText();
		System.out.println(Saturday);
		
		String sun = "(//span[@class='DayTilesWrapper__SpanContainer-sc-19pz9i8-0 hQhlTG']/div[7]/span[not(contains(@class,'DayTiles__CalendarDaysSpan-sc-1xum02u-1 hVMWpe')) and not(contains(@class,'DayTiles__CalendarDaysSpan-sc-1xum02u-1 gigHYE'))])["+j+"]";
		String Sunday = driver.findElement(By.xpath(sun)).getText();
		System.out.println(Sunday);
		}
		
		driver.findElement(By.cssSelector("#Layer_1")).click();
		
		
		System.out.println(holiday);
		
		
		
		}
		
		//span[@class='DayTilesWrapper__SpanContainer-sc-19pz9i8-0 hQhlTG']/div/span[not(contains(@class,'DayTiles__CalendarDaysSpan-sc-1xum02u-1 gigHYE'))]
		
		
		return null;
	}

}
