package com.juaracoding.ujianminggu5;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujianMinggu5.config.AutomationConfig;
import com.juaracoding.ujianMinggu5.driver.DriverSingelton;
import com.juaracoding.ujianMinggu5.pages.LoginPages;
import com.juaracoding.ujianMinggu5.utils.ConfigurationProperties;
import com.juaracoding.ujianMinggu5.utils.Constant;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationConfig.class)
public class StepDefenition {
	private static WebDriver driver;
	private LoginPages loginPages;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setup() {
		DriverSingelton.getInstance(configurationProperties.getBrowser());
		loginPages = new LoginPages();
	}
	@Given("User mengakses url")
	public void User_mengakses_url() {
		driver = DriverSingelton.getDriver();
		driver.get(Constant.URL);
	}
	
	@And("User input email, password dan klik button login")
	public void user_input_email_dan_password() {
		loginPages.LoginForm(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@Then("User berhasil login")
	public void user_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcome(), loginPages.getTxtWelcome());
	}
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
