package com.bichuang.platform.common.base;
/**
 * 报文枚举类
 * @author zhangzebiao
 *
 */
public enum RespCode {

    SUCCESS(0, "请求成功"),
    FAIL(-1, "网络异常，请稍后重试"),
	ERROR(-2, "系统异常，请联系系统管理员"),
	NOLOGIN(401,"用户未登陆！"),
	NOPOPEDOM(404,"没有权限！"),
	EXISTED(402,"角色名已存在"),
	EXISTEDLOGINNAME(403,"用户名已存在");
    private int code;
    private String msg;

    RespCode(int code, String msg) {
    	this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}