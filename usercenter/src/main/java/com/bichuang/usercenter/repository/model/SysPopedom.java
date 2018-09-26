package com.bichuang.usercenter.repository.model;

public class SysPopedom {
    private Integer id;

    private String popedomType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPopedomType() {
        return popedomType;
    }

    public void setPopedomType(String popedomType) {
        this.popedomType = popedomType == null ? null : popedomType.trim();
    }
}