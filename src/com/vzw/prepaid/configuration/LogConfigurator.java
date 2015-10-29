package com.vzw.prepaid.configuration;

import org.apache.log4j.PropertyConfigurator;
public class LogConfigurator implements GenericConfigurator {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure() {
		PropertyConfigurator.configure(ConfigurationConstants.configPath+ConfigurationConstants.logFileName);		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
