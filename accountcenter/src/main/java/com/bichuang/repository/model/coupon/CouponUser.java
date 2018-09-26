package com.bichuang.repository.model.coupon;

import java.math.BigDecimal;
import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class CouponUser extends BaseEntity {
    private String couponLineNumber;

    private String couponId;

    private String userId;

    private String couponName;

    private String couponType;

    private Date couponEffectiveStartData;

    private Date couponEffectiveEndData;

    private String scopeMarketId;

    private String scopeMarketShopId;

    private Integer couponStatus;

    private String merchantId;

    private BigDecimal fullAmount;

    private BigDecimal couponAmount;

    private BigDecimal payAmount;

    private Date useDate;

    public String getCouponLineNumber() {
        return couponLineNumber;
    }

    public void setCouponLineNumber(String couponLineNumber) {
        this.couponLineNumber = couponLineNumber == null ? null : couponLineNumber.trim();
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Date getCouponEffectiveStartData() {
        return couponEffectiveStartData;
    }

    public void setCouponEffectiveStartData(Date couponEffectiveStartData) {
        this.couponEffectiveStartData = couponEffectiveStartData;
    }

    public Date getCouponEffectiveEndData() {
        return couponEffectiveEndData;
    }

    public void setCouponEffectiveEndData(Date couponEffectiveEndData) {
        this.couponEffectiveEndData = couponEffectiveEndData;
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

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public BigDecimal getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(BigDecimal fullAmount) {
        this.fullAmount = fullAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }
}