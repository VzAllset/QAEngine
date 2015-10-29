package com.vzw.prepaid.beans;

public class Object 
{
	private int objectId;
	private String objectName;
	private String objectXPath;
	private String objectDesc;
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getObjectXPath() {
		return objectXPath;
	}
	public void setObjectXPath(String objectXPath) {
		this.objectXPath = objectXPath;
	}
	public String getObjectDesc() {
		return objectDesc;
	}
	public void setObjectDesc(String objectDesc) {
		this.objectDesc = objectDesc;
	}
	@Override
	public String toString() {
		return "Object [objectId=" + objectId + ", objectName=" + objectName
				+ ", objectXPath=" + objectXPath + ", objectDesc=" + objectDesc
				+ "]";
	}
	
	
}
