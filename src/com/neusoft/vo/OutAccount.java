package com.neusoft.vo;

import java.sql.Date;

public class OutAccount {
	private int id;
	private String outAccountId;//�����������ˮ��
	private Date yearMonth;//��������¼�������
	private String cityName;//��������ĳ�������
	private String cityCode;//��������ĳ���
	private String productName;//��������Ĳ�Ʒ����
	private String productTypeCode;//��������Ĳ�Ʒ���ͱ���
	private String outAccountTypeName;//��������ĳ�������
	private String outAccountTypeCode;//��������ĳ������ͱ���
	private double amount;//���������¼����
	private String selectAuditStatus;//��������Ĳ�ѯ״̬,�Ƿ����
	private Date timeSpan;//��������Ĳ�ѯʱ���??????????
	private String recordOperator;//¼����Ա
	
	public String getOutAccountId() {
		return outAccountId;
	}
	public void setOutAccountId(String outAccountId) {
		this.outAccountId = outAccountId;
	}
	public Date getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getOutAccountTypeCode() {
		return outAccountTypeCode;
	}
	public void setOutAccountTypeCode(String outAccountTypeCode) {
		this.outAccountTypeCode = outAccountTypeCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getOutAccountTypeName() {
		return outAccountTypeName;
	}
	public void setOutAccountTypeName(String outAccountTypeName) {
		this.outAccountTypeName = outAccountTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
