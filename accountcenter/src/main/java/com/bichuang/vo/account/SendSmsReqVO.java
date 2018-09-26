package com.bichuang.vo.account;

/**
 * 开户接口请求参数模型
 * 
 * @author meidf
 * @version 2018年3月22日
 * @see SendSmsReqVO
 * @since
 */
public class SendSmsReqVO {

	private String custId;

	private String phone;

	private int verificationCodeType;

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

	public int getVerificationCodeType() {
		return verificationCodeType;
	}

	public void setVerificationCodeType(int verificationCodeType) {
		this.verificationCodeType = verificationCodeType;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

}
