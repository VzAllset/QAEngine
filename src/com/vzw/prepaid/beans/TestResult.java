package com.vzw.prepaid.beans;

public class TestResult 
{
	private int testResultId;
	private String testResultDesc;
	private String status;
	private String action;
	private Object object;
	private Data data;
	public int getTestResultId() {
		return testResultId;
	}
	public void setTestResultId(int testResultId) {
		this.testResultId = testResultId;
	}
	public String getTestResultDesc() {
		return testResultDesc;
	}
	public void setTestResultDesc(String testResultDesc) {
		this.testResultDesc = testResultDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "TestResult [testResultId=" + testResultId + ", testResultDesc="
				+ testResultDesc + ", status=" + status + ", action=" + action
				+ ", object=" + object + ", data=" + data + "]";
	}
	
	
}

