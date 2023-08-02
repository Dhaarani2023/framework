package com.learningAutomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL) {
		
	if(browserName.equals("Chrome")) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
	driver = new ChromeDriver();
	}
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}

}
