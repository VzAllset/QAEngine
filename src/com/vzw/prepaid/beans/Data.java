package com.vzw.prepaid.beans;

public class Data 
{
	private int dataId;
	private String dataName;
	private String dataValue;
	private String dataDesc;
	public int getDataId() {
		return dataId;
	}
	public void setDataId(int dataId) {
		this.dataId = dataId;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getDataDesc() {
		return dataDesc;
	}
	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}
	@Override
	public String toString() {
		return "Data [dataId=" + dataId + ", dataName=" + dataName
				+ ", dataValue=" + dataValue + ", dataDesc=" + dataDesc + "]";
	}
	
	
}
