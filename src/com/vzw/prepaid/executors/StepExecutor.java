package com.vzw.prepaid.executors;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaFlow;
import com.vzw.prepaid.dao.generated.QaObject;
import com.vzw.prepaid.dao.generated.QaResultTestCase;
import com.vzw.prepaid.dao.generated.QaResultTestCaseHome;
import com.vzw.prepaid.dao.generated.QaStep;
import com.vzw.prepaid.dao.generated.QaTestCase;
import com.vzw.prepaid.exceptions.StepException;
import com.vzw.prepaid.factory.ActionFactory;
import com.vzw.prepaid.processor.ActionExecutor;

public class StepExecutor implements Executor
{
	static Logger log = Logger.getLogger(StepExecutor.class);
	
	private QaStep step;
	private QaData data;
	private QaObject object;
	private String action;
	private WebDriver driver;
	private QaFlow flow;
	private QaTestCase testCase;
	
	public StepExecutor(QaStep step, QaObject object, QaData data, WebDriver driver, QaFlow flow, QaTestCase testCase)
	{
		this.step = step;
		this.data = data;
		this.object = object;
		this.action = ((step !=null)?step.getAction():null);
		this.driver = driver;
		this.flow = flow;
		this.testCase = testCase;
	}
	@Override
	public void execute() throws Exception {
		log.debug("Executing the step >> "+step.toString());
		ActionExecutor executor = ActionFactory.getActionProcessor(action, object, data, driver, step, flow);
		try
		{
			executor.runAction();
		}
		catch(Exception e)
		{
			throw new StepException(step,e);
		}
		
		QaResultTestCaseHome results = new QaResultTestCaseHome();
		QaResultTestCase resultTestCase = new QaResultTestCase();
		resultTestCase.setQaTestCase(testCase);
		resultTestCase.setQaFlow(flow);
		resultTestCase.setStatus("SUCCESS");
		resultTestCase.setThreadId(Thread.currentThread().getName());
		resultTestCase.setQaStep(step);
		results.persist(resultTestCase);
	}

}
