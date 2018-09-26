package com.bichuang.vo.account;

import java.io.Serializable;

public class YunAccountResponse<T>  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  status;

    private T signedValue;

    private String sign;

    private String errorCode;

    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getSignedValue() {
        return signedValue;
    }

    public void setSignedValue(T signedValue) {
        this.signedValue = signedValue;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
