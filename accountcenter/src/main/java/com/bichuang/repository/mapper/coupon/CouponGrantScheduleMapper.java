package com.bichuang.repository.mapper.coupon;

import com.bichuang.repository.model.coupon.CouponGrantSchedule;

public interface CouponGrantScheduleMapper {
    int deleteByPrimaryKey(String couponId);

    int insert(CouponGrantSchedule record);

    int insertSelective(CouponGrantSchedule record);

    CouponGrantSchedule selectByPrimaryKey(String couponId);

    int updateByPrimaryKeySelective(CouponGrantSchedule record);

    int updateByPrimaryKey(CouponGrantSchedule record);
}