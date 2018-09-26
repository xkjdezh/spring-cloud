package com.bichuang.vo.account;

import java.math.BigDecimal;

/**
 * 申请提现请求参数模型
 * 
 * @author meidf
 *
 */
public class WithdrawApplyReqVO {
	
	private String custId;

	private String bizOrderNo;
	
	private String orderNo;

	private String bizUserId;

	private String accountSetNo;

	private BigDecimal amount;

	private String fee;

	private String backUrl;

	private String payMethod;

	private String bankCardNo;
	
	private String verificationCode;
	
	private String consumerIp;

	/*
	 * 0：个人银行卡 1：企业对公账户 如果不传默认为 0
	 */
	private String bankCardPro;

	private String industryCode;

	private String industryName;

	private String source;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getBizOrderNo() {
		return bizOrderNo;
	}

	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	public String getBizUserId() {
		return bizUserId;
	}

	public void setBizUserId(String bizUserId) {
		this.bizUserId = bizUserId;
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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getConsumerIp() {
		return consumerIp;
	}

	public void setConsumerIp(String consumerIp) {
		this.consumerIp = consumerIp;
	}

	public String getBankCardPro() {
		return bankCardPro;
	}

	public void setBankCardPro(String bankCardPro) {
		this.bankCardPro = bankCardPro;
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
