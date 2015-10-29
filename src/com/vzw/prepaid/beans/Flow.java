package com.vzw.prepaid.beans;

import java.util.List;

public class Flow 
{
	List<Step> steps;
	String flowDesc;
	int flowId;
	int executionSequence;
	public List<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	public String getFlowDesc() {
		return flowDesc;
	}
	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc;
	}
	public int getFlowId() {
		return flowId;
	}
	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}
	public int getExecutionSequence() {
		return executionSequence;
	}
	public void setExecutionSequence(int executionSequence) {
		this.executionSequence = executionSequence;
	}
	@Override
	public String toString() {
		return "Flow [flowDesc=" + flowDesc + ", flowId=" + flowId
				+ ", executionSequence=" + executionSequence + "]";
	}
	
	
}
