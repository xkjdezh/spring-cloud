package com.bichuang.repository.model.account;

import java.math.BigDecimal;
import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceRechargeBillC extends BaseEntity {
    private Integer id;

    private String custId;

    private Integer subaccountType;

    private String custName;

    private Integer rechargeType;

    private BigDecimal rechargeAmount;

    private Date createTime;

    private String custBy;

    private String bankType;

    private Boolean bankCode;

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

    public Integer getSubaccountType() {
        return subaccountType;
    }

    public void setSubaccountType(Integer subaccountType) {
        this.subaccountType = subaccountType;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Integer getRechargeType() {
        return rechargeType;
    }

    public void setRechargeType(Integer rechargeType) {
        this.rechargeType = rechargeType;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCustBy() {
        return custBy;
    }

    public void setCustBy(String custBy) {
        this.custBy = custBy == null ? null : custBy.trim();
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    public Boolean getBankCode() {
        return bankCode;
    }

    public void setBankCode(Boolean bankCode) {
        this.bankCode = bankCode;
    }
}