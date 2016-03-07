package com.vzw.prepaid.processor;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.vzw.prepaid.commonUtils.Utils;
import com.vzw.prepaid.dao.ProcessorDAOImpl;
import com.vzw.prepaid.dao.generated.QaData;
import com.vzw.prepaid.dao.generated.QaDepData;
import com.vzw.prepaid.dao.generated.QaDepDataHome;
import com.vzw.prepaid.dao.generated.QaFlow;
import com.vzw.prepaid.dao.generated.QaFlowStepMap;
import com.vzw.prepaid.dao.generated.QaFlowStepMapHome;
import com.vzw.prepaid.dao.generated.QaObject;
import com.vzw.prepaid.dao.generated.QaStep;
public class CaptureActionProcessor implements ActionExecutor{

	private QaObject object;
	private WebDriver driver;
	private QaStep step;
	private QaFlow flow;
	
	public CaptureActionProcessor(QaObject object, QaData data, WebDriver driver, QaStep step, QaFlow flow)
	{
		this.object = object;
		this.driver = driver;
		this.flow = flow;
		this.step = step;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void runAction() {
		String xpath = object.getObjXpath();
		String capturedValue =  Utils.getWebElement(driver, xpath).getText();
		QaFlowStepMapHome flowStepMapHome = new QaFlowStepMapHome();
		QaFlowStepMap flowStepMapExample = new QaFlowStepMap();
		flowStepMapExample.setQaFlowByFlowId(flow);
		flowStepMapExample.setQaStepByStepId(step);
		List<QaFlowStepMap> flowStepMapList = flowStepMapHome.findByExample(flowStepMapExample);
		flowStepMapExample = flowStepMapList.get(0);// Always only one object should be returned
		
		QaDepData depData = new QaDepData();
		depData.setCreatedDt(new Date());
		depData.setQaStep(step);
		depData.setQaFlow(flow);
		depData.setDataKey(flowStepMapExample.getRefKey());
		depData.setDataValue(capturedValue);
		QaDepDataHome depDataHome = new QaDepDataHome();  
		depDataHome.persist(depData);
	}

}
