package com.juaracoding.ujianMinggu5.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//digunakan untuk getter setter

@Component //digunkan untuk value
@PropertySource("framework.properties") //value diletakkan di main resources
public class ConfigurationProperties {
	@Value("${browser}")
	private String browser;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Value("${txtWelcome}")
	private String txtWelcome;
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTxtWelcome() {
		return txtWelcome;
	}
	//hasil actual
	public void setTxtWelcome(String txtWelcome) {
		this.txtWelcome = txtWelcome;
	}

	
	
}
