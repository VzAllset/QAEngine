package com.vzw.prepaid.executors;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestResult;
import com.vzw.prepaid.comparators.StepComparator;
import com.vzw.prepaid.dao.ProcessorDAO;
import com.vzw.prepaid.exceptions.StepException;

public class FlowExecutor implements Executor
{
	private TestCase testCase;
	private Flow flow;
	private WebDriver driver;
	
	FlowExecutor (TestCase testCase, Flow flow, WebDriver driver)
	{
		this.testCase = testCase;
		this.flow = flow;
		this.driver = driver;
	}
	@Override
	public void execute() throws Exception 
	{
		List<Step> steps = flow.getSteps();
		Collections.sort(steps, new StepComparator());
		String capturedData = null;
		for(Step step : steps)
		{
			if(steps != null)
			{
				if(step.getRefFlowId() != 0 && step.getRefStepId()!= 0)
				{
					ProcessorDAO dao = new ProcessorDAOImpl();
					capturedData = dao.getCapturedData(step.getRefFlowId(),step.getRefStepId());
					step.getData().setDataValue(capturedData);
					StepExecutor stepExecutor = new StepExecutor(step, step.getObject(),step.getData(),driver,flow,testCase);
					try
					{
						stepExecutor.execute();
					}
					catch(StepException se)
					{
						throw se;
					}
				}
			}
		}
	}
	public void validate(Flow flow) throws StepException
	{
		List<TestResult> tests = flow.getTests();
		for(TestResult test : tests)
		{
			
		}
	}
}
