package com.vzw.prepaid.executors;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.comparators.StepComparator;
import com.vzw.prepaid.dao.ProcessorDAO;
import com.vzw.prepaid.dao.ProcessorDAOImpl;
import com.vzw.prepaid.dao.generated.QaDepData;
import com.vzw.prepaid.dao.generated.QaDepDataHome;
import com.vzw.prepaid.dao.generated.QaDepDataId;
import com.vzw.prepaid.dao.generated.QaFlow;
import com.vzw.prepaid.dao.generated.QaFlowStepMap;
import com.vzw.prepaid.dao.generated.QaStep;
import com.vzw.prepaid.dao.generated.QaTestCase;
import com.vzw.prepaid.exceptions.StepException;

public class FlowExecutor implements Executor
{
	private QaTestCase testCase;
	private QaFlow flow;
	private WebDriver driver;
	
	FlowExecutor (QaTestCase testCase, QaFlow flow, WebDriver driver)
	{
		this.testCase = testCase;
		this.flow = flow;
		this.driver = driver;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void execute() throws Exception 
	{
		Set<QaFlowStepMap> set = flow.getQaFlowStepMapsForFlowId();
		Set<QaFlowStepMap> flowToStepMap = new TreeSet<QaFlowStepMap>(new StepComparator());
		flowToStepMap.addAll(set);
		Iterator<QaFlowStepMap> itr = flowToStepMap.iterator();
		while(itr.hasNext())
		{
			QaFlowStepMap eachMap = (QaFlowStepMap)itr.next();
			QaStep currentStep = eachMap.getQaStepByStepId();
			QaFlow dependentFlow = eachMap.getQaFlowByRefFlowId();
			QaStep dependentStep = eachMap.getQaStepByRefStepId();
			if(null != dependentFlow && null != dependentStep)
			{
				QaDepDataHome depDataHome = new QaDepDataHome();
				QaDepDataId depDataId = new QaDepDataId();
				depDataId.setDepId(Thread.currentThread().getName());
				depDataId.setFlowId(dependentFlow.getFlowId());
				depDataId.setStepId(dependentStep.getStepId());
				QaDepData depData = depDataHome.findById(depDataId);
				String dependentValue = depData.getDataValue();
				currentStep.getQaData().setDataValue(dependentValue);//setting dep data value to current step
			}
			StepExecutor stepExecutor = new StepExecutor(currentStep, currentStep.getQaObject(),currentStep.getQaData(),driver,flow,testCase);
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
