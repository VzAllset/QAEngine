package com.vzw.prepaid.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestSuite;
import com.vzw.prepaid.comparators.TestCaseComparator;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.factory.BrowserFactory;

public class TestSuiteExecutor implements Executor
{
	private TestSuite suite;
	private WebDriver driver;
	
	public TestSuiteExecutor(TestSuite suite)
	{
		this.suite = suite;
	}
	
	@Override
	public void execute() throws Exception 
	{
		List<TestCase> testCases = suite.getTestCases();
		Collections.sort(testCases, new TestCaseComparator());
		for(TestCase testCase : testCases)
		{
			if(suite.getNeedNewBrowser().equalsIgnoreCase("Y"))
			{
				driver = BrowserFactory.getWebDriver(PropertyConfigurator.props.getProperty("BROWSER"));
				driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyConfigurator.props.getProperty("TIMEOUT")), TimeUnit.SECONDS);
				driver.get(suite.getApplication().getApplicationUrl());
			}
			TestCaseExecutor executor = new TestCaseExecutor(testCase, false, driver);
			executor.execute();
		}
	}
}
