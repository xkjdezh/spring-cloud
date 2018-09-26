package com.bichuang.platform.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ZhangZeBiao
 * @date 2018年1月27日 下午4:26:14
 *
 */
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Integer id;
	//用户名
	private String username;
	//手机号码
	private String tel;
	//最后登录时间
	private Date lastLoginTime;
	//用户类型 1:B端用户 2：C端用户
	private Integer userType;
	//角色id
	private Integer ruleId;
	//角色名
	private String ruleName;
	//登录成功后返回给浏览器的token
	private String token;
	//资质类型：1个人 2企业
	private Integer qualificationsType;
	
	
	
	
	public UserInfo() {
		super();
	}
	
	

	public UserInfo(Integer id, String username, String tel, Date lastLoginTime, Integer userType, Integer ruleId,
			String ruleName, String token, Integer qualificationsType) {
		super();
		this.id = id;
		this.username = username;
		this.tel = tel;
		this.lastLoginTime = lastLoginTime;
		this.userType = userType;
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.token = token;
		this.qualificationsType = qualificationsType;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	
	public Integer getQualificationsType() {
		return qualificationsType;
	}

	public void setQualificationsType(Integer qualificationsType) {
		this.qualificationsType = qualificationsType;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", tel=" + tel + ", userType=" + userType + ", ruleId="
				+ ruleId + ", ruleName=" + ruleName + ", token=" + token + "]";
	}
	
}
