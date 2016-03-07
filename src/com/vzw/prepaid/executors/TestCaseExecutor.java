package com.vzw.prepaid.executors;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.comparators.FlowComparator;
import com.vzw.prepaid.configuration.PropertyConfigurator;
import com.vzw.prepaid.dao.generated.QaFailure;
import com.vzw.prepaid.dao.generated.QaFailureHome;
import com.vzw.prepaid.dao.generated.QaFlow;
import com.vzw.prepaid.dao.generated.QaResultTestCase;
import com.vzw.prepaid.dao.generated.QaResultTestCaseHome;
import com.vzw.prepaid.dao.generated.QaStep;
import com.vzw.prepaid.dao.generated.QaStepHome;
import com.vzw.prepaid.dao.generated.QaTestCase;
import com.vzw.prepaid.dao.generated.QaTestCaseFlowMap;
import com.vzw.prepaid.exceptions.StepException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class TestCaseExecutor implements Executor
{
	static Logger logger = Logger.getLogger(TestCaseExecutor.class);
	
	private QaTestCase qaTestCase;
	private boolean newBrowserFlag;
	private WebDriver driver = null;
	
	public TestCaseExecutor(QaTestCase qaTestCase, boolean needNewBrowser, WebDriver driver)
	{
		this.qaTestCase = qaTestCase;
		this.newBrowserFlag = needNewBrowser;
		Thread.currentThread().setName(Utils.getDate());
		System.out.println("Thread name is "+Utils.getDate());
		this.driver = driver;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws Exception {
		logger.info("Starting to execute the test case >> "+qaTestCase.toString());
		/* Sorting based on execution sequence */
		Set<QaTestCaseFlowMap> set = (Set<QaTestCaseFlowMap>)qaTestCase.getQaTestCaseFlowMaps();
		Set<QaTestCaseFlowMap> flowMapSet = new TreeSet<QaTestCaseFlowMap>(new FlowComparator());
		flowMapSet.addAll(set);
		/* Sorting based on execution sequence ends */
		Iterator<QaTestCaseFlowMap> itr = flowMapSet.iterator();
		while(itr.hasNext())
		{
			QaTestCaseFlowMap eachMap = itr.next();
			QaFlow flow = eachMap.getQaFlow();
			QaTestCase testCase = eachMap.getQaTestCase();
			FlowExecutor flowExecutor = new FlowExecutor(testCase,flow,driver);
			try
			{
				flowExecutor.execute();
				/* Tests for each flow code should come here */
				//QaFlowTestMapHome flowTestMapHome = new QaFlowTestMapHome();
				/* Tests for each flow code should come ends */
			}
			catch(StepException se)
			{
				logger.error("Inside step exception. Exception message is ",se);
				QaResultTestCaseHome results = new QaResultTestCaseHome();
				QaResultTestCase resultTestCase = new QaResultTestCase();
				resultTestCase.setQaTestCase(qaTestCase);
				resultTestCase.setQaFlow(flow);
				resultTestCase.setStatus("FAILED");
				resultTestCase.setThreadId(Thread.currentThread().getName());
				if(se != null && se.getStep() != null)
				{
					resultTestCase.setQaStep(se.getStep());
				}
				else
				{
					QaStepHome stepHome = new QaStepHome();
					QaStep step = stepHome.findById(Long.valueOf(PropertyConfigurator.props.getProperty("TEST_FAILED_STEP_ID")));
					resultTestCase.setQaStep(step);
				}
				results.persist(resultTestCase);
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				QaFailure failure = new QaFailure();
				failure.setThreadId(Thread.currentThread().getName());
				failure.setErrorLog(ExceptionUtils.getStackTrace(se));
				failure.setScreenshot(IOUtils.toByteArray(new FileInputStream(file)));
				QaFailureHome failureHome = new QaFailureHome();
				failureHome.persist(failure);
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
	}
}
