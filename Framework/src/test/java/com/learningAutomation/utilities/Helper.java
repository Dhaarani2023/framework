package com.learningAutomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//
	
	public String captureScreenshot(WebDriver driver) {
		
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	System.out.println("Screenshot captured successfully");
	String screenShotPath = System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+timeStamp()+".png";
	try {
		
		FileHandler.copy(src, new File(screenShotPath));
	
	} 
	catch (IOException e) {
		
		System.out.println("Unable to capture Screenshot....."+ e.getMessage());
		}
	return  screenShotPath;
	}
	

	public String timeStamp() {
		
		DateFormat customeFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return customeFormat.format(currentDate);
		
	}
}
