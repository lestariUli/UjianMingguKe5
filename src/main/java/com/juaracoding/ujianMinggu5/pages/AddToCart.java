package com.juaracoding.ujianMinggu5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.ujianMinggu5.driver.DriverSingelton;

public class AddToCart {
	private WebDriver driver;
	public AddToCart() {
		this.driver = DriverSingelton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//locator
	@FindBy(css="#block_top_menu > ul > li:nth-child(1)")
	private WebElement menu_women;
	
	@FindBy(css="#block_top_menu > ul > li:nth-child(2)")
	private WebElement menu_dress;
	
	@FindBy(css="#block_top_menu > ul > li:nth-child(3)")
	private WebElement menu_tshirt;
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement item_women;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")
	private WebElement item_dress; 

	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement item_tshirt;
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(id="group_1")
	private WebElement size;
	
	@FindBy(id="color_13")
	private WebElement colorWoman;
	
	@FindBy(id="color_11")
	private WebElement colorDress;
	
	@FindBy(id="add_to_cart")
	private WebElement btn_add_to_cart;
	
	@FindBy (css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")
	private WebElement btnContinueShoping;
	
	@FindBy(css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
	private WebElement btn_process_checkout;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	private WebElement btn_process_to_checkout;
	
	@FindBy(xpath="//label[@for='id_address_delivery']")
	private WebElement txtAddress;
	
	public void addCartItemWomen() {
		menu_women.click();
		scroll(driver, "1000");
		item_women.click();
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		
		quantity.sendKeys("1");
		select(size).selectByValue("2");
		colorWoman.click();
		btn_add_to_cart.click();
		driver.switchTo().defaultContent();
		btnContinueShoping.click();
	}
	
	public void addCartItemDress() {
		menu_dress.click();
		scroll(driver, "1000");
		item_dress.click();
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		
		quantity.sendKeys("3");
		select(size).selectByValue("3");
		colorDress.click();
		btn_add_to_cart.click();
		driver.switchTo().defaultContent();
		btnContinueShoping.click();
	}
	
	public void addCartItemTshirt() {
		menu_tshirt.click();
		scroll(driver, "800");
		item_tshirt.click();
		
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		quantity.sendKeys("1");
		select(size).selectByValue("1");
		colorWoman.click();
		btn_add_to_cart.click();
		driver.switchTo().defaultContent();
		btn_process_checkout.click();
	}
	
	public void checkOut() {
		btn_process_to_checkout.click();
	}
	
	public String getTxtAddress() {
		return txtAddress.getText();
	}
	
	//method select
	public static Select select(WebElement params) {
		Select se = new Select(params);
		return se;
	}
	//method scroll
	public static void scroll(WebDriver driver,String num) {
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		js.executeScript("scrollBy(0,"+num+")");
	}
	

}
