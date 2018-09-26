package com.bichuang.repository.mapper.coupon.ext;

import java.util.List;

import com.bichuang.repository.model.coupon.CouponUser;

public interface CouponUserExtMapper {
	List<CouponUser> selectCouponInfoByUserId(String userId);

	int insertBatch(List<CouponUser> couponUserList);

	int updateUserCouponStatus();
}