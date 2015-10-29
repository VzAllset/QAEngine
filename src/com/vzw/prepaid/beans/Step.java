package com.vzw.prepaid.beans;

public class Step 
{
	private int stepId;
	private String stepName;
	private String action;
	private String stepDesc;
	private Object object;
	private Data data;
	private int executionSequence;
	private int refFlowId;
	private int refStepId;
	private String refKey;
	public int getStepId() {
		return stepId;
	}
	public void setStepId(int stepId) {
		this.stepId = stepId;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getStepDesc() {
		return stepDesc;
	}
	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
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
	public int getExecutionSequence() {
		return executionSequence;
	}
	public void setExecutionSequence(int executionSequence) {
		this.executionSequence = executionSequence;
	}
	public int getRefFlowId() {
		return refFlowId;
	}
	public void setRefFlowId(int refFlowId) {
		this.refFlowId = refFlowId;
	}
	public int getRefStepId() {
		return refStepId;
	}
	public void setRefStepId(int refStepId) {
		this.refStepId = refStepId;
	}
	public String getRefKey() {
		return refKey;
	}
	public void setRefKey(String refKey) {
		this.refKey = refKey;
	}
	@Override
	public String toString() {
		return "Step [stepId=" + stepId + ", stepName=" + stepName
				+ ", action=" + action + ", stepDesc=" + stepDesc + ", object="
				+ object + ", data=" + data + ", executionSequence="
				+ executionSequence + ", refFlowId=" + refFlowId
				+ ", refStepId=" + refStepId + ", refKey=" + refKey + "]";
	}
	
	
	
	
}

