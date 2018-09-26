package com.bichuang.controller.coupon;

import java.math.BigDecimal;
import java.util.List;

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
import com.bichuang.repository.model.coupon.CouponGrantSchedule;
import com.bichuang.service.coupon.CouponGrantScheduleService;



@Controller
@RequestMapping("/com.bichuang.coupon")
public class CouponGrantScheduleController {
	private static Logger logger = LoggerFactory.getLogger(CouponGrantScheduleController.class);
	
	@Autowired
	private CouponGrantScheduleService couponGrantScheduleService;
	
	/**
	 * 保存优惠券发布计划
	 * 
	 * @param couponGrantSchedule
	 * @return
	 */
	@PostMapping(value = "/saveCouponGrantSchedule")
	@ResponseBody
	public RespEntity saveCouponGrantSchedule(@RequestBody CouponGrantSchedule couponGrantSchedule) {
		try {
			String couponId = couponGrantScheduleService.saveCouponGrantSchedule(couponGrantSchedule);
			return RespEntity.getRespEntitySuc(couponId);
		} catch (Exception e) {
			logger.error("保存优惠券下发计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
	
	/**
	 * 修改优惠券发布计划
	 * 
	 * @param couponGrantSchedule
	 * @return
	 */
	@PostMapping(value = "/updateCouponGrantSchedule")
	@ResponseBody
	public RespEntity updateCouponGrantSchedule(@RequestBody CouponGrantSchedule couponGrantSchedule) {
		try {
			int updateRecord = couponGrantScheduleService.updateCouponGrantSchedule(couponGrantSchedule);
			return RespEntity.getRespEntitySuc(updateRecord);
		} catch (Exception e) {
			logger.error("修改优惠券下发计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
		
	}
	/**
	 * 下架优惠券发布计划
	 * 
	 * @param couponGrantSchedule
	 * @return
	 */
	@PostMapping(value = "/lowerCouponGrantSchedule")
	@ResponseBody
	public RespEntity lowerCouponGrantSchedule(@RequestBody CouponGrantSchedule couponGrantSchedule) {
		try {
			int updateRecord = couponGrantScheduleService.lowerCouponGrantSchedule(couponGrantSchedule);
			if(updateRecord == -1){
				return RespEntity.getRespEntitySuc("此优惠券发布计划不存在");
			}else if(updateRecord == -2){
				return RespEntity.getRespEntitySuc("此优惠券发布计划不可下架");
			}
			return RespEntity.getRespEntitySuc("下架成功");
		} catch (Exception e) {
			logger.error("下架优惠券下发计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
		
	}
	/**
	 * 根据couponId查询优惠券发布计划
	 * 
	 * @param couponGrantSchedule
	 * @return
	 */
	@GetMapping(value = "/selectCouponGrantScheduleById")
	@ResponseBody
	public RespEntity selectCouponGrantScheduleById(String couponId) {
		try {
			CouponGrantSchedule couponGrantSchedule = couponGrantScheduleService.selectCouponGrantScheduleById(couponId);
			return RespEntity.getRespEntitySuc(couponGrantSchedule);
		} catch (Exception e) {
			logger.error("查询优惠券详细发布计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
	
	
	/**
	 * 查询所有优惠券发布计划
	 * 
	 * @param 
	 * @return
	 */
	@GetMapping(value = "/selectCouponGrantRecordAll")
	@ResponseBody
	public RespEntity selectCouponGrantRecordAll() {
		try {
			List<CouponGrantSchedule> couponGrantScheduleList = couponGrantScheduleService.selectCouponGrantScheduleRecordAll();;
			return RespEntity.getRespEntitySuc(couponGrantScheduleList);
		} catch (Exception e) {
			logger.error("查询待发布的优惠券发布计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
	
	
	/**
	 * 查询待发布的优惠券发布计划
	 * 
	 * @param 
	 * @return
	 */
	@GetMapping(value = "/selectCouponGrantRecord")
	@ResponseBody
	public RespEntity selectCouponGrantRecord() {
		try {
			CouponGrantSchedule couponGrantSchedule = couponGrantScheduleService.selectCouponGrantRecord();;
			return RespEntity.getRespEntitySuc(couponGrantSchedule);
		} catch (Exception e) {
			logger.error("查询待发布的优惠券发布计划失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
	
	
	/**
	 * 根据商品原价和选择的优惠券计算返回折扣金额
	 * 
	 * @param couponId,amount
	 * @return couponAmount
	 */
	@GetMapping(value = "/getCouponAmount")
	@ResponseBody
	public RespEntity getCouponAmount(String couponId,BigDecimal amount) {
		try {
			BigDecimal couponAmount = couponGrantScheduleService.getCouponAmount(couponId,amount);
			if(BigDecimal.ZERO.equals(couponAmount)){
				return RespEntity.getRespEntityFail("消费金额未达到优惠券使用门槛");
			}
			return RespEntity.getRespEntitySuc(couponAmount);
		} catch (Exception e) {
			logger.error("查询优惠券计算返回折扣金额失败:{}",e.getMessage());
			return RespEntity.getRespEntityError("系统故障，正在加速修复中....");
		}
	}
}
