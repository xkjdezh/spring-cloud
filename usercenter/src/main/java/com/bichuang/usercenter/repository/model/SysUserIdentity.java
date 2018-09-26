package com.bichuang.usercenter.repository.model;

import java.util.Date;

public class SysUserIdentity {
    private Integer id;

    private String password;

    private String loginName;

    private String mobile;

    private Date registeTime;

    private Integer fristRegisteSystemId;

    private Date lastLoginTime;

    private Boolean type;

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
        this.password = password == null ? null : password.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getRegisteTime() {
        return registeTime;
    }

    public void setRegisteTime(Date registeTime) {
        this.registeTime = registeTime;
    }

    public Integer getFristRegisteSystemId() {
        return fristRegisteSystemId;
    }

    public void setFristRegisteSystemId(Integer fristRegisteSystemId) {
        this.fristRegisteSystemId = fristRegisteSystemId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}