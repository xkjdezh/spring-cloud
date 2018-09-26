package com.bichuang.vo.account;

import java.io.Serializable;

public class MemberEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***商户系统用户标识***/
    private String bizUserId;
    /***会员类型 ***/
    private Long memberType;
    /***访问终端类型***/
    private Long source;
    /***云账户用户唯一标识***/
    private String userId;

    public String getBizUserId() {
        return bizUserId;
    }

    public void setBizUserId(String bizUserId) {
        this.bizUserId = bizUserId;
    }

    public Long getMemberType() {
        return memberType;
    }

    public void setMemberType(Long memberType) {
        this.memberType = memberType;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
