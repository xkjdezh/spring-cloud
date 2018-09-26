package com.bichuang.platform.common.util;
/**
 * 广告投放渠道(售卖机/公众号/APP)
 * @author ZhangZeBiao
 * @date 2018年1月24日 上午11:41:07
 *
 */
public enum PopedomTypeEnum {
	MENU(1,"menu"), 
	OPERATION(2,"operation");
	
    // 成员变量  
	private int index;  
    private String name;  
    // 构造方法  
    private PopedomTypeEnum( int index,String name) {  
    	this.index = index;  
        this.name = name;  
    }  
    // 普通方法  
    public static String getName(int index) {  
        for (PopedomTypeEnum c : PopedomTypeEnum.values()) {  
            if (c.getIndex() == index) {  
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
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
}
