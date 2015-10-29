package com.vzw.prepaid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.vzw.prepaid.beans.Data;
import com.vzw.prepaid.beans.Flow;
import com.vzw.prepaid.beans.Object;
import com.vzw.prepaid.beans.Step;
import com.vzw.prepaid.beans.TestCase;
import com.vzw.prepaid.beans.TestResult;
import com.vzw.prepaid.commonUtils.SetBeansFromDB;
import com.vzw.prepaid.configuration.DatasourceConfigurator;

public class DatabaseRequestDAOImpl extends BaseDAO implements
		DatabaseRequestDAO {
	
	static Logger log = Logger.getLogger(DatabaseRequestDAOImpl.class);

	@Override
	public TestCase getTestcase(int testCaseId) {
		log.info("Input: " + testCaseId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_TEST_CASE(:P_TEST_CASE_ID,:P_TEST_CASE_NAME,:P_TEST_CASE_DESC,:P_CREATED_DT,:P_LAST_UPDATED_DT,:P_CREATED_USER_ID,:P_LAST_UPDATED_USER_ID)}";
		TestCase testCase = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt("P_TEST_CASE_ID", testCaseId);
			cstmt.registerOutParameter("P_TEST_CASE_ID", java.sql.Types.NUMERIC);
			cstmt.registerOutParameter("P_TEST_CASE_NAME", java.sql.Types.VARCHAR);
			cstmt.registerOutParameter("P_TEST_CASE_DESC", java.sql.Types.VARCHAR);
			cstmt.registerOutParameter("P_CREATED_DT", java.sql.Types.DATE);
			cstmt.registerOutParameter("P_LAST_UPDATED_DT", java.sql.Types.DATE);
			cstmt.registerOutParameter("P_CREATED_USER_ID", java.sql.Types.VARCHAR);
			cstmt.registerOutParameter("P_LAST_UPDATED_USER_ID", java.sql.Types.VARCHAR);
			cstmt.execute();
			SetBeansFromDB setter = new SetBeansFromDB();
			testCase = setter.returnTestCase(cstmt, testCase);
			testCase.setFlow(this.getFlows(testCase));
			
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching test cases. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		log.info("Output: " + testCase.toString());
		return testCase;
		
	}

	@Override
	public List<Flow> getFlows(TestCase testCase) {
		log.info("Input :" + testCase.toString());
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		List<Flow> flows = null;
		ResultSet rs = null;
		Flow flow = null;
		
		String query = "{call QA_PKG.GET_FLOWS(:P_TEST_CASE_ID,:P_OUTPUT)}";
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt("P_TEST_CASE_ID", testCase.getTestCaseId());
			//cstmt.registerOutParameter("P_OUTPUT", java.sql.Types.)
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching Flows. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		return flows;
	}

	@Override
	public Data getData(int dataId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(int objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Step getStep(int stepId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDataId(int stepId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getObjectId(int stepId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Flow getFlow(int flowId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Step> getSteps(int flowId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestResult> getTestResult(int flowId) {
		// TODO Auto-generated method stub
		return null;
	}

}
