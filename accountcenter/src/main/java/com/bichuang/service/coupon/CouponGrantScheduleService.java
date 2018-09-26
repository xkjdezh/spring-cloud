package com.bichuang.service.coupon;

import java.math.BigDecimal;
import java.util.List;

import com.bichuang.repository.model.coupon.CouponGrantSchedule;

public interface CouponGrantScheduleService {

	String saveCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule);

	int updateCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule);

	CouponGrantSchedule selectCouponGrantScheduleById(String couponId);

	CouponGrantSchedule selectCouponGrantRecord();

	List<CouponGrantSchedule> selectCouponGrantScheduleRecordAll();

	BigDecimal getCouponAmount(String couponId, BigDecimal amount);

	int updateCouponGrantScheduleStatusForStart();

	int updateCouponGrantScheduleStatusForEnd();

	int lowerCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule);

}
