package com.learningAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learningAutomation.utilities.BrowserFactory;
import com.learningAutomation.utilities.ConfigDataProvider;
import com.learningAutomation.utilities.ExcelDataProvider;
import com.learningAutomation.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public Helper helper;
	
	//*** the below extent report classes we have not created we are just using it from the pre defined  
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUp() {
		
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 helper =new Helper();
		 
		 //********Extent report
		 
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+helper.timeStamp()+".html"));
		 reports =new ExtentReports();
		 reports.attachReporter(extent);
		 
	}

	@BeforeClass
	public void startBrowser() {
		//driver=BrowserFactory.startApplication(driver, "chrome", "https://freecrm.com/index.html");
		
		//****** we can either hardcode the browser and url or we can pass from the config file like the below syntax
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
	}
	
@AfterClass
	
	public void quitBrowser() {
		BrowserFactory.quitBrowser(driver);
		
	}
	
@AfterMethod

//***** this will capture screenshot only if the test case is failed***** this ITestResult interface is used to capture the status of execution at runTime
public void screenShot(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE) {
		String screenShotPath = helper.captureScreenshot(driver);	
		logger.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		String screenShotPath = helper.captureScreenshot(driver);	
		logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	}
	
	reports.flush();
	
}
	

}
