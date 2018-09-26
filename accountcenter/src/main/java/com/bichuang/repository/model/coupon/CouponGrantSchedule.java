package com.bichuang.repository.model.coupon;

import java.math.BigDecimal;
import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class CouponGrantSchedule extends BaseEntity {
    private String couponId;

    private String couponName;

    private String couponType;

    private BigDecimal discountValue;

    private BigDecimal cashValue;

    private BigDecimal thresholdValue;

    private String grantUsergroup;

    private Integer grantCurrentSum = 0;

    private Integer grantSum = 0;

    private Integer grantType;

    private Integer grantStatus = 0;

    private Integer limitcollarSum;

    private Date grantStartDate;

    private Date grantEndDate;

    private Integer termType;

    private Date fixedStartDate;

    private Date fixedEndDate;

    private Integer dynamicDate;

    private String scopeMarketId;

    private String scopeMarketShopId;

    private String createUserName;

    private Date creatDate;

    private String remark;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getCashValue() {
        return cashValue;
    }

    public void setCashValue(BigDecimal cashValue) {
        this.cashValue = cashValue;
    }

    public BigDecimal getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(BigDecimal thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getGrantUsergroup() {
        return grantUsergroup;
    }

    public void setGrantUsergroup(String grantUsergroup) {
        this.grantUsergroup = grantUsergroup == null ? null : grantUsergroup.trim();
    }

    public Integer getGrantCurrentSum() {
        return grantCurrentSum;
    }

    public void setGrantCurrentSum(Integer grantCurrentSum) {
        this.grantCurrentSum = grantCurrentSum;
    }

    public Integer getGrantSum() {
        return grantSum;
    }

    public void setGrantSum(Integer grantSum) {
        this.grantSum = grantSum;
    }

    public Integer getGrantType() {
        return grantType;
    }

    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    public Integer getGrantStatus() {
        return grantStatus;
    }

    public void setGrantStatus(Integer grantStatus) {
        this.grantStatus = grantStatus;
    }

    public Integer getLimitcollarSum() {
        return limitcollarSum;
    }

    public void setLimitcollarSum(Integer limitcollarSum) {
        this.limitcollarSum = limitcollarSum;
    }

    public Date getGrantStartDate() {
        return grantStartDate;
    }

    public void setGrantStartDate(Date grantStartDate) {
        this.grantStartDate = grantStartDate;
    }

    public Date getGrantEndDate() {
        return grantEndDate;
    }

    public void setGrantEndDate(Date grantEndDate) {
        this.grantEndDate = grantEndDate;
    }

    public Integer getTermType() {
        return termType;
    }

    public void setTermType(Integer termType) {
        this.termType = termType;
    }

    public Date getFixedStartDate() {
        return fixedStartDate;
    }

    public void setFixedStartDate(Date fixedStartDate) {
        this.fixedStartDate = fixedStartDate;
    }

    public Date getFixedEndDate() {
        return fixedEndDate;
    }

    public void setFixedEndDate(Date fixedEndDate) {
        this.fixedEndDate = fixedEndDate;
    }

    public Integer getDynamicDate() {
        return dynamicDate;
    }

    public void setDynamicDate(Integer dynamicDate) {
        this.dynamicDate = dynamicDate;
    }

    public String getScopeMarketId() {
        return scopeMarketId;
    }

    public void setScopeMarketId(String scopeMarketId) {
        this.scopeMarketId = scopeMarketId == null ? null : scopeMarketId.trim();
    }

    public String getScopeMarketShopId() {
        return scopeMarketShopId;
    }

    public void setScopeMarketShopId(String scopeMarketShopId) {
        this.scopeMarketShopId = scopeMarketShopId == null ? null : scopeMarketShopId.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}