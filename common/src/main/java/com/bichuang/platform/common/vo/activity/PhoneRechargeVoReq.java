package com.bichuang.platform.common.vo.activity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="话费充值请求实体")
public class PhoneRechargeVoReq implements Serializable {
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @NotNull(message="userId 不能为空" )
	 @Range(min=1,message="用户id 最小值为1")
	 @ApiModelProperty(required=true,value="用户id不能够为空")
	 private Long userId;
	 private String userRole;
	 
	 @Length(min=11,max=11,message="手机号长度需为11位")
	 @NotNull(message="手机号不能为空")
	 @ApiModelProperty(required=true,value="手机号不能够为空")
	 private String mobile;
	 
	 @NotNull(message="业务类型不能为空")
	 @ApiModelProperty(required=true,value="业务类型不能为空")
	 private Short bizType;
	 
	/* @Range(min=0,max=100,message="充值金额应该在0到100之间")
	 @ApiModelProperty(required=true,value="充值金额不能为空,且范围在0到100之间")*/
     private double applyAmount;

	 private Integer status;
	    
    private String orderid;

    private String taskid;
     
    private Integer code;

	private String createdBy;
	 
	private Date updatedTime;
		 
	private String updatedBy;
     
     private String message;
     
     public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Short getBizType() {
		return bizType;
	}

	public void setBizType(Short bizType) {
		this.bizType = bizType;
	}

	public double getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(double applyAmount) {
		this.applyAmount = applyAmount;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	 
}
