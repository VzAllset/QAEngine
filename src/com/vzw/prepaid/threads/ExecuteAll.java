package com.vzw.prepaid.threads;

import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import com.vzw.prepaid.beans.TestSuite;
import com.vzw.prepaid.configuration.GenerateTestObject;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.dao.BaseDAO;
import com.vzw.prepaid.dao.generated.QaTestSuite;
import com.vzw.prepaid.executors.TestSuiteExecutor;
import com.vzw.prepaid.factory.RequestFactory;

public class ExecuteAll implements Callable<HashMap<String,Object>>
{
	static Logger logger  = Logger.getLogger(ExecuteAll.class);
	
	private int testSuiteId = 0;
	
	public ExecuteAll(int testSuiteId)
	{
		this.testSuiteId = testSuiteId;
	}
	
	public HashMap<String,Object> executeInThreads()
	{
		GenerateTestObject requestObject = null;
		QaTestSuite suite = null;
		TestSuiteExecutor executor = null;
		HashMap<String,Object> result = new HashMap<String,Object>();
		Transaction transaction = null;
		
		try 
		{
			requestObject = RequestFactory.getRequest(PropertyConfigurator.props.getProperty("REQUEST_TYPE"));
			BaseDAO baseDao = new BaseDAO();
			transaction = baseDao.getSessionFactory().getCurrentSession().beginTransaction();
			suite = requestObject.constructTestSuite(testSuiteId);
			executor = new TestSuiteExecutor(suite);
			executor.execute();
			result.put(String.valueOf(testSuiteId), "Success");
		}
		catch (Exception e )
		{
			logger.error("Execption in ExecuteAll block ",e);
			result.put(String.valueOf(testSuiteId), "Failed");
		}
		finally
		{
			if(transaction != null)
			{
				transaction.commit();
			}
		}
		return result;
	}

	@Override
	public HashMap<String, Object> call() throws Exception {
		return executeInThreads();
	}
}
