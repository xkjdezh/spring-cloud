package com.bichuang.platform.common.util;
/**
 * 系统表
 * @author ZhangZeBiao
 * @date 2018年3月7日 上午11:41:07
 *
 */
public enum SystemInletEnum {
	AD(1,"广告系统"), 
	SALE(2,"零售系统");
	
    // 成员变量  
	private int id;  
    private String name;  
    // 构造方法  
    private SystemInletEnum( int id,String name) {  
    	this.id = id;  
        this.name = name;  
    }  
    // 普通方法  
    public static String getName(int id) {  
        for (SystemInletEnum c : SystemInletEnum.values()) {  
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
