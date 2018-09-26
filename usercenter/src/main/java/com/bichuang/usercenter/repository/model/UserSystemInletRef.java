package com.bichuang.usercenter.repository.model;

import java.util.Date;

public class UserSystemInletRef {
    private Integer id;

    private Integer userId;

    private Integer systemInletId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSystemInletId() {
        return systemInletId;
    }

    public void setSystemInletId(Integer systemInletId) {
        this.systemInletId = systemInletId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}