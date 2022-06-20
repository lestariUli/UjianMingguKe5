package com.juaracoding.ujianminggu5;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujianMinggu5.config.AutomationConfig;
import com.juaracoding.ujianMinggu5.driver.DriverSingelton;
import com.juaracoding.ujianMinggu5.pages.AddToCart;
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
	private AddToCart addToCart;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setup() {
		DriverSingelton.getInstance(configurationProperties.getBrowser());
		loginPages = new LoginPages();
		addToCart = new AddToCart();
	}
	
	@Given("User mengakses url")
	public void User_mengakses_url() {
		driver = DriverSingelton.getDriver();
		driver.get(Constant.URL);
	}
	
	@Then("User input email, password dan klik button login")
	public void user_input_email_dan_password() {
		loginPages.LoginForm(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@When("User berhasil login")
	public void user_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtWelcome(), loginPages.getTxtWelcome());
	}
	
	//module ke2 yaitu addToCart
	@Then("user checkout produk women")
	public void user_checkout_produk_women(){
		addToCart.addCartItemWomen();
	}
	
	@And("user checkout product dress")
	public void user_checkout_product_dress() {
		driver.navigate().refresh();
		tunggu(2);
		addToCart.addCartItemDress();
	}
	
	@Then("user checkout product t-shirt")
	public void user_checkout_product_tshirt(){
		driver.navigate().refresh();
		tunggu(2);
		addToCart.addCartItemTshirt();
	}
	
	@When("user proses checkout")
	public void user_proses_checkout() {
		addToCart.checkOut();
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTxtAddress(), addToCart.getTxtAddress());
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
