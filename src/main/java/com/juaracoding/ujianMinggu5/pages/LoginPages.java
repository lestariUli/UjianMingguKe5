package com.juaracoding.ujianMinggu5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujianMinggu5.driver.DriverSingelton;

public class LoginPages {
	private WebDriver driver; 
	public LoginPages() {
		this.driver = DriverSingelton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id= "passwd")
	private WebElement password;
	@FindBy(id="SubmitLogin")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p")
	private WebElement txtWelcome;
	
	public void LoginForm(String em, String pw) {
		email.sendKeys(em);
		password.sendKeys(pw);
		btnLogin.click();
	}
	//untuk validasi setelah berhasil login
	//mengembalikan nilai txt welcome ke user
	public String getTxtWelcome() {
		return txtWelcome.getText();
	}
	
	
}
