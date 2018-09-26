package com.bichuang.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bichuang.repository.model.coupon.CouponGrantSchedule;
import com.bichuang.service.coupon.CouponGrantScheduleService;
import com.bichuang.service.coupon.CouponUserService;
/**
 * 
 * @author xiekangjian
 *优惠券下发计划监控定时任务
 * @date 2018年7月20日
 */
@Component
public class CouponGrantTimer {
	private Logger logger = LoggerFactory.getLogger(CouponGrantTimer.class);
	
	@Autowired
	private CouponGrantScheduleService couponGrantScheduleService;
	
	@Autowired
	private CouponUserService couponUserService;
	
	/*
	 * 查询是否有可下发的优惠券
	 */
	@Scheduled(fixedDelay = 60000)        //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void checkCouponGrantSchedule() {
		CouponGrantSchedule couponGrantSchedule = couponGrantScheduleService.selectCouponGrantRecord();
		if(couponGrantSchedule!=null){
			//开始下发优惠券给用户
			int insertSum = couponUserService.couponGrantToUser(couponGrantSchedule);
			logger.info("优惠券{}已经下发至:{}位用户",couponGrantSchedule.getCouponId(),insertSum);
			if(insertSum>0){
				//下发后修改优惠券下发计划的状态
				couponGrantSchedule.setGrantStatus(2);
				couponGrantSchedule.setGrantCurrentSum(couponGrantSchedule.getGrantCurrentSum()+insertSum);
				couponGrantScheduleService.updateCouponGrantSchedule(couponGrantSchedule);
			}
		}
	}
	
	/*
	 * 修改优惠券发布计划的状态
	 */
	@Scheduled(fixedDelay = 60000)        //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void updateCouponGrantScheduleStatus() {
		//修改处于发布中的优惠券发布计划状态
		int updateSum = couponGrantScheduleService.updateCouponGrantScheduleStatusForStart();
		logger.info("修改处于发布中的优惠券发布计划:{}条",updateSum);
		//修改已经发布完的优惠券发布计划状态
		updateSum = couponGrantScheduleService.updateCouponGrantScheduleStatusForEnd();
		logger.info("修改处于发布结束的优惠券发布计划:{}条",updateSum);
	}
	
	/*
	 * 修改用户优惠券状态
	 */
	@Scheduled(fixedDelay = 60000)        //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void updateUserCouponStatus() {
		int updateSum = couponUserService.updateUserCouponStatus();
		logger.info("修改用户优惠券状态:{}条",updateSum);
		
	}
}
