package com.neusoft.vo;

import java.sql.Date;

public class InterSettle {
	private int id;
	private String interSettleId;//返回网间结算收入的流水号
	private Date yearMonth;//返回网间结算收入录入的年月
	private String cityCode;//返回网间结算收入的城市编码
	private String cityName;
	private String productCode;//返回网间结算收入的产品类型编码
	private String productName;
	private String balanceSpCode;//返回网间结算收入的结算运营商编码
	private String balanceSpName;
	private String balanceTypeCode;
	private String balanceTypeName;
	private String settleType;
	private double amount;//返回网间结算收入的录入金额
	private String selectAuditStatus;//返回网间结算收入的查询状态
	private Date timeSpan;//返回网间结算收入的查询时间段
	private String recordOperator;//录入人员
	private String checkStatus;
	
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
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
	public String getRecordOperator() {
		return recordOperator;
	}
	public void setRecordOperator(String recordOperator) {
		this.recordOperator = recordOperator;
	}
	
	public String getInterSettleId() {
		return interSettleId;
	}
	public void setInterSettleId(String interSettleId) {
		this.interSettleId = interSettleId;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getSettleType() {
		return settleType;
	}
	public void setSettleType(String settleType) {
		this.settleType = settleType;
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
	public String getBalanceSpCode() {
		return balanceSpCode;
	}
	public void setBalanceSpCode(String balanceSpCode) {
		this.balanceSpCode = balanceSpCode;
	}
	public String getBalanceSpName() {
		return balanceSpName;
	}
	public void setBalanceSpName(String balanceSpName) {
		this.balanceSpName = balanceSpName;
	}
	public String getBalanceTypeCode() {
		return balanceTypeCode;
	}
	public void setBalanceTypeCode(String balanceTypeCode) {
		this.balanceTypeCode = balanceTypeCode;
	}
	public String getBalanceTypeName() {
		return balanceTypeName;
	}
	public void setBalanceTypeName(String balanceTypeName) {
		this.balanceTypeName = balanceTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
