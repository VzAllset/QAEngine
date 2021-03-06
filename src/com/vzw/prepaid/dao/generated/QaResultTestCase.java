// default package
package com.vzw.prepaid.dao.generated;
// Generated Mar 1, 2016 4:05:52 PM by Hibernate Tools 4.3.1.Final

/**
 * QaResultTestCase generated by hbm2java
 */
public class QaResultTestCase implements java.io.Serializable {

	private Integer resultTestCaseId;
	private QaFlow qaFlow;
	private QaStep qaStep;
	private QaTestCase qaTestCase;
	private String threadId;
	private String status;

	public QaResultTestCase() {
	}

	public QaResultTestCase(QaFlow qaFlow, QaStep qaStep, QaTestCase qaTestCase, String threadId) {
		this.qaFlow = qaFlow;
		this.qaStep = qaStep;
		this.qaTestCase = qaTestCase;
		this.threadId = threadId;
	}

	public QaResultTestCase(QaFlow qaFlow, QaStep qaStep, QaTestCase qaTestCase, String threadId, String status) {
		this.qaFlow = qaFlow;
		this.qaStep = qaStep;
		this.qaTestCase = qaTestCase;
		this.threadId = threadId;
		this.status = status;
	}

	public Integer getResultTestCaseId() {
		return this.resultTestCaseId;
	}

	public void setResultTestCaseId(Integer resultTestCaseId) {
		this.resultTestCaseId = resultTestCaseId;
	}

	public QaFlow getQaFlow() {
		return this.qaFlow;
	}

	public void setQaFlow(QaFlow qaFlow) {
		this.qaFlow = qaFlow;
	}

	public QaStep getQaStep() {
		return this.qaStep;
	}

	public void setQaStep(QaStep qaStep) {
		this.qaStep = qaStep;
	}

	public QaTestCase getQaTestCase() {
		return this.qaTestCase;
	}

	public void setQaTestCase(QaTestCase qaTestCase) {
		this.qaTestCase = qaTestCase;
	}

	public String getThreadId() {
		return this.threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
