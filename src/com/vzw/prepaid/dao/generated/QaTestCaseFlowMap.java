// default package
package com.vzw.prepaid.dao.generated;
// Generated Mar 1, 2016 4:05:52 PM by Hibernate Tools 4.3.1.Final

/**
 * QaTestCaseFlowMap generated by hbm2java
 */
public class QaTestCaseFlowMap implements java.io.Serializable {

	private long testCaseFlowMapId;
	private QaFlow qaFlow;
	private QaTestCase qaTestCase;
	private String mappingDesc;
	private long execSequence;
	private Long depFlow;

	public QaTestCaseFlowMap() {
	}

	public QaTestCaseFlowMap(long testCaseFlowMapId, QaFlow qaFlow, QaTestCase qaTestCase, long execSequence) {
		this.testCaseFlowMapId = testCaseFlowMapId;
		this.qaFlow = qaFlow;
		this.qaTestCase = qaTestCase;
		this.execSequence = execSequence;
	}

	public QaTestCaseFlowMap(long testCaseFlowMapId, QaFlow qaFlow, QaTestCase qaTestCase, String mappingDesc,
			long execSequence, Long depFlow) {
		this.testCaseFlowMapId = testCaseFlowMapId;
		this.qaFlow = qaFlow;
		this.qaTestCase = qaTestCase;
		this.mappingDesc = mappingDesc;
		this.execSequence = execSequence;
		this.depFlow = depFlow;
	}

	public long getTestCaseFlowMapId() {
		return this.testCaseFlowMapId;
	}

	public void setTestCaseFlowMapId(long testCaseFlowMapId) {
		this.testCaseFlowMapId = testCaseFlowMapId;
	}

	public QaFlow getQaFlow() {
		return this.qaFlow;
	}

	public void setQaFlow(QaFlow qaFlow) {
		this.qaFlow = qaFlow;
	}

	public QaTestCase getQaTestCase() {
		return this.qaTestCase;
	}

	public void setQaTestCase(QaTestCase qaTestCase) {
		this.qaTestCase = qaTestCase;
	}

	public String getMappingDesc() {
		return this.mappingDesc;
	}

	public void setMappingDesc(String mappingDesc) {
		this.mappingDesc = mappingDesc;
	}

	public long getExecSequence() {
		return this.execSequence;
	}

	public void setExecSequence(long execSequence) {
		this.execSequence = execSequence;
	}

	public Long getDepFlow() {
		return this.depFlow;
	}

	public void setDepFlow(Long depFlow) {
		this.depFlow = depFlow;
	}

	@Override
	public String toString() {
		return "QaTestCaseFlowMap [testCaseFlowMapId=" + testCaseFlowMapId + ", qaFlow=" + qaFlow + ", mappingDesc="
				+ mappingDesc + ", execSequence=" + execSequence + ", depFlow=" + depFlow + "]";
	}


}
