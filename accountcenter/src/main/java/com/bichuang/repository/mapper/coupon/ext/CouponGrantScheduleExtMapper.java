package com.bichuang.repository.mapper.coupon.ext;

import java.util.List;

import com.bichuang.repository.model.coupon.CouponGrantSchedule;

public interface CouponGrantScheduleExtMapper {

	CouponGrantSchedule selectCouponGrantScheduleRecord();

	List<CouponGrantSchedule> selectCouponGrantScheduleRecordAll();

	int updateCouponGrantScheduleStatusForStart();

	int updateCouponGrantScheduleStatusForEnd();

	int lowerCouponGrantSchedule(CouponGrantSchedule couponGrantSchedule);
	
}
