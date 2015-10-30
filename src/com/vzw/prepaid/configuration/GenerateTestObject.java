package com.vzw.prepaid.configuration;

import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestSuite;

public interface GenerateTestObject {
	public TestCase constructTestObject(int testCaseId);
	public TestSuite constructTestSuite(int testSuiteId);
}
