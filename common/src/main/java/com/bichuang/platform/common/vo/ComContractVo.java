package com.bichuang.platform.common.vo;

public class ComContractVo {

	// id
	private Integer id;
	// 乙方公司名称
	private String secondCompanyName;
	// 乙方公司联系人名称
	private String secondSignPerson;
	// 乙方联系人id
	private Integer secondSignUserId;
	// 乙方公司联系人电话
	private String secondSignPersonMobile;
	// 品牌名称
	private String brand;
	// 合同编号
	private String contractCode;
	// 合同id
	private Integer contractId;
	// 甲方签约人id
	private Integer fristSignUserId;

	public String getSecondCompanyName() {
		return secondCompanyName;
	}

	public void setSecondCompanyName(String secondCompanyName) {
		this.secondCompanyName = secondCompanyName;
	}

	public String getSecondSignPerson() {
		return secondSignPerson;
	}

	public void setSecondSignPerson(String secondSignPerson) {
		this.secondSignPerson = secondSignPerson;
	}

	public String getSecondSignPersonMobile() {
		return secondSignPersonMobile;
	}

	public void setSecondSignPersonMobile(String secondSignPersonMobile) {
		this.secondSignPersonMobile = secondSignPersonMobile;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSecondSignUserId() {
		return secondSignUserId;
	}

	public void setSecondSignUserId(Integer secondSignUserId) {
		this.secondSignUserId = secondSignUserId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Integer getFristSignUserId() {
		return fristSignUserId;
	}

	public void setFristSignUserId(Integer fristSignUserId) {
		this.fristSignUserId = fristSignUserId;
	}
}
