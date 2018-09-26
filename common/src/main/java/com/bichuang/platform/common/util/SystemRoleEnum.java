package com.bichuang.platform.common.util;
/**
 * 固定的角色
 * @author ZhangZeBiao
 * @date 2018年4月8日 上午11:32:55
 *
 */
public enum SystemRoleEnum {
	ADMINISTRATOR(1,"超级管理员"), 
	ESTATECOMPANY(2,"物业公司"),
	AGENT(3,"代理商"),
	ADVERTISER(4,"广告商"),
	ADVERTISINGDEPARTMENT(5,"广告部"),
	FINANCE(6,"财务");
	
    // 成员变量  
	private int id;  
    private String name;  
    // 构造方法  
    private SystemRoleEnum( int id,String name) {  
    	this.id = id;  
        this.name = name;  
    }  
    // 普通方法  
    public static String getName(int id) {  
        for (SystemRoleEnum c : SystemRoleEnum.values()) {  
            if (c.getId() == id) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    // get set 方法  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
}
