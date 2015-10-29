package com.vzw.prepaid.executor;

import org.apache.log4j.Logger;

import com.vzw.prepaid.configuration.DatasourceConfigurator;
import com.vzw.prepaid.configuration.GenerateTestObject;
import com.vzw.prepaid.configuration.GenericConfigurator;
import com.vzw.prepaid.configuration.LogConfigurator;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.factory.RequestFactory;

public class Main {

	static Logger logger  = Logger.getLogger(Main.class);

	public static void main(String args[]){
		
		DatasourceConfigurator dsconfig=null;
		GenericConfigurator logconfig = null;
		PropertyConfigurator propconfig = null;
		GenerateTestObject requestObject = null;
		Testcase test = null;
		TestCaseExecutor executor = null;
		
		try {
			
			logconfig = new LogConfigurator();
			logconfig.configure();
			
			propconfig = new PropertyConfigurator();
			propconfig.configure();
			
			dsconfig = new DatasourceConfigurator();
			dsconfig.configure();
			
			logger.info("Configuration Loaded!!!");
			
			requestObject = RequestFactory.getRequest(PropertyConfigurator.props.getProperty("REQUEST_TYPE"));
			
			test = requestObject.constructTestObject(3);
			
			executor = new TestCaseExecutor(test,true);
			executor.execute();
			
		
		}catch (Exception e ){
			
			logger.error("Execption in Main block");
		}finally{
		
			if (dsconfig != null ){
				dsconfig.destroy();
		
		}
	}
	
}
}
