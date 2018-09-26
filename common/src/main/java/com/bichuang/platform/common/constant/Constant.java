package com.bichuang.platform.common.constant;

/**
 * 常量
 * 
 * @author Administrator
 *
 */
public class Constant {

	/** 登录保存redis的前缀  */
	public static final String LOGIN = "login_";  
	
	/** 权限保存redis的前缀  */
	public static final String POPEDOM = "popedom_";  
	
	/** 成功 */
	public static final String SUCCEES_CODE = "OK";
	/** 对照接口文档,检查接口必输参数是否有值或参数类型是否正确... */
	public static final String FAIL_CODE = "fail";

	public static final String JSON_UTF8 = "application/json;charset=UTF-8";

	public static final int WEEK_TO_MIN = 10080;// 一周的分钟数

	public static final int DAT_TO_MIN = 1440;// 一天分钟数

	public static final int CONNECTION_TIME_OUT = 10000;// 10秒

	public static final int SOCKET_TIME_OUT = 5000;// 5秒

	public static final String PAGE_OFFSET = "1";

	public static final String PAGE_ROWS = "10";

	// token超时时间设置
	public static final Integer EXPIRE_TIME = 60 * 24 * 7;

	public static final String TOKEN = "token";

	// (重置密码)忘记密码
	public static final Integer FORGET_PASSWORD = 1;

	// (重置密码)修改密码
	public static final Integer UPDATE_PASSWORD = 2;

	// 验证验证码（忘记密码）
	public static final Integer VALIDATE_SMSCODE_FPSW = 4;

	// 验证类型（手机短信验证码）
	public static final Integer VALIDATE_TYPE_SMSCODE = 5;

	// 账户类型（手机号）
	public static final Integer ACCOUNT_TYPE_PHONE = 3;

	public static final String CONTENT = "content";

	public static final String USER_ID = "userId";

	public static final String USER_INFO = "userInfo";

	// 设置编码格式
	public static final String CHAR_SET = "UTF-8";

	// 图片文件类型
	public static final Short PICTURE_TYPE = 1;

	public static final int contentLen = 100;

	// 默认密码长度
	public static final Integer PASSWORD_LENGTH = 8;

	/** 已开户 */
	public static final String RESULT_1001 = "1001";
	
	public static final String RESULT_1002 = "已开户";
	
	public static final String RESULT_2001 = "此银行卡已绑定";
	
	public static final String TL_SERVCIE_URL = "http://122.227.225.142:23661/service/soa";

	public static final String DEPOSIT_NOTIFY = "http://172.18.0.100:8080/ac/accountBalance/depositNotify";
	
	public static final String WITHDRAW_NOTIFY = "http://172.18.0.100:8080/ac/accountBalance/withdrawNotify";
	
	public static final String SET_PAYPWD = "http://172.18.0.100:8080/ac/account/setPayPwd";
	
	public static final String JUMP_URL = "http://172.18.0.100:8080/ac/account/jumpUrl";//TODO

	public static final String MEMBER_SERVCIE = "MemberService";
	
	public static final String MEMBER_SERVICE_WITHOUT_CONFIRM = "MemberServiceWithoutConfirm";
	
	public static final String BIND_PHONE_WITHOUT_CONFIRM = "bindPhoneWithoutConfirm";
	
	public static final String MEMBER_PWD_SERVICE = "MemberPwdService";
	
	public static final String ORDER_SERVICE = "OrderService";
	
	public static final String CREATE_MEMBER = "createMember";
	
	public static final String BIND_PHONE = "bindPhone";
	
	public static final String SET_REALNAME = "setRealName";
	
	public static final String SIGN_CONTRACT = "signContract";
	
	public static final String SEND_SMS = "sendVerificationCode";
	
	public static final String GET_BANK_CARD_BIN = "getBankCardBin";
	
	public static final String APPLY_BIND_BANK_CARD = "applyBindBankCard";
	
	public static final String BIND_BANK_CARD = "bindBankCard";
	
	public static final String DEPOSIT_APPLY = "depositApply";
	
	public static final String PAY = "pay";
	
	public static final String SET_PAY_PWD = "setPayPwd";
	
	public static final String UPDATE_PAY_PWD = "updatePayPwd";
	
	public static final String WITHDRAW_APPLY = "withdrawApply";
	
	public static final String QUERY_BALANCE = "queryBalance";
	
	public static final String QUERY_INEXPDETAIL = "queryInExpDetail";
	
}
