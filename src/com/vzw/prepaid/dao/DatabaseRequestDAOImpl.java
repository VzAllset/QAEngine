package com.vzw.prepaid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String query = "{call GET_TEST_CASE(?,?,?,?,?,?,?)}";
		TestCase testCase = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, testCaseId);
			cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.DATE);
			cstmt.registerOutParameter(5, java.sql.Types.DATE);
			cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.execute();
			SetBeansFromDB setter = new SetBeansFromDB();
			testCase = setter.returnTestCase(cstmt, testCase);
			testCase.setFlows(this.getFlows(testCase));
			
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
		
		String query = "{call GET_FLOWS(?)}";
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, testCase.getTestCaseId());
			boolean hasResultSet =  cstmt.execute();
		      if( hasResultSet ){
		    	  flows = new ArrayList<Flow>();
		            rs = cstmt.getResultSet();
		            while (rs.next()) {
		                flow = new Flow();
		                flow.setFlowId(rs.getInt(1));
		                flow.setFlowDesc(rs.getString(2));
		                flow.setExecutionSequence(rs.getInt(3));
		                flow.setSteps(this.getSteps(flow.getFlowId()));
		                flow.setTests(this.getTestResult(flow.getFlowId()));
		                flows.add(flow);
		            }
		            rs.close();
		            
		      }
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
		log.info("Input: " + dataId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_DATA(?,?,?,?)}";
		Data data = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, dataId);
			cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.execute();
			SetBeansFromDB setter = new SetBeansFromDB();
			data = setter.returnData(cstmt, data);
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching data. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		return data;
	}

	@Override
	public Object getObject(int objectId) {
		log.info("Input " + objectId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_OBJECT(?,?,?,?)}";
		Object object = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, objectId);
			cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.execute();
			SetBeansFromDB setter = new SetBeansFromDB();
			object = setter.returnObject(cstmt, object);
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching object. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		return object;
	}

	@Override
	public Step getStep(int stepId) {
		log.info("Input : " + stepId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_STEP(?,?,?,?)}";
		Step step = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, stepId);
			cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			cstmt.execute();
			SetBeansFromDB setter = new SetBeansFromDB();
			step	 = setter.returnStep(cstmt, step);
			/* get and set object */
			step.setObject(this.getObject(this.getObjectId(stepId)));
			/* get and set Data */
			step.setData(this.getData(this.getDataId(stepId)));
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching step. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		return step;
	}

	@Override
	public int getDataId(int stepId) {
		log.info("Input for getDataId: " + stepId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_DATA_ID(?,?)}";
		int dataId = 0;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, stepId);
			cstmt.registerOutParameter(2, java.sql.Types.NUMERIC);
			cstmt.execute();
			dataId = cstmt.getInt(2);
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching Data Id. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		return dataId;
	}

	@Override
	public int getObjectId(int stepId) {
		log.info("Input for getObjectId: " + stepId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_OBJECT_ID(?,?)}";
		int objectId = 0;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, stepId);
			cstmt.registerOutParameter(2, java.sql.Types.NUMERIC);
			cstmt.execute();
			objectId = cstmt.getInt(2);
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching Object Id. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		return objectId;
	}

	@Override
	public Flow getFlow(int flowId) {
		log.info("Input for getFlow: " + flowId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_FLOW(?,?)}";
		Flow flow = null;
		List<Step> steps = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, flowId);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();
			flow = new Flow();
			flow.setFlowId(flowId);
			flow.setFlowDesc(cstmt.getString(2));
			steps = this.getSteps(flowId);
			flow.setSteps(steps);			
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching Flow. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		return flow;
	}

	@Override
	public List<Step> getSteps(int flowId) {
		log.info("Input for getSteps: " + flowId);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_STEPS(?)}";
		ResultSet rs = null;
		List<Step> steps = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, flowId);
			boolean hasResultSet =  cstmt.execute();
		      if( hasResultSet ){
		    	  steps = new ArrayList<Step>();
		            rs = cstmt.getResultSet();
		            while (rs.next()) {
		            	int stepId = rs.getInt(2);
		                Step step = this.getStep(stepId);
		                step.setExecutionSequence(rs.getInt(5));
		                step.setRefFlowId(rs.getInt(3));
		                step.setRefStepId(rs.getInt(6));
		                step.setRefKey(rs.getString(7));
		                steps.add(step);
		                
		            }
		            rs.close();
		            
		      }
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching Steps. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		return steps;
	}

	@Override
	public List<TestResult> getTestResult(int flowId) {
		log.info("Input for getTestResult:" + flowId );
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{call GET_FLOW_TEST_RESULT(?)}";
		ResultSet rs = null;
		List<TestResult> testResultList = null;
		TestResult testResult = null;
		
		try {
			cstmt = conn.prepareCall(query);
			cstmt.setInt(1, flowId);
			boolean hasResultSet =  cstmt.execute();
		      if( hasResultSet ){
		    	  testResultList = new ArrayList<TestResult>();
		            rs = cstmt.getResultSet();
		            while (rs.next()) {
		            	testResult = new TestResult();
		            	testResult.setTestResultId(rs.getInt(1));
		            	testResult.setTestResultDesc(rs.getString(2));
		            	testResult.setStatus(rs.getString(3));
		            	testResult.setAction(rs.getString(5));
		            	testResult.setData(this.getData(rs.getInt(7)));
		            	testResult.setObject(this.getObject(rs.getInt(6)));
		                testResultList.add(testResult);
		                
		            }
		            rs.close();
		            
		      }
		}
		catch(SQLException sqle) {
			log.error("SQLException while fetching Steps. Exception message is ", sqle);
		}
		finally {
			close(cstmt,conn);
		}
		
		return testResultList;
	}

}
