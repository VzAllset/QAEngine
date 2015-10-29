package com.vzw.prepaid.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.TestResult;

public class StepException extends Exception{

	
	private Step step;
	private Throwable thr;
	
	public StepException(Step step , Throwable t){
		super();
		this.step=step;
		this.thr=t;
		
	}
	
	public StepException(Flow flow, TestResult test){
		super("Test failed for the flow :"+ flow.toString() + " and for the test"+ test.toString());
		this.thr= new Throwable("Test failed for the flow :"+ flow.toString() + "and for the test :"+ test.toString());
	}
	
	public Step getStep(){
		return step;
	}
	
	public String toString(){
		return String.valueOf(ExceptionUtils.getStackTrace(thr));
	}
	
	
}
