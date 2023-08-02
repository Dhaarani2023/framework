package com.learningAutomation.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.learningAutomation.pages.BaseClass;
import com.learningAutomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass{
	
	
	
	@Test
	public void loginApp()  throws InterruptedException {
		
		
		logger = reports.createTest("Login to CRM");
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		lp.clickLogin();
		
		logger.info("Successfully clicked on login button");
		
		String uname = excel.getStringData("Login", 0, 0);
		
		String pwd = excel.getStringData("Login", 0, 1);
		
		lp.loginToCRM(uname, pwd);
		
		// ****** we can either use the above where we are first storing the data in a variable and then passing them or else we can directly write the code like below
		
		//lp.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));		
			
		logger.pass("test passed");
		
	}

	//****** Sample test just to show the reports look if we give logger.fail
	@Test
	public void loginApp1(){
		
		
		logger = reports.createTest("LogOut");
		logger.fail("Logout failed");
	}
	

}
