package com.vzw.prepaid.dao;

import java.util.List;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestResult;

public interface DatabaseRequestDAO {

	public TestCase getTestcase(int testCaseId);
	public List<Flow> getFlows(TestCase testCase);
	public Data getData(int dataId);
	public Object getObject(int objectId);
	public Step getStep(int stepId);
	public int getDataId(int stepId);
	public int getObjectId(int stepId);
	public Flow getFlow(int flowId);
	public List<Step> getSteps(int flowId);
	public List<TestResult> getTestResult(int flowId);
	
	
}
