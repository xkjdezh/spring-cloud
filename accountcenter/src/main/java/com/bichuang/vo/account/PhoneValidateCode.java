package com.bichuang.vo.account;

import java.io.Serializable;

public class PhoneValidateCode  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***商户系统用户标识***/
    private String bizUserId;
    /***验证码类型 ***/
    private Long verificationCodeType;
    /***手机号码 ***/
    private String phone ;

    public String getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(String bizUserId) {
        this.bizUserId = bizUserId;
    }

    public Long getVerificationCodeType() {
        return verificationCodeType;
    }

    public void setVerificationCodeType(Long verificationCodeType) {
        this.verificationCodeType = verificationCodeType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
