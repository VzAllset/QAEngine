package com.vzw.prepaid.processor;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.ProcessorDAOImpl;

public class CaptureAttrActionProcessor implements ActionExecutor{

	private Object object;
	private WebDriver driver;
	private Step step;
	private Flow flow;
	
	public CaptureAttrActionProcessor(Object object, Data data, WebDriver driver, Step step, Flow flow)
	{
		this.object = object;
		this.driver = driver;
		this.flow = flow;
		this.step = step;
	}
	
	@Override
	public void runAction() {
		String xpath = object.getObjectXPath();
		String capturedValue =  Utils.getWebElement(driver, xpath).getAttribute(step.getRefKey());
		ProcessorDAOImpl processorDao = new ProcessorDAOImpl();
		processorDao.captureData(capturedValue, flow.getFlowId(), step.getStepId(), step.getRefKey());
	}

}

