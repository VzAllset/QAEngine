package com.vzw.prepaid.executors;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.exceptions.StepException;
import com.vzw.prepaid.factory.ActionFactory;

public class StepExecutor implements Executor
{
	static Logger log = Logger.getLogger(StepExecutor.class)
	
	private Step step;
	private Data data;
	private Object object;
	private String action;
	private WebDriver driver;
	private Flow flow;
	private TestCase testCase;
	private ProcessorDAO processorDAO;
	
	
	public StepExecutor(Step step, Object object, Data data, WebDriver driver, Flow flow, TestCase testCase)
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
			executor.runAc
		}
		catch(Exception e)
		{
			throw new StepException(step,e);
		}
		processorDAO = new ProcessorDAOImpl();
		processorDAO.insertStepStatus(testCase.getTestCaseId());
	}

}
