package com.bichuang.vo.account;

public class ApplyBindBankCardReqVO {
	private String custId;

	private String cardNo;

	private String phone;

	private String name;

	private String identityType;

	private String identityNo;

	/*
	 * （不传则默认值 2
	 */
	private int cardCheck;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public int getCardCheck() {
		return cardCheck;
	}

	public void setCardCheck(int cardCheck) {
		this.cardCheck = cardCheck;
	}

}
