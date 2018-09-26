package com.bichuang.repository.mapper.coupon;

import com.bichuang.repository.model.coupon.CouponUser;

public interface CouponUserMapper {
    int deleteByPrimaryKey(String couponLineNumber);

    int insert(CouponUser record);

    int insertSelective(CouponUser record);

    CouponUser selectByPrimaryKey(String couponLineNumber);

    int updateByPrimaryKeySelective(CouponUser record);

    int updateByPrimaryKey(CouponUser record);
}