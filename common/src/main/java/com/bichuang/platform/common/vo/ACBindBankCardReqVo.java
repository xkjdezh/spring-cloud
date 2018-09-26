package com.bichuang.platform.common.vo;

import org.hibernate.validator.constraints.NotBlank;

public class ACBindBankCardReqVo {
	
	private String custId;
	@NotBlank
	private String phone;
	
	private String  transDate;
	@NotBlank
	private String tranceNum;
	
	private String cardNo;
	
	private String bankName;
	
	private String bankCode;
	
	private int cardType;
	@NotBlank
	private String verificationCode;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTranceNum() {
		return tranceNum;
	}

	public void setTranceNum(String tranceNum) {
		this.tranceNum = tranceNum;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	
}
