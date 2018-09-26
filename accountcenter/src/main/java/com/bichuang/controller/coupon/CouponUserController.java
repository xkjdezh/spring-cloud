package com.bichuang.controller.coupon;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bichuang.platform.common.base.RespEntity;
import com.bichuang.repository.model.coupon.CouponUser;
import com.bichuang.service.coupon.CouponGrantScheduleService;
import com.bichuang.service.coupon.CouponUserService;


@Controller
@RequestMapping("/com.bichuang.coupon")
public class CouponUserController {
	
	private static Logger logger = LoggerFactory.getLogger(CouponUserController.class);
	
	@Autowired
	CouponUserService couponUserService;
	@Autowired
	CouponGrantScheduleService couponGrantScheduleService;
	
	/**
	 * 根据用户ID查询优惠券
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "/selectCouponInfoByUserId")
	@ResponseBody
	public RespEntity selectCouponInfoByUserId(String userId) {
		try {
			List<CouponUser> userInfoList = couponUserService.selectCouponInfoByUserId(userId);
			return RespEntity.getRespEntitySuc(userInfoList);
		} catch (Exception e) {
			logger.error("查询待发布的优惠券发布计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
		
	}
	
	
	
	/**
	 * 派发指定优惠券给指定用户
	 * 
	 * @param couponGrantSchedule
	 * @return
	 */
	@PostMapping(value = "/grantCouponToUser")
	@ResponseBody
	public RespEntity grantCouponToUser(@RequestBody Map<String,String> paramMap) {
		try {
			String couponId = paramMap.get("couponId");
			String userId = paramMap.get("userId");
			logger.info("派发优惠券:{}给指定用户:{}",couponId,userId);
			String msg = couponUserService.grantCouponToUser(userId, couponId);
			return RespEntity.getRespEntitySuc(msg);
		} catch (Exception e) {
			logger.error("派发优惠券给用户失败：{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
	
	/**
	 * 用户使用卡券核销
	 * @param couponUser
	 * @return
	 */
	@PostMapping(value = "/couponCheck")
	@ResponseBody
	public RespEntity couponCheck(@RequestBody CouponUser couponUser) {
		try {
			String msg = couponUserService.couponCheck(couponUser);
			return RespEntity.getRespEntitySuc(msg);
		} catch (Exception e) {
			logger.info("优惠券:{}在店铺:{}核销失败：{}",couponUser.getCouponLineNumber(),couponUser.getMerchantId(),e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
}
