package com.bichuang.platform.common.vo;
/**
 * 
 * @author ZhangZeBiao
 * @date 2018年4月4日 下午5:41:53
 *
 */
public class ACReqCreateAccount {
	//客户Id
    private String custId;
    //客户名称
    private String custName;
    //证件类型1身份证 2护照
    private String identityType;
    //身份证号
    private String identityNo;
    //会员类型2. 企业 3.个人
    private Integer memberType;
    //访问终端类型1.mobile  2. pc 
    private Integer source;
    
    
    
	public ACReqCreateAccount() {
		super();
	}
	public ACReqCreateAccount(String custId, String custName, String identityType, String identityNo, Integer memberType,
			Integer source) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.identityType = identityType;
		this.identityNo = identityNo;
		this.memberType = memberType;
		this.source = source;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public Integer getMemberType() {
		return memberType;
	}
	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
    
}
