package com.vzw.prepaid.executors;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestResult;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.comparators.FlowComparator;
import com.vzw.prepaid.comparators.FlowTestResultComparator;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.dao.ProcessorDAO;
import com.vzw.prepaid.dao.ProcessorDAOImpl;
import com.vzw.prepaid.exceptions.StepException;
import com.vzw.prepaid.factory.BrowserFactory;
import com.vzw.prepaid.factory.TestFactory;
import com.vzw.prepaid.testflow.TestExecutor;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class TestCaseExecutor implements Executor
{
	static Logger logger = Logger.getLogger(TestCaseExecutor.class);
	
	private TestCase testCase;
	private boolean newBrowserFlag;
	private WebDriver driver = null;
	private ProcessorDAO processorDAO;
	
	public TestCaseExecutor(TestCase testCase, boolean needNewBrowser, WebDriver driver)
	{
		this.testCase = testCase;
		this.newBrowserFlag = needNewBrowser;
		Thread.currentThread().setName(Utils.getDate());
		System.out.println("Thread name is "+Utils.getDate());
		this.driver = driver;
	}

	@Override
	public void execute() throws Exception {
		logger.info("Starting to execute the test case >> "+testCase.toString());
		List<Flow> flows = testCase.getFlows();
		Collections.sort(flows, new FlowComparator());
		/*if(newBrowserFlag)
		{
			driver = BrowserFactory.getWebDriver(PropertyConfigurator.props.getProperty("BROWSER"));
			driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyConfigurator.props.getProperty("TIMEOUT")), TimeUnit.SECONDS);
			driver.get(PropertyConfigurator.props.getProperty("APPLICATION_URL"));
		}*/
		for(Flow flow:flows)
		{
			FlowExecutor flowExecutor = new FlowExecutor(testCase,flow,driver);
			logger.debug("Starting to execute the flow >>"+flow.toString());
			try
			{
				flowExecutor.execute();
				if(flow!=null && flow.getTests() != null && flow.getTests().size()>0)
				{
					List<TestResult> tests = flow.getTests();
					Collections.sort(tests, new FlowTestResultComparator());
					for(TestResult test : tests)
					{
						boolean result = true;
						TestExecutor testExecutor = TestFactory.getTestProcessor(test.getAction(), test.getObject(), test.getData(), driver);
						result = testExecutor.runTest();
						if(!result)
						{
							throw new StepException (flow,test);
						}
					}
				}
			}
			catch(StepException se)
			{
				logger.error("Inside step exception. Exception message is ",se);
				processorDAO = new ProcessorDAOImpl();
				if(se != null && se.getStep() != null)
				{
					processorDAO.insertStepStatus(testCase.getTestCaseId(),flow.getFlowId(),se.getStep().getStepId(),"FAILED");
				}
				else
				{
					processorDAO.insertStepStatus(testCase.getTestCaseId(),flow.getFlowId(),Integer.valueOf(PropertyConfigurator.props.getProperty("TEST_FAILED_STEP_ID")),"FAILED");
				}
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				processorDAO.insertErrorLog(Thread.currentThread().getName(),ExceptionUtils.getStackTrace(se),new FileInputStream(file));
				Utils.closeDriver(driver);
				throw se;
			}
			catch(Exception e)
			{
				logger.error("Inside error block. Exception message is ",e);
				Utils.closeDriver(driver);
				throw e;
			}
			logger.info("Exection of flow >>"+flow.toString()+" completed !!");
		}
		//Utils.closeDriver(driver);
		logger.info("Execution of test case >> "+testCase.toString()+" completed !!");
	}
	
}
