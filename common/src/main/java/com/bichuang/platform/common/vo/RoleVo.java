package com.bichuang.platform.common.vo;

import java.sql.Timestamp;

/**
 * 角色基本信息类 作者: LongZhangWei 日期：2018年2月26日 上午10:14:59
 */
public class RoleVo {

	// id
	private int id;
	// 角色名
	private String roleName;
	// 创建人
	private int createBy;
	private String optionByMobile;
	// 修改人
	private int updateBy;
	// 创建时间
	private Timestamp createTime;
	// 修改时间
	private Timestamp updateTime;
	// 权限字符串多个,分开
	private String authStrs;
	// 是否可以删除
	private Integer isDelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public int getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getAuthStrs() {
		return authStrs;
	}

	public void setAuthStrs(String authStrs) {
		this.authStrs = authStrs;
	}

	public String getOptionByMobile() {
		return optionByMobile;
	}

	public void setOptionByMobile(String optionByMobile) {
		this.optionByMobile = optionByMobile;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "RoleVo [id=" + id + ", roleName=" + roleName + ", createBy=" + createBy + ", updateBy=" + updateBy
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", authStrs=" + authStrs + "]";
	}

}
