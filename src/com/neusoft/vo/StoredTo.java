package com.neusoft.vo;

import java.sql.Date;

public class StoredTo {
	private String storedToId; //��ˮ��
	private Date yearMonth;//��������¼�������
	private String cityName;//��������ĳ�������
	private String cityCode; //��������ĳ���
	private String productName;//��������Ĳ�Ʒ����
	private String productTypeCode;//��������Ĳ�Ʒ���ͱ���
	private String storedToTypeName;
	private String storedToTypeCode;
	private double amount; //¼����
	private String selectAuditStatus;
	private Date timeSpan;
	private String recordOperator;//¼����Ա


	public String getStoredToId() {
		return storedToId;
	}
	public void setStoredToId(String storedToId) {
		this.storedToId = storedToId;
	}
	public Date getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getProductTypeCode() {
		return productTypeCode;
	}
	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getSelectAuditStatus() {
		return selectAuditStatus;
	}
	public void setSelectAuditStatus(String selectAuditStatus) {
		this.selectAuditStatus = selectAuditStatus;
	}
	public Date getTimeSpan() {
		return timeSpan;
	}
	public void setTimeSpan(Date timeSpan) {
		this.timeSpan = timeSpan;
	}
	public String getRecordOperator() {
		return recordOperator;
	}
	public void setRecordOperator(String recordOperator) {
		this.recordOperator = recordOperator;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getStoredToTypeName() {
		return storedToTypeName;
	}
	public void setStoredToTypeName(String storedToTypeName) {
		this.storedToTypeName = storedToTypeName;
	}
	public String getStoredToTypeCode() {
		return storedToTypeCode;
	}
	public void setStoredToTypeCode(String storedToTypeCode) {
		this.storedToTypeCode = storedToTypeCode;
	}

	

	

}
