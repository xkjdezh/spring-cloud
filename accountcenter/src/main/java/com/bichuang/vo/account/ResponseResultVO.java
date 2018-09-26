package com.bichuang.vo.account;

import io.swagger.annotations.ApiModelProperty; 

public class ResponseResultVO<T> {

	@ApiModelProperty(notes = "结果码")
	private String result;
	@ApiModelProperty(notes = "提示信息")
	private String msg;
	@ApiModelProperty(notes = "返回数据")
	private T data;

	public ResponseResultVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseResultVO(String result, String msg) {
		this.result = result;
		this.msg = msg;		
	}

	public ResponseResultVO(String result, String msg, T data) {
		this.result = result;
		this.msg = msg;
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResultVO [result=" + result + ", msg=" + msg + ", data=" + data + "]";
	}	
	
}
