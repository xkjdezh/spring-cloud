package com.bichuang.repository.model.account;

import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceAccountCFreezeSeq extends BaseEntity {
    private String sn;

    private String custId;

    private String accountType;

    private String custName;

    private Long freezeCashAmout;

    private Long freezeUncashAmount;

    private String changeType;

    private String orgsn;

    private String orgbatchid;

    private Date createTime;

    private String note;

    private String workdate;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
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

    public Long getFreezeCashAmout() {
        return freezeCashAmout;
    }

    public void setFreezeCashAmout(Long freezeCashAmout) {
        this.freezeCashAmout = freezeCashAmout;
    }

    public Long getFreezeUncashAmount() {
        return freezeUncashAmount;
    }

    public void setFreezeUncashAmount(Long freezeUncashAmount) {
        this.freezeUncashAmount = freezeUncashAmount;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
    }

    public String getOrgsn() {
        return orgsn;
    }

    public void setOrgsn(String orgsn) {
        this.orgsn = orgsn == null ? null : orgsn.trim();
    }

    public String getOrgbatchid() {
        return orgbatchid;
    }

    public void setOrgbatchid(String orgbatchid) {
        this.orgbatchid = orgbatchid == null ? null : orgbatchid.trim();
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

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate == null ? null : workdate.trim();
    }
}