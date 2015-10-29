package com.vzw.prepaid.dao;

import java.io.FileInputStream;
import java.io.IOException;

public interface ProcessorDAO {
	
	public void captureData(String capturedValue, int refStepId, String refKey );
	public String getCapturedData(int refFlowId, int refStepId);
	public void insertStepStatus(int testCaseId, int flowId, int stepId, String status);
	public void insertErrorLog(String threadId, String errorLog, FileInputStream fis) throws IOException;

}
