package com.bichuang.platform.common.vo.activity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="话费充值回调实体")
public class PhoneRechargeVoRsp implements Serializable {
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Length(min=11,max=11,message="手机号长度需为11位")
	 @NotNull(message="手机号不能为空")
	 @ApiModelProperty(required=true,value="手机号不能够为空")
	 private String mobile;
	 
     private double applyAmount;

    private double actualAmount;

    private double deductAmount;
     
    private String message;
     
	private Integer status;
    
	@NotNull(message="订单号不能为空")
	@ApiModelProperty(required=true,value="订单号不能够为空")
    private String orderid;

    private String taskid;
     
    private Integer code;

    private String type;
    
	private String cert;
	
	@Range(min=0,max=100,message="充值金额应该在0到100之间")
	@ApiModelProperty(required=true,value="充值金额不能为空,且范围在0到100之间")
	private double money;
	 
	private String createdBy;
	 
	private Date updatedTime;
	 
	private String updatedBy;
     
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public double getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(double applyAmount) {
		this.applyAmount = applyAmount;
	}

	public double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public double getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(double deductAmount) {
		this.deductAmount = deductAmount;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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
