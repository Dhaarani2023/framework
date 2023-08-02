package com.learningAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File(System.getProperty("user.dir")+"/Config/Config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("******* Not able to load config file...."+e.getMessage());
		}	
	}

	// **** we can have just one method to get all the key value pairs from the config file by passing the key name while calling the method. This will be more effective that the one we used below because while using this we dont need to create multiple methods for each key value pair
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	
	
	// ***** we can either get the data from the config file like below in this case we need to create a method for each key value pair that we have in the config file
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
	
}
