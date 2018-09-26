package com.bichuang.vo.account;

/**
 * 扣款请求数据实体
 *
 */
public class AccountCChangeVo {
	private String userId;  //用户id
	private Integer  cOrB;//0 C  1 B
	private Long money; 	//计算费用
	private Integer optType;//1 add  2 减
	private String orderId;  //订单id
	public AccountCChangeVo() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getcOrB() {
		return cOrB;
	}
	public void setcOrB(Integer cOrB) {
		this.cOrB = cOrB;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	public Integer getOptType() {
		return optType;
	}
	public void setOptType(Integer optType) {
		this.optType = optType;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	

}
