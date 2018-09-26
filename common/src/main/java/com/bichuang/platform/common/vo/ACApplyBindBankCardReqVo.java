package com.bichuang.platform.common.vo;

/**
 * 请求绑定银行卡VO
 * @author zhangzebiao
 *
 */
public class ACApplyBindBankCardReqVo {
	//客户标识
	private String custId;
	//银行卡号
	private String cardNo;
	//银行预留手机号
	private String phone;
	//姓名
	private String name;
	//证件类型
	private String identityType;
	//证件号码
	private String identityNo;

	/*
	 * 绑卡方式
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
