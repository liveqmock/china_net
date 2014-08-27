package com.neusoft.vo;

import java.sql.Date;

public class Notice {
	private Long NoticeId;
	private Date yearMonth;
	private String cityCode;
	private String productCode;
	private String NoticeType;
	private Float amount;
	private String selectAuditStatus;
	private Date timeSpan;
	public Long getNoticeId() {
		return NoticeId;
	}
	public void setNoticeId(Long noticeId) {
		NoticeId = noticeId;
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
	public String getNoticeType() {
		return NoticeType;
	}
	public void setNoticeType(String noticeType) {
		NoticeType = noticeType;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
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
	

}
