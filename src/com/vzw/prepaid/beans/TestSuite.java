package com.vzw.prepaid.beans;

import java.util.List;

public class TestSuite 
{
	private int testSuiteId;
	private String testSuiteName;
	private Application application;
	private List<TestCase> testCases;
	private String needNewBrowser;
	
	public int getTestSuiteId() {
		return testSuiteId;
	}
	public void setTestSuiteId(int testSuiteId) {
		this.testSuiteId = testSuiteId;
	}
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public List<TestCase> getTestCases() {
		return testCases;
	}
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}
	public String getNeedNewBrowser() {
		return needNewBrowser;
	}
	public void setNeedNewBrowser(String needNewBrowser) {
		this.needNewBrowser = needNewBrowser;
	}
	@Override
	public String toString() {
		return "TestSuite [testSuiteId=" + testSuiteId + ", testSuiteName=" + testSuiteName + ", application="
				+ application + ", testCases=" + testCases + ", needNewBrowser=" + needNewBrowser + "]";
	}
}
