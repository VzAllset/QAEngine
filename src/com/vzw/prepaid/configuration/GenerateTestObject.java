package com.vzw.prepaid.configuration;

import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.dao.generated.QaTestSuite;

public interface GenerateTestObject {
	public TestCase constructTestObject(int testCaseId);
	public QaTestSuite constructTestSuite(int testSuiteId);
}
