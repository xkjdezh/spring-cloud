/**
 * 
 */
package com.bichuang.openapi.service.activity;

import com.bichuang.platform.common.vo.activity.PhoneRechargeVoReq;
import com.bichuang.platform.common.vo.activity.PhoneRechargeVoRsp;

/** 
 * @author mi
 *
 */
public interface PhoneRechargeService {

	public int recharge(PhoneRechargeVoReq vo);
	
	public int rechargeCallback(PhoneRechargeVoRsp vo );
}
