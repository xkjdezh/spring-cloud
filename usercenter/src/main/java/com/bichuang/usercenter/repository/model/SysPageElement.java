package com.bichuang.usercenter.repository.model;

public class SysPageElement {
    private Integer id;

    private String pageElementCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageElementCode() {
        return pageElementCode;
    }

    public void setPageElementCode(String pageElementCode) {
        this.pageElementCode = pageElementCode == null ? null : pageElementCode.trim();
    }
}