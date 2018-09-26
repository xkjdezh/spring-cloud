package com.bichuang.repository.model.account;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceAccountBInner extends BaseEntity {
    private Integer id;

    private Integer parentId;

    private Integer userId;

    private String companyName;

    private String enterpriseQualificationNo;

    private String cardNo;

    private Long amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getEnterpriseQualificationNo() {
        return enterpriseQualificationNo;
    }

    public void setEnterpriseQualificationNo(String enterpriseQualificationNo) {
        this.enterpriseQualificationNo = enterpriseQualificationNo == null ? null : enterpriseQualificationNo.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}