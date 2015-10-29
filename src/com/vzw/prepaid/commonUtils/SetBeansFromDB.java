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
		testCase.setTestCaseId(cstmt.getInt("P_TEST_CASE_ID"));
		testCase.setTestCaseName(cstmt.getString("P_TEST_CASE_NAME"));
		testCase.setTestCaseDesc(cstmt.getString("P_TEST_CASE_DESC"));
		testCase.setCreatedDate(cstmt.getDate("P_CREATED_DT"));
		testCase.setLastUpdatedDate(cstmt.getDate("P_LAST_UPDATED_DT"));
		testCase.setCreatedDate(cstmt.getDate("P_CREATED_USER_ID"));
		testCase.setLastUpdateUserId(cstmt.getString("P_LAST_UPDATED_USER_ID"));
		return testCase;
	}
	
	public Data returnData(CallableStatement cstmt, Data data) throws SQLException
	{
		data = new Data();
		data.setDataId(cstmt.getInt("P_DATA_ID"));
		data.setDataName(cstmt.getString("P_DATA_NAME"));
		data.setDataValue(cstmt.getString("P_DATA_VALUE"));
		data.setDataDesc(cstmt.getString("P_DATA_DESC"));
		return data;
	}
	
	public Object returnObject (CallableStatement cstmt, Object object) throws SQLException
	{
		object = new Object();
		object.setObjectId(cstmt.getInt("P_OBJECT_ID"));
		object.setObjectName(cstmt.getString("P_OBJECT_NAME"));
		object.setObjectXPath(cstmt.getString("P_OBJECT_XPATH"));
		object.setObjectDesc(cstmt.getString("P_OBJECT_DESC"));
		return object;
	}
	
	public Step returnStep(CallableStatement cstmt, Step step) throws SQLException
	{
		step = new Step();
		step.setStepId(cstmt.getInt("P_STEP_ID"));
		step.setStepName(cstmt.getString("P_STEP_NAME"));
		step.setAction(cstmt.getString("P_ACTION"));
		step.setStepDesc(cstmt.getString("P_STEP_DESC"));
		return step;
	}
}
