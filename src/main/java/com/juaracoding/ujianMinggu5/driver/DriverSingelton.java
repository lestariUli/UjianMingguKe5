package com.juaracoding.ujianMinggu5.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class DriverSingelton {
	private static DriverSingelton instance = null;
	private static WebDriver driver;
	
	//constructor
	public DriverSingelton(String driver) {
		instantiate(driver);
	}

	private WebDriver instantiate(String strategy) {
		// TODO Auto-generated method stub
		DriverStrategy driverStrategy = DriverStrategyImplement.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
	//memanggil driver singleton ketika belum di jalankan (manggil constructor)
	public static DriverSingelton getInstance(String driver) {
		if(instance == null) {
			instance = new DriverSingelton(driver);
		}
		return instance;
	}
	//manggil si driver
	public static WebDriver getDriver() {
		return driver;
	}

}
