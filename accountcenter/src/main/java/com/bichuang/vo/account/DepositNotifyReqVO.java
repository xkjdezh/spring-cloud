package com.bichuang.vo.account;

import java.math.BigDecimal;

/**
 * 充值请求参数模型
 * 
 * @author meidf
 *
 */
public class DepositNotifyReqVO {

	private String bizOrderNo;
	
	private String orderNo;
	
	private String bizUserId;

	private String custId;

	private String accountSetNo;

	private BigDecimal amount;
	
	private int type;

	private String fee;

	private String backUrl;
	
	private String frontUrl;
	
	private String ordErexpireDatetime;

	private String payMethod;

	/*
	 * 非贷记卡： W02 借、贷卡： W01
	 */

	private String payType;
	
	private String industryCode;

	private String industryName;

	private String source;

	public String getBizOrderNo() {
		return bizOrderNo;
	}

	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBizUserId() {
		return bizUserId;
	}

	public void setBizUserId(String bizUserId) {
		this.bizUserId = bizUserId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAccountSetNo() {
		return accountSetNo;
	}

	public void setAccountSetNo(String accountSetNo) {
		this.accountSetNo = accountSetNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public String getFrontUrl() {
		return frontUrl;
	}

	public void setFrontUrl(String frontUrl) {
		this.frontUrl = frontUrl;
	}

	public String getOrdErexpireDatetime() {
		return ordErexpireDatetime;
	}

	public void setOrdErexpireDatetime(String ordErexpireDatetime) {
		this.ordErexpireDatetime = ordErexpireDatetime;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
