package com.vzw.prepaid.dao.generated;

import java.util.HashSet;
import java.util.Set;

/**
 * Application generated by hbm2java
 */
public class Application implements java.io.Serializable {

	private long applicationId;
	private String applicationName;
	private String applicationUrl;
	private Set<QaTestSuite> qaTestSuites = new HashSet<QaTestSuite>(0);

	public Application() {
	}

	public Application(long applicationId) {
		this.applicationId = applicationId;
	}

	public Application(long applicationId, String applicationName, String applicationUrl, Set<QaTestSuite> qaTestSuites) {
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.applicationUrl = applicationUrl;
		this.qaTestSuites = qaTestSuites;
	}

	public long getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationUrl() {
		return this.applicationUrl;
	}

	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	public Set<QaTestSuite> getQaTestSuites() {
		return this.qaTestSuites;
	}

	public void setQaTestSuites(Set<QaTestSuite> qaTestSuites) {
		this.qaTestSuites = qaTestSuites;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicationName=" + applicationName
				+ ", applicationUrl=" + applicationUrl + "]";
	}

}
