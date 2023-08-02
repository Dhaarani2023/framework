package com.learningAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	
	
	@FindBy(xpath = "//*[text()='Log In']") WebElement login;
	@FindBy(name = "email") WebElement uname;
	@FindBy(name = "password") WebElement pwd;
	@FindBy(xpath = "//*[text()='Login']") WebElement loginBtn;
	
	
	public void clickLogin() throws InterruptedException {
		login.click();
		Thread.sleep(5000);
	}
	public void loginToCRM(String username,String password) {
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
	}

}
