package com.bichuang.repository.model.account;

import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

public class BalanceAccountBInnerSeq extends BaseEntity {
    private Integer id;

    private Integer accountIdB;

    private Long preamount;

    private Long amount;

    private String orderid;

    private Date createTime;

    private String note;

    private String workdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountIdB() {
        return accountIdB;
    }

    public void setAccountIdB(Integer accountIdB) {
        this.accountIdB = accountIdB;
    }

    public Long getPreamount() {
        return preamount;
    }

    public void setPreamount(Long preamount) {
        this.preamount = preamount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
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