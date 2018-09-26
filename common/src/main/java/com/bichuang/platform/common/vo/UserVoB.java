package com.bichuang.platform.common.vo;
/**
 * B端用户静态数据之社会属性类
 * @author LongZhangWei
 * @date 2018年2月6日 下午5:06:48
 */

import java.sql.Timestamp;


public class UserVoB extends BaseUser {
	// 地址
	private String address;
	// 品牌
	private String brand;
	// 代理商ID（t_user_b_extend_agent的id）
	private Integer agentId;
	// 代理商名称
	private String agentName;
	// 公司名
	private String companyName;
	// 系统类型ID
	private Integer systemInletId;
	//  1 超级管理员  2 物业公司  3 代理商  4 广告商  5 广告部  6 财务
	private Integer bizTypeId;
	// 扩展ID，根据biz_type来区分是什么的扩展表
	private Integer bExtendId;
	// 真实姓名
	private String realName;
	// 性别0男1女
	private Boolean sexy;
	// 地区
	private String area;
	// 详细地址
	private String detailAddress;
	// 身份证号
	private String idcard;
	// 身份证正面照片URL
	private String idcardFrontPhotoUrl;
	// 身份证反面照片URL
	private String idcardReversePhotoUrl;
	// 银行卡信息
	private String bankCarInfo;
	// 银行信息表id
	private Integer bankInfoId;
	// 银行卡号
	private String bankCarNumber;
	// 邮件
	private String mailbox;
	// 资质类型：1个人 2企业
	private Integer qualificationsType;
	private String qualificationsTypeName;
	// 征信建议:1信用良好建议合作;2有信用风险，建议终止合作)
	private Integer creditAdvise;
	// 统一社会信用代码
	private String creditCode;
	// 征信查询结果(文件保存路径)
	private String creditQueryResultsUrl;
	// 证件照片URL
	private String licenseIdPhotoUrl;
	// 证件编码
	private String licenseCode;
	// 证件注册地
	private String licenseRegister;
	// 征信查询结果上传文件的文件原名，多个用逗号分开
	private String creditQueryResultsFileName;
	// 证件照片上传文件原名，多个用逗号隔开
	private String licenseIdPhotoFileName;
	// 审核状态：0:待审核 1：审核通过 2：审核不通过
	private Integer auditStatus;
	private String auditStatusStr;
	// 审核人id
	private Integer auditBy;
	// 审核人名称
	private String auditByName;
	// 审核时间
	private Timestamp auditTime;
	private String auditTimeStr;
	// 描述
	private String remark;
	// 用户类型
	private String userTypeStr;
	// 系统标识
	private String systTag;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getBizTypeId() {
		return bizTypeId;
	}

	public void setBizTypeId(Integer bizTypeId) {
		this.bizTypeId = bizTypeId;
	}

	public Integer getbExtendId() {
		return bExtendId;
	}

	public void setbExtendId(Integer bExtendId) {
		this.bExtendId = bExtendId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardFrontPhotoUrl() {
		return idcardFrontPhotoUrl;
	}

	public void setIdcardFrontPhotoUrl(String idcardFrontPhotoUrl) {
		this.idcardFrontPhotoUrl = idcardFrontPhotoUrl;
	}

	public String getIdcardReversePhotoUrl() {
		return idcardReversePhotoUrl;
	}

	public void setIdcardReversePhotoUrl(String idcardReversePhotoUrl) {
		this.idcardReversePhotoUrl = idcardReversePhotoUrl;
	}

	public String getBankCarInfo() {
		return bankCarInfo;
	}

	public void setBankCarInfo(String bankCarInfo) {
		this.bankCarInfo = bankCarInfo;
	}

	public Integer getBankInfoId() {
		return bankInfoId;
	}

	public void setBankInfoId(Integer bankInfoId) {
		this.bankInfoId = bankInfoId;
	}

	public String getBankCarNumber() {
		return bankCarNumber;
	}

	public void setBankCarNumber(String bankCarNumber) {
		this.bankCarNumber = bankCarNumber;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public Integer getQualificationsType() {
		return qualificationsType;
	}

	public void setQualificationsType(Integer qualificationsType) {
		this.qualificationsType = qualificationsType;
	}

	public Integer getCreditAdvise() {
		return creditAdvise;
	}

	public void setCreditAdvise(Integer creditAdvise) {
		this.creditAdvise = creditAdvise;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getCreditQueryResultsUrl() {
		return creditQueryResultsUrl;
	}

	public void setCreditQueryResultsUrl(String creditQueryResultsUrl) {
		this.creditQueryResultsUrl = creditQueryResultsUrl;
	}

	public String getLicenseIdPhotoUrl() {
		return licenseIdPhotoUrl;
	}

	public void setLicenseIdPhotoUrl(String licenseIdPhotoUrl) {
		this.licenseIdPhotoUrl = licenseIdPhotoUrl;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getLicenseRegister() {
		return licenseRegister;
	}

	public void setLicenseRegister(String licenseRegister) {
		this.licenseRegister = licenseRegister;
	}

	public String getCreditQueryResultsFileName() {
		return creditQueryResultsFileName;
	}

	public void setCreditQueryResultsFileName(String creditQueryResultsFileName) {
		this.creditQueryResultsFileName = creditQueryResultsFileName;
	}

	public String getLicenseIdPhotoFileName() {
		return licenseIdPhotoFileName;
	}

	public void setLicenseIdPhotoFileName(String licenseIdPhotoFileName) {
		this.licenseIdPhotoFileName = licenseIdPhotoFileName;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getAuditBy() {
		return auditBy;
	}

	public void setAuditBy(Integer auditBy) {
		this.auditBy = auditBy;
	}

	public String getAuditByName() {
		return auditByName;
	}

	public void setAuditByName(String auditByName) {
		this.auditByName = auditByName;
	}

	public Timestamp getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Timestamp auditTime) {
		this.auditTime = auditTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Boolean getSexy() {
		return sexy;
	}

	public void setSexy(Boolean sexy) {
		this.sexy = sexy;
	}

	public Integer getSystemInletId() {
		return systemInletId;
	}

	public void setSystemInletId(Integer systemInletId) {
		this.systemInletId = systemInletId;
	}

	public String getQualificationsTypeName() {
		return qualificationsTypeName;
	}

	public void setQualificationsTypeName(String qualificationsTypeName) {
		this.qualificationsTypeName = qualificationsTypeName;
	}

	public String getAuditStatusStr() {
		return auditStatusStr;
	}

	public void setAuditStatusStr(String auditStatusStr) {
		this.auditStatusStr = auditStatusStr;
	}

	public String getAuditTimeStr() {
		return auditTimeStr;
	}

	public void setAuditTimeStr(String auditTimeStr) {
		this.auditTimeStr = auditTimeStr;
	}

	public String getUserTypeStr() {
		return userTypeStr;
	}

	public void setUserTypeStr(String userTypeStr) {
		this.userTypeStr = userTypeStr;
	}

	public String getSystTag() {
		return systTag;
	}

	public void setSystTag(String systTag) {
		this.systTag = systTag;
	}

	@Override
	public String toString() {
		return "UserVoB [address=" + address + ", brand=" + brand + ", agentId=" + agentId + ", agentName=" + agentName
				+ ", companyName=" + companyName + ", systemInletId=" + systemInletId + ", bizTypeId=" + bizTypeId
				+ ", bExtendId=" + bExtendId + ", realName=" + realName + ", sexy=" + sexy + ", area=" + area
				+ ", detailAddress=" + detailAddress + ", idcard=" + idcard + ", idcardFrontPhotoUrl="
				+ idcardFrontPhotoUrl + ", idcardReversePhotoUrl=" + idcardReversePhotoUrl + ", bankCarInfo="
				+ bankCarInfo + ", bankInfoId=" + bankInfoId + ", bankCarNumber=" + bankCarNumber + ", mailbox="
				+ mailbox + ", qualificationsType=" + qualificationsType + ", qualificationsTypeName="
				+ qualificationsTypeName + ", creditAdvise=" + creditAdvise + ", creditCode=" + creditCode
				+ ", creditQueryResultsUrl=" + creditQueryResultsUrl + ", licenseIdPhotoUrl=" + licenseIdPhotoUrl
				+ ", licenseCode=" + licenseCode + ", licenseRegister=" + licenseRegister
				+ ", creditQueryResultsFileName=" + creditQueryResultsFileName + ", licenseIdPhotoFileName="
				+ licenseIdPhotoFileName + ", auditStatus=" + auditStatus + ", auditStatusStr=" + auditStatusStr
				+ ", auditBy=" + auditBy + ", auditByName=" + auditByName + ", auditTime=" + auditTime
				+ ", auditTimeStr=" + auditTimeStr + ", remark=" + remark + "]";
	}

}
