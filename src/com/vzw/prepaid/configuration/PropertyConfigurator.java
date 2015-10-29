package com.vzw.prepaid.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class PropertyConfigurator implements GenericConfigurator 
{
	public static File file = null;
	public static Properties props = null;
	static Logger logger = Logger.getLogger(PropertyConfigurator.class);
	@Override
	public void init() {
		// TODO Auto-generated method stub
		file = new File(ConfigurationConstants.configPath+"qa.properties");
	}

	@Override
	public void configure() {
		this.init();
		props = new Properties();
		InputStream in = LogConfigurator.class.getClassLoader().getResourceAsStream("qa.properties");
		try
		{
			//in = new FileInputStream(file);
			props.clear();
			props.load(in);
			in.close();
		}
		catch(FileNotFoundException fnfe)
		{
			logger.error("File not found. exceptin message is ",fnfe);
		}
		catch(IOException ioe)
		{
			logger.error("Error loading properties. Exception message is ",ioe);
		}
	}

	@Override
	public void destroy() {
		props = null;		
	}
	
	public String getProperty(String propertyName)
	{
		return props.getProperty(propertyName);
	}
}
