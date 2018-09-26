package com.bichuang.service.coupon.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bichuang.platform.common.util.UniqId;
import com.bichuang.repository.mapper.coupon.CouponGrantScheduleMapper;
import com.bichuang.repository.mapper.coupon.ext.CouponGrantScheduleExtMapper;
import com.bichuang.repository.model.coupon.CouponGrantSchedule;
import com.bichuang.service.coupon.CouponGrantScheduleService;
@Service
public class CouponGrantScheduleServiceImpl implements CouponGrantScheduleService {

	private static Logger logger = LoggerFactory.getLogger(CouponGrantScheduleServiceImpl.class);
	
	@Autowired
	private CouponGrantScheduleMapper couponGrantScheduleMapper;
	
	@Autowired
	private CouponGrantScheduleExtMapper couponGrantScheduleExtMapper;
	
	
	@Override
	public String saveCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule) {
		String couponId = UniqId.getInstance().getUuid();
		couponGrantSchedule.setCouponId(couponId);
		couponGrantSchedule.setCreatDate(new Date());
		couponGrantScheduleMapper.insert(couponGrantSchedule);
		return couponId;
	}

	@Override
	public int updateCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule) {
		int updateRecord = couponGrantScheduleMapper.updateByPrimaryKey(couponGrantSchedule);
		return updateRecord;
	}

	@Override
	public CouponGrantSchedule selectCouponGrantScheduleById(String couponId) {
		CouponGrantSchedule couponGrantSchedule = couponGrantScheduleMapper.selectByPrimaryKey(couponId);
		return couponGrantSchedule;
	}

	
	@Override
	public List<CouponGrantSchedule> selectCouponGrantScheduleRecordAll() {
		List<CouponGrantSchedule> scheduleList = couponGrantScheduleExtMapper.selectCouponGrantScheduleRecordAll();
		return scheduleList;
	}

	@Override
	public CouponGrantSchedule selectCouponGrantRecord() {
		CouponGrantSchedule couponGrantSchedule = couponGrantScheduleExtMapper.selectCouponGrantScheduleRecord();
		return couponGrantSchedule;
	}

	@Override
	public BigDecimal getCouponAmount(String couponId, BigDecimal amount) {
		BigDecimal payAmount = BigDecimal.ZERO;
		CouponGrantSchedule couponGrantSchedule = couponGrantScheduleMapper.selectByPrimaryKey(couponId);
		if(couponGrantSchedule == null){
			return payAmount;
		}
		if(amount.compareTo(couponGrantSchedule.getThresholdValue())<0){
			return payAmount;
		}
		String couponType = couponGrantSchedule.getCouponType();
		if("0".equals(couponType)){
			BigDecimal discountValue = couponGrantSchedule.getDiscountValue();
			payAmount = amount.multiply(discountValue);
		}else if("1".equals(couponType)){
			payAmount =  couponGrantSchedule.getCashValue();
		}
		return amount.subtract(payAmount);
	}

	@Override
	public int updateCouponGrantScheduleStatusForStart() {
		return couponGrantScheduleExtMapper.updateCouponGrantScheduleStatusForStart();
	}

	@Override
	public int updateCouponGrantScheduleStatusForEnd() {
		return couponGrantScheduleExtMapper.updateCouponGrantScheduleStatusForEnd();
	}

	@Override
	public int lowerCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule) {
		CouponGrantSchedule schedule = couponGrantScheduleMapper.selectByPrimaryKey(couponGrantSchedule.getCouponId());
		if(schedule==null){
			return -1;
		}
		if(schedule.getGrantStatus() !=0){
			return -2;
		}
		return couponGrantScheduleExtMapper.lowerCouponGrantSchedule(couponGrantSchedule);
	}
	
}
