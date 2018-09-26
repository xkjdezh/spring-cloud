package com.bichuang.usercenter.repository.model;

import java.util.Date;

public class UserPopulousProC {
    private Integer userId;

    private String idcard;

    private Boolean sexy;

    private Integer age;

    private String adress;

    private String realName;

    private Integer dataStatus;

    private String userNo;

    private String nickName;

    private String status;

    private String introducerMobile;

    private String userChannel;

    private String userChannelMedia;

    private Date lastLoginTime;

    private Integer loginPwdModifyDelay;

    private Date loginPwdModifyTime;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private String remark;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Boolean getSexy() {
        return sexy;
    }

    public void setSexy(Boolean sexy) {
        this.sexy = sexy;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIntroducerMobile() {
        return introducerMobile;
    }

    public void setIntroducerMobile(String introducerMobile) {
        this.introducerMobile = introducerMobile == null ? null : introducerMobile.trim();
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel == null ? null : userChannel.trim();
    }

    public String getUserChannelMedia() {
        return userChannelMedia;
    }

    public void setUserChannelMedia(String userChannelMedia) {
        this.userChannelMedia = userChannelMedia == null ? null : userChannelMedia.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginPwdModifyDelay() {
        return loginPwdModifyDelay;
    }

    public void setLoginPwdModifyDelay(Integer loginPwdModifyDelay) {
        this.loginPwdModifyDelay = loginPwdModifyDelay;
    }

    public Date getLoginPwdModifyTime() {
        return loginPwdModifyTime;
    }

    public void setLoginPwdModifyTime(Date loginPwdModifyTime) {
        this.loginPwdModifyTime = loginPwdModifyTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}