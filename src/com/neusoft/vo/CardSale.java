package com.neusoft.vo;

import java.sql.Date;

public class CardSale {		//卡销售实体类
	
	private String cardSaleId;			//卡销售收入的流水号
	private Date yearMonth;				//卡销售收入录入的年月
	private String cityCode;			//卡销售收入的城市编码
	private String cityName;			//卡销售收入的城市名称
	private String productCode;			//卡销售收入的产品类型编码
	private String productName;			//卡销售收入的产品类型编码
	private String cardSaleType;		//卡销售收入的出账类型编码
	private double amount;				//卡销售收入的卡数量
	private double discountRate;		//卡销售收入的折扣率
	private double parValue;			//卡销售收入的单张面值
	private double discountFee;			//卡销售收入的折扣后金额
	private double discount;			//卡销售收入的折扣金额
	private double totalFee;			//卡销售收入的卡总金额
	private String selectAuditStatus;	//卡销售收入的稽核状态
	private String recordOperator;		//卡销售收入的录入人员
	private Date timeSpan;				//卡销售收入的查询时间段
	
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
	public String getCardSaleId() {
		return cardSaleId;
	}
	public void setCardSaleId(String cardSaleId) {
		this.cardSaleId = cardSaleId;
	}
	public String getCardSaleType() {
		return cardSaleType;
	}
	public void setCardSaleType(String cardSaleType) {
		this.cardSaleType = cardSaleType;
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
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	public double getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(double discountFee) {
		this.discountFee = discountFee;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
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
	

}
