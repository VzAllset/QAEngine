package com.vzw.prepaid.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vzw.prepaid.configuration.DatasourceConfigurator;

public class ProcessorDAOImpl extends BaseDAO implements ProcessorDAO{
	
	static Logger log =  Logger.getLogger(ProcessorDAOImpl.class);

	/**
	 * @param capturedValue
	 * @param refFlowId
	 * @param refStepId
	 * @param refKey
	 */
	public 	void captureData(String capturedValue, int refFlowId, int refStepId, String refKey){
		log.info(" Captured Value:" +capturedValue + " refFlowId:" + refFlowId + " refStepId:" + refStepId + " refKey:" + refKey);
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{ call QA_PKG.INSERT_CAPTURED_DATA(:P_CAPTURED_VALUE, :P_REF_FLOW_ID, :P_REF_STEP_ID, :P_REF_KEY_ID , :P_DEP_ID)}";
		
		try{
			cstmt = conn.prepareCall(query);
			cstmt.setString("P_CAPTURED_VALUE", capturedValue	);
			cstmt.setInt("P_REF_FLOW_ID", refFlowId);
			cstmt.setInt("P_REF_STEP_ID", refStepId);
			cstmt.setString("P_REF_KEY_ID", refKey);
			cstmt.setString("P_DEP_ID", Thread.currentThread().getName());
		}
		catch (SQLException sqle){
			log.error("SQLException while fecthing the data. Exception message is" ,sqle);
		}
		finally{
			close(cstmt, conn);
		}
	}


	@Override
	public String getCapturedData(int refFlowId, int refStepId) {
		// TODO Auto-generated method stub
		
		log.info(" Ref Flow ID :" +refFlowId + " Ref Step Id :" + refStepId );
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{ call QA_PKG.GET_CAPTURED_DATA( :P_DEF_ID, P_REF_FLOW_ID, :P_REF_STEP_ID, :P_CAPTURED_VALUE )}";
		String capturedValue= null;
		
		try{
			cstmt = conn.prepareCall(query);
			cstmt.setString("P_DEP_ID", Thread.currentThread().getName());
			cstmt.setInt("P_REF_FLOW_ID", refFlowId);
			cstmt.setInt("P_REF_STEP_ID", refStepId);
			cstmt.registerOutParameter("P_CAPTURED_VALUE", java.sql.Types.VARCHAR);
			cstmt.execute();
			capturedValue=cstmt.getString("P_CAPTURED_VALUE");
		}
		catch (SQLException sqle){
			log.error("SQLException while fecthing the data. Exception message is" ,sqle);
		}
		finally{
			close(cstmt, conn);
		}
		log.info("Captured Value is "+ capturedValue);
		
		return capturedValue;
	}

	@Override
	public void insertStepStatus(int testCaseId, int flowId, int stepId, String status) {
		// TODO Auto-generated method stub
		
		log.info(" Test Case ID :"+ testCaseId + "Flow ID" + flowId + " Step ID :" + stepId + " status :" + status );
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		CallableStatement cstmt = null;
		String query = "{ call QA_PKG.INSERT_STEP_RESULT( :P_THREAD_ID, P_TEST_CASE_ID, :P_FLOW_ID, :P_STEP_ID , :P_STATUS )}";
		
		
		try{
			cstmt = conn.prepareCall(query);
			cstmt.setString("P_THREAD_ID", Thread.currentThread().getName());
			cstmt.setInt("P_TEST_CASE_ID", testCaseId);
			cstmt.setInt("P_FLOW_ID", flowId);
			cstmt.setInt("P_STEP_ID", stepId);
			cstmt.setString("P_STATUS", status);
			cstmt.execute();
			
		}
		catch (SQLException sqle){
			log.error("SQLException while fecthing the data. Exception message is" ,sqle);
		}
		finally{
			close(cstmt, conn);
		}
		
	
		
	}

	/* (non-Javadoc)
	 * @see com.vzw.prepaid.dao.ProcessorDAO#insertErrorLog(java.lang.String, java.lang.String, java.io.FileInputStream)
	 */
	/* (non-Javadoc)
	 * @see com.vzw.prepaid.dao.ProcessorDAO#insertErrorLog(java.lang.String, java.lang.String, java.io.FileInputStream)
	 */
	@Override
	public void insertErrorLog(String threadId, String errorLog, FileInputStream fis) throws IOException {
		// TODO Auto-generated method stub
		log.info(" Inside insertErrorLog(). Input parameters is threadId:" + threadId );
		Connection conn = this.getConnection(DatasourceConfigurator.ds);
		PreparedStatement pstmt = null;
		String query = "{ call QA_PKG.INSERT_FAILURE(? , ? , ? )}";
		
		
		try{
			pstmt = conn.prepareCall(query);
			pstmt.setString(1, Thread.currentThread().getName());
			pstmt.setString(2, errorLog);
			pstmt.setBinaryStream(3,fis, fis.available());
			pstmt.execute();
			
		}
		catch (SQLException sqle){
			log.error("SQLException while fecthing the data. Exception message is" ,sqle);
		}
		finally{
			close(pstmt, conn);
		}
		
		
		
	}
	

	
	
	
			
}
