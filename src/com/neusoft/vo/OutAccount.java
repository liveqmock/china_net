package com.neusoft.vo;

import java.sql.Date;

public class OutAccount {
	private int id;
	private String outAccountId;//出账收入的流水号
	private Date yearMonth;//出账收入录入的年月
	private String cityName;//出账收入的城市名称
	private String cityCode;//出账收入的城市
	private String productName;//出账收入的产品类型
	private String productTypeCode;//出账收入的产品类型编码
	private String outAccountTypeName;//出账收入的出账类型
	private String outAccountTypeCode;//出账收入的出账类型编码
	private double amount;//出账收入的录入金额
	private String selectAuditStatus;//出账收入的查询状态,是否稽查
	private Date timeSpan;//出账收入的查询时间段??????????
	private String recordOperator;//录入人员
	
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
