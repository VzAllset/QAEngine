package com.vzw.prepaid.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.vzw.prepaid.beans.TestResult;

public class TestException extends Exception{

	
	private TestResult test;
	private Throwable thr;
	
	public TestException(TestResult test){
		super();
		this.test =test;
		this.thr=this.getCause();
		
	}
	
	
	
	public TestResult getTest(){
		return test;
	}
	
	
	@Override
	public String toString(){
		return String.valueOf(ExceptionUtils.getStackTrace(thr));
	}
	
	
}

