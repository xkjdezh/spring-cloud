package com.bichuang.repository.model.account;

import java.math.BigDecimal;
import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceAccountCChangeSeq extends BaseEntity {
    private Integer id;

    private String sn;

    private Integer accountId;

    private String custId;
    
    private String accountType;

    private String custName;

    private String seqFlag;

    private String changeType;

    private BigDecimal preamount;

    private BigDecimal amount;

    private BigDecimal cashAmount;

    private BigDecimal uncashAmount;

    private BigDecimal freezeCashAmout;

    private BigDecimal freezeUncashAmount;

    private String refSn;

    private String refBatchId;

    private String orderId;

    private Integer orderStatus;

    private Date backTime;

    private Date createTime;

    private String note;

    private String workDate;
    
    private String startTimeStr;
    
    private String endTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getSeqFlag() {
        return seqFlag;
    }

    public void setSeqFlag(String seqFlag) {
        this.seqFlag = seqFlag == null ? null : seqFlag.trim();
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
    }

    public BigDecimal getPreamount() {
        return preamount;
    }

    public void setPreamount(BigDecimal preamount) {
        this.preamount = preamount;
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

    public BigDecimal getFreezeCashAmout() {
        return freezeCashAmout;
    }

    public void setFreezeCashAmout(BigDecimal freezeCashAmout) {
        this.freezeCashAmout = freezeCashAmout;
    }

    public BigDecimal getFreezeUncashAmount() {
        return freezeUncashAmount;
    }

    public void setFreezeUncashAmount(BigDecimal freezeUncashAmount) {
        this.freezeUncashAmount = freezeUncashAmount;
    }

    public String getRefSn() {
        return refSn;
    }

    public void setRefSn(String refSn) {
        this.refSn = refSn == null ? null : refSn.trim();
    }

    public String getRefBatchId() {
        return refBatchId;
    }

    public void setRefBatchId(String refBatchId) {
        this.refBatchId = refBatchId == null ? null : refBatchId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate == null ? null : workDate.trim();
    }

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
}