package com.bichuang.repository.model.account;

import java.math.BigDecimal;
import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceAccountC extends BaseEntity {
    private Integer id;

    private String custId;

    private String custName;
    
    private String phone;

	private String loginPwd;

    private String payPwd;
    
    private String bizUserId;

    private Integer identityType;

    private String identityNo;

    private BigDecimal amount;

    private BigDecimal cashAmount;

    private BigDecimal uncashAmount;

    private BigDecimal freezeCashAmount;

    private BigDecimal freezeUncashAmount;

    private String property;

    private String status;

    private Date createTime;

    private BigDecimal interestBase;

    private Date lasttermInterestDat;

    private Date lastupdateTime;

    private BigDecimal lasttermAmount;

    private String checkValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd == null ? null : payPwd.trim();
    }

    public String getBizUserId() {
		return bizUserId;
	}

	public void setBizUserId(String bizUserId) {
		this.bizUserId = bizUserId;
	}

	public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getUncashAmount() {
        return uncashAmount;
    }

    public void setUncashAmount(BigDecimal uncashAmount) {
        this.uncashAmount = uncashAmount;
    }

    public BigDecimal getFreezeCashAmount() {
        return freezeCashAmount;
    }

    public void setFreezeCashAmount(BigDecimal freezeCashAmount) {
        this.freezeCashAmount = freezeCashAmount;
    }

    public BigDecimal getFreezeUncashAmount() {
        return freezeUncashAmount;
    }

    public void setFreezeUncashAmount(BigDecimal freezeUncashAmount) {
        this.freezeUncashAmount = freezeUncashAmount;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getInterestBase() {
        return interestBase;
    }

    public void setInterestBase(BigDecimal interestBase) {
        this.interestBase = interestBase;
    }

    public Date getLasttermInterestDat() {
        return lasttermInterestDat;
    }

    public void setLasttermInterestDat(Date lasttermInterestDat) {
        this.lasttermInterestDat = lasttermInterestDat;
    }

    public Date getLastupdateTime() {
        return lastupdateTime;
    }

    public void setLastupdateTime(Date lastupdateTime) {
        this.lastupdateTime = lastupdateTime;
    }

    public BigDecimal getLasttermAmount() {
        return lasttermAmount;
    }

    public void setLasttermAmount(BigDecimal lasttermAmount) {
        this.lasttermAmount = lasttermAmount;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue == null ? null : checkValue.trim();
    }
}