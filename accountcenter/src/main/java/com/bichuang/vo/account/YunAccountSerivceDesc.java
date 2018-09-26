package com.bichuang.vo.account;

import java.io.Serializable;

public class YunAccountSerivceDesc<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***请求调用的服务对象**/
    private String service;
    /**请求调用的方法***/
    private String method;
    /***请求参数，也是一个嵌套的 JSON 对象，key 为参数名称，value 为参数值**/
    private T params;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
