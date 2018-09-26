package com.bichuang.platform.common.vo;

import java.sql.Timestamp;

/**
 * 用户基础信息类
 * 
 * @author LongZhangWei
 * @date 2018年2月7日 上午9:43:05
 */
public class BaseUser {

	// id
	private Integer id;
	private String ids;
	// 密码
	private String password;
	// 登录名
	private String loginName;
	// 手机号
	private String mobile;
	// 注册时间
	private Timestamp registeTime;
	// 系统注册id
	private Integer systemInletId;
	// 用户类型(0:C/1:B)
	private Integer type;
	private String typeName;
	// 创建人
	private Integer createBy;
	private String createByName;

	private String createTimeStr;
	// 创建时间
	private Timestamp createTime;
	// 修改人
	private Integer updateBy;
	// 修改时间
	private Timestamp updateTime;
	private String updateTimeStr;
	// 数据状态;1: 删除；0：可用
	private Integer dataStatus;
	// 上次登录时间
	private Timestamp lastLoginTime;
	// 角色id
	private Integer roleId;
	// 角色名称
	private String roleName;
	// 性别 0男1女
	private Integer sex;

	private Integer pageNum = 1;

	private Integer pageSize = 15;

	// 手机验证码
	private String telCode;
	// 新的密码
	private String newPassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Timestamp getRegisteTime() {
		return registeTime;
	}

	public void setRegisteTime(Timestamp registeTime) {
		this.registeTime = registeTime;
	}

	public Integer getSystemInletId() {
		return systemInletId;
	}

	public void setSystemInletId(Integer systemInletId) {
		this.systemInletId = systemInletId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getTelCode() {
		return telCode;
	}

	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "BaseUser [id=" + id + ", password=" + password + ", loginName=" + loginName + ", mobile=" + mobile
				+ ", registeTime=" + registeTime + ", systemInletId=" + systemInletId + ", type=" + type + ", typeName="
				+ typeName + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy=" + updateBy
				+ ", updateTime=" + updateTime + ", dataStatus=" + dataStatus + ", lastLoginTime=" + lastLoginTime
				+ ", roleId=" + roleId + ", orleName=" + roleName + ", sex=" + sex + "]";
	}

}
