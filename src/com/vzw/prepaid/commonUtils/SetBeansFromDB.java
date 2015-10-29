package com.vzw.prepaid.commonUtils;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.Object;

public class SetBeansFromDB 
{
	public TestCase returnTestCase(CallableStatement cstmt, TestCase testCase) throws SQLException
	{
		testCase = new TestCase();
		testCase.setTestCaseId(cstmt.getInt(1));
		testCase.setTestCaseName(cstmt.getString(2));
		testCase.setTestCaseDesc(cstmt.getString(3));
		testCase.setCreatedDate(cstmt.getDate(4));
		testCase.setLastUpdatedDate(cstmt.getDate(5));
		testCase.setCreatedUserId(cstmt.getString(6));
		testCase.setLastUpdateUserId(cstmt.getString(7));
		return testCase;
	}
	
	public Data returnData(CallableStatement cstmt, Data data) throws SQLException
	{
		data = new Data();
		data.setDataId(cstmt.getInt(1));
		data.setDataName(cstmt.getString(2));
		data.setDataValue(cstmt.getString(3));
		data.setDataDesc(cstmt.getString(4));
		return data;
	}
	
	public Object returnObject (CallableStatement cstmt, Object object) throws SQLException
	{
		object = new Object();
		object.setObjectId(cstmt.getInt(1));
		object.setObjectName(cstmt.getString(2));
		object.setObjectXPath(cstmt.getString(3));
		object.setObjectDesc(cstmt.getString(4));
		return object;
	}
	
	public Step returnStep(CallableStatement cstmt, Step step) throws SQLException
	{
		step = new Step();
		step.setStepId(cstmt.getInt(1));
		step.setStepName(cstmt.getString(2));
		step.setAction(cstmt.getString(3));
		step.setStepDesc(cstmt.getString(4));
		return step;
	}
}
