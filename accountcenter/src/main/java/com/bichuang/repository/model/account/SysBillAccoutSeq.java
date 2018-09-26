package com.bichuang.repository.model.account;

import java.util.Date;

import com.bichuang.platform.common.base.BaseEntity;

/**
 * 系统结算账户流水
 * 
 * 〈一句话功能简述〉  
 * 〈功能详细描述〉  
 * @author liufei
 * @version 2018年3月22日  
 * @see SysBillAccoutSeq  
 * @since
 */
public class SysBillAccoutSeq extends BaseEntity {
    private Integer id;

    /**
     * 系统结算账户id
     */
    private Integer accountNo;

    /**
     * 交易前账户金额
     */
    private Long preamount;

    /**
     * 本次交易金额
     */
    private Long amount;
    
    /**
     * 交易类型  - 合同入账，分润出账，C端提现出账等
     */
    private int transactionType;

    /**
     * 业务订单标识，合同订单，分润订单，提现订单
     */
    private String businessOrderId;

    /**
     * 业务描述
     */
    private String remark;

    /**
     * 记账日志
     */
    private String workDate;
    
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getAccountNo()
    {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo)
    {
        this.accountNo = accountNo;
    }

    public Long getPreamount()
    {
        return preamount;
    }

    public void setPreamount(Long preamount)
    {
        this.preamount = preamount;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public int getTransactionType()
    {
        return transactionType;
    }

    public void setTransactionType(int transactionType)
    {
        this.transactionType = transactionType;
    }

    public String getBusinessOrderId()
    {
        return businessOrderId;
    }

    public void setBusinessOrderId(String businessOrderId)
    {
        this.businessOrderId = businessOrderId;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getWorkDate()
    {
        return workDate;
    }

    public void setWorkDate(String workDate)
    {
        this.workDate = workDate;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}