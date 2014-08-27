package com.neusoft.vo;

import java.sql.Date;

public class CardSale {		//������ʵ����
	
	private String cardSaleId;			//�������������ˮ��
	private Date yearMonth;				//����������¼�������
	private String cityCode;			//����������ĳ��б���
	private String cityName;			//����������ĳ�������
	private String productCode;			//����������Ĳ�Ʒ���ͱ���
	private String productName;			//����������Ĳ�Ʒ���ͱ���
	private String cardSaleType;		//����������ĳ������ͱ���
	private double amount;				//����������Ŀ�����
	private double discountRate;		//������������ۿ���
	private double parValue;			//����������ĵ�����ֵ
	private double discountFee;			//������������ۿۺ���
	private double discount;			//������������ۿ۽��
	private double totalFee;			//����������Ŀ��ܽ��
	private String selectAuditStatus;	//����������Ļ���״̬
	private String recordOperator;		//�����������¼����Ա
	private Date timeSpan;				//����������Ĳ�ѯʱ���
	
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
