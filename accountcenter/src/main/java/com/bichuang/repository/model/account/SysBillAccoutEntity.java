package com.bichuang.repository.model.account;

import java.math.BigDecimal;

import com.bichuang.platform.common.base.BaseEntity;

/**
 * 企业结算账户实体
 * 
 * 对应集团公司账户实体，所有资金都统一入账到该账户，后台分润、提现都由该账户出账。
 * 
 * @author liufei
 * @version 2018年3月21日  
 * @see SysBillAccoutEntity  
 * @since
 */
public class SysBillAccoutEntity extends BaseEntity {
    private Integer id;

    private Integer accountNo;

    private Integer accountName;
    
    /**
     * 手机号，可用于登录账号
     */
    private String phoneNum;

    private String companyName;

    private String idCardNo;

    private BigDecimal balanceAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAccountName()
    {
        return accountName;
    }

    public void setAccountName(Integer accountName)
    {
        this.accountName = accountName;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getIdCardNo()
    {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo)
    {
        this.idCardNo = idCardNo;
    }

    public BigDecimal getBalanceAmount()
    {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }
}