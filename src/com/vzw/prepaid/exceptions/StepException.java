package com.vzw.prepaid.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.TestResult;
import com.vzw.prepaid.dao.generated.QaFlow;
import com.vzw.prepaid.dao.generated.QaStep;
import com.vzw.prepaid.dao.generated.QaTestResult;

public class StepException extends Exception{

	
	private QaStep step;
	private Throwable thr;
	
	public StepException(QaStep step , Throwable t){
		super();
		this.step=step;
		this.thr=t;
		
	}
	
	public StepException(QaFlow flow, QaTestResult test){
		super("Test failed for the flow :"+ flow.toString() + " and for the test"+ test.toString());
		this.thr= new Throwable("Test failed for the flow :"+ flow.toString() + "and for the test :"+ test.toString());
	}
	
	public QaStep getStep(){
		return step;
	}
	
	public String toString(){
		return String.valueOf(ExceptionUtils.getStackTrace(thr));
	}
	
	
}
