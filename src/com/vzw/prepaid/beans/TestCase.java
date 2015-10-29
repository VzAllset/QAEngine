package com.vzw.prepaid.beans;

import java.util.Date;
import java.util.List;

public class TestCase 
{
	int testCaseId;
	String testCaseName;
	String testCaseDesc;
	Date createdDate;
	Date lastUpdatedDate;
	String createdUserId;
	String lastUpdateUserId;
	List<Flow> flows;
	public int getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(int testCaseId) {
		this.testCaseId = testCaseId;
	}
	
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getTestCaseDesc() {
		return testCaseDesc;
	}
	public void setTestCaseDesc(String testCaseDesc) {
		this.testCaseDesc = testCaseDesc;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	
	public List<Flow> getFlows() {
		return flows;
	}
	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}
	@Override
	public String toString() {
		return "TestCase [testCaseId=" + testCaseId + ", testCaseName="
				+ testCaseName + ", testCaseDesc=" + testCaseDesc
				+ ", createdDate=" + createdDate + ", lastUpdatedDate="
				+ lastUpdatedDate + ", createdUserId=" + createdUserId
				+ ", lastUpdateUserId=" + lastUpdateUserId + ", flows=" + flows
				+ "]";
	}
	
	
}
