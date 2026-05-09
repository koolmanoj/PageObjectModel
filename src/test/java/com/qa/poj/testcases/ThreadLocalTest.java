package com.qa.poj.testcases;

import org.openqa.selenium.WebDriver;

public class ThreadLocalTest {
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
	
	public WebDriver getDriver() {
		return dr.get();
	}
	public void setDriver(WebDriver driver) {
		dr.set(driver);;
	}
	
	public void unload() {
		dr.remove();
	}

}
