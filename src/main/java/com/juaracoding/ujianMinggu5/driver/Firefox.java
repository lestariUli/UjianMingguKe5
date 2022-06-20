package com.juaracoding.ujianMinggu5.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	

}
