package com.vzw.prepaid.request;

import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestSuite;
import com.vzw.prepaid.configuration.GenerateTestObject;
import com.vzw.prepaid.dao.DatabaseRequestDAO;
import com.vzw.prepaid.dao.DatabaseRequestDAOImpl;

public class DatabaseRequest implements GenerateTestObject{
	
	@Override
	public TestCase constructTestObject(int testCaseId){
		
		DatabaseRequestDAO dao = new DatabaseRequestDAOImpl();
		TestCase test = dao.getTestcase(testCaseId);
		return test;
	}
	public TestSuite constructTestSuite(int testSuiteId)
	{
		DatabaseRequestDAO dao = new DatabaseRequestDAOImpl();
		TestSuite testSuite = dao.getTestSuite(testSuiteId);
		return testSuite;
	}
}
