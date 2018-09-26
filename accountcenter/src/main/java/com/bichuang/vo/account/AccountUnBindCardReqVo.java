package com.bichuang.vo.account;

/**
 * 账户银行卡解绑请求模型
 * 
 * @author liufei
 * @version 2018年3月22日  
 * @see AccountUnBindCardReqVo  
 * @since
 */
public class AccountUnBindCardReqVo
{
    /**
     * 账户id
     */
    private String accountId;
    
    /**
     * 银行卡号
     */
    private String bankCardNo;

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }

    public String getBankCardNo()
    {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo)
    {
        this.bankCardNo = bankCardNo;
    }
}
