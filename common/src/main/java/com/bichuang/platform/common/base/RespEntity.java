package com.bichuang.platform.common.base;

/**
 * 响应报文
 * @author zhangzebiao
 *
 */
public class RespEntity {
    private int code;
    private String msg;
    private Object data;
    
    public static RespEntity getRespEntitySuc(Object obj){
    	RespEntity respEntity = new RespEntity();
    	respEntity.setCode(RespCode.SUCCESS.getCode());
    	respEntity.setMsg(RespCode.SUCCESS.getMsg());
    	respEntity.setData( obj);
    	return respEntity;
    }
    
    public static RespEntity getRespEntityFail(String failMsg){
    	RespEntity respEntity = new RespEntity();
    	respEntity.setCode(RespCode.FAIL.getCode());
    	respEntity.setMsg(RespCode.FAIL.getMsg());
    	if (failMsg!=null) {
    		respEntity.setMsg(failMsg);
		}
    	return respEntity;
    }
    
    public static RespEntity getRespEntityError(Object obj){
    	RespEntity respEntity = new RespEntity();
    	respEntity.setCode(RespCode.ERROR.getCode());
    	respEntity.setMsg(RespCode.ERROR.getMsg());
    	respEntity.setData(obj);
    	return respEntity;
    }

	public RespEntity(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public RespEntity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }
    
	public RespEntity(RespCode respCode, String msg, Object data) {
		this(respCode);
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public RespEntity (){
		this.code = RespCode.SUCCESS.getCode();
        this.msg = RespCode.SUCCESS.getMsg();
	}

	public RespEntity(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "RespEntity [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

	
}