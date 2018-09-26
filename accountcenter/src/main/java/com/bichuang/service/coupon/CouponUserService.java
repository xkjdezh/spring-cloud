package com.bichuang.service.coupon;

import java.util.List;

import com.bichuang.repository.model.coupon.CouponGrantSchedule;
import com.bichuang.repository.model.coupon.CouponUser;

public interface CouponUserService {

	List<CouponUser> selectCouponInfoByUserId(String userId);

	int couponGrantToUser(CouponGrantSchedule couponGrantSchedule);

	String grantCouponToUser(String userId, String couponId);

	String couponCheck(CouponUser couponUser);

	int updateUserCouponStatus();
}
