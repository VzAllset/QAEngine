package com.vzw.prepaid.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.log4j.Logger;
import com.vzw.prepaid.configuration.DatasourceConfigurator;
import com.vzw.prepaid.configuration.GenericConfigurator;
import com.vzw.prepaid.configuration.LogConfigurator;
import com.vzw.prepaid.configuration.PropertyConfigurator;

public class ThreadInitiator 
{
	static Logger logger  = Logger.getLogger(ThreadInitiator.class);
			
	DatasourceConfigurator dsconfig = null;
	GenericConfigurator logconfig = null;
	PropertyConfigurator propconfig = null;
	HashMap<String,Object> result = new HashMap<String,Object>();
	
	public HashMap<String,Object> initiate(String testCaseIds)
	{
		try 
		{
			logconfig = new LogConfigurator();
			logconfig.configure();
			propconfig = new PropertyConfigurator();
			propconfig.configure();
			dsconfig = new DatasourceConfigurator();
			dsconfig.configure();
			logger.info("Configuration Loaded!!!");
			
			//Get ExecutorService from Executors utility class, thread pool size is 10
	        ExecutorService executor = Executors.newFixedThreadPool(10);
	        //create a list to hold the Future object associated with Callable
	        List<Future<HashMap<String,Object>>> list = new ArrayList<Future<HashMap<String,Object>>>();
	        //Create MyCallable instance
	        StringTokenizer tokenizer = new StringTokenizer(testCaseIds,",");
	        while(tokenizer.hasMoreTokens())
	        {
	        	Callable<HashMap<String,Object>> callable = new ExecuteAll(Integer.parseInt(tokenizer.nextToken()));
	        	Future<HashMap<String,Object>> future= executor.submit(callable);
	        	list.add(future);
	        }
	        for(Future<HashMap<String,Object>> fut : list)
	        {
	            try 
	            {
	                //print the return value of Future, notice the output delay in console
	                // because Future.get() waits for task to get completed
	                System.out.println(new Date()+ "::"+fut.get());
	                result.putAll(fut.get());
	            } catch (InterruptedException | ExecutionException e) {
	                e.printStackTrace();
	            }
	        }
	        //shut down the executor service now
	        executor.shutdown();
			
		}
		catch (Exception e )
		{
			logger.error("Execption in ExecuteAll block ",e);
		}
		finally
		{
			if (dsconfig != null ){
				dsconfig.destroy();
		
			}
		}
		return result;
	}
}
