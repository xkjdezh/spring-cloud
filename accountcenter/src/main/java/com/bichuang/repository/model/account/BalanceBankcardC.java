package com.bichuang.repository.model.account;

import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceBankcardC extends BaseEntity {
    private Integer id;

    private String bankCardno;

    private String bankName;

    private Date bindTime;

    private Integer cardType;

    private Integer bindState;

    private String phone;

    private Boolean isSafeCard;

    private Boolean isVerifyPaychecked;

    private Boolean isQuickPaycard;

    private Integer bindMethod;

    private String custId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCardno() {
        return bankCardno;
    }

    public void setBankCardno(String bankCardno) {
        this.bankCardno = bankCardno == null ? null : bankCardno.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getBindState() {
        return bindState;
    }

    public void setBindState(Integer bindState) {
        this.bindState = bindState;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getIsSafeCard() {
        return isSafeCard;
    }

    public void setIsSafeCard(Boolean isSafeCard) {
        this.isSafeCard = isSafeCard;
    }

    public Boolean getIsVerifyPaychecked() {
        return isVerifyPaychecked;
    }

    public void setIsVerifyPaychecked(Boolean isVerifyPaychecked) {
        this.isVerifyPaychecked = isVerifyPaychecked;
    }

    public Boolean getIsQuickPaycard() {
        return isQuickPaycard;
    }

    public void setIsQuickPaycard(Boolean isQuickPaycard) {
        this.isQuickPaycard = isQuickPaycard;
    }

    public Integer getBindMethod() {
        return bindMethod;
    }

    public void setBindMethod(Integer bindMethod) {
        this.bindMethod = bindMethod;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }
}