
package com.learningAutomation.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.close();
		//Thread.sleep(1000);
		
		
		
		
	}

}
