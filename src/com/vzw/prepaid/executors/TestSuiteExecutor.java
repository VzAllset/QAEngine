package com.vzw.prepaid.executors;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.comparators.TestCaseComparator;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.dao.generated.QaTestCase;
import com.vzw.prepaid.dao.generated.QaTestSuite;
import com.vzw.prepaid.dao.generated.QaTestSuiteTestCaseMap;
import com.vzw.prepaid.factory.BrowserFactory;

public class TestSuiteExecutor implements Executor
{
	private QaTestSuite suite;
	private WebDriver driver;
	
	public TestSuiteExecutor(QaTestSuite suite)
	{
		this.suite = suite;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws Exception 
	{
		Set<QaTestSuiteTestCaseMap> testSuiteSet = (Set<QaTestSuiteTestCaseMap>)suite.getQaTestSuiteTestCaseMapsForTestSuiteId();
		/* For Sorting */
		Set<QaTestSuiteTestCaseMap> set = new TreeSet<QaTestSuiteTestCaseMap>(new TestCaseComparator());
		set.addAll(testSuiteSet);
		/* ends */
		Iterator<QaTestSuiteTestCaseMap> itr = set.iterator();
		while(itr.hasNext())
		{
			QaTestSuiteTestCaseMap map = (QaTestSuiteTestCaseMap)itr.next();
			QaTestSuite testSuite = map.getQaTestSuiteByTestSuiteId();
			QaTestCase testCase = map.getQaTestCase();
			if(testSuite.getNewBrowser().equalsIgnoreCase("Y"))
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
