package com.bichuang.service.coupon.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bichuang.platform.common.util.CommonUtil;
import com.bichuang.platform.common.util.DateUtil;
import com.bichuang.platform.common.util.UniqId;
import com.bichuang.repository.mapper.coupon.CouponUserMapper;
import com.bichuang.repository.mapper.coupon.ext.CouponUserExtMapper;
import com.bichuang.repository.model.coupon.CouponGrantSchedule;
import com.bichuang.repository.model.coupon.CouponUser;
import com.bichuang.service.coupon.CouponGrantScheduleService;
import com.bichuang.service.coupon.CouponUserService;

@Service
public class CouponUserServiceImpl implements CouponUserService {
	private static Logger logger = LoggerFactory.getLogger(CouponGrantScheduleServiceImpl.class);
	
	@Autowired
	private CouponGrantScheduleService couponGrantScheduleService;
	
	@Autowired
	private CouponUserMapper couponUserMapper;
	
	@Autowired
	private CouponUserExtMapper couponUserExtMapper;
	
	@Override
	public List<CouponUser> selectCouponInfoByUserId(String userId) {
		List<CouponUser> couponUserList= couponUserExtMapper.selectCouponInfoByUserId(userId);
		return 	couponUserList;
	}

	@Override
	public int couponGrantToUser(CouponGrantSchedule couponGrantSchedule) {
		int insertSum =0;
		try {
			String grantUserGroup = couponGrantSchedule.getGrantUsergroup();
			int tremType = couponGrantSchedule.getTermType();
			Date couponEffectiveStartData = new Date();
			Date couponEffectiveEndData = new Date();
			if(tremType==0){
				couponEffectiveStartData = couponGrantSchedule.getFixedStartDate();
				couponEffectiveEndData = couponGrantSchedule.getFixedEndDate();
			}else{
				couponEffectiveStartData  = new Date();
				couponEffectiveEndData = DateUtil.getApartDays(new Date(), couponGrantSchedule.getDynamicDate());
			}
			List<CouponUser> couponUserList= new ArrayList<CouponUser>();
			//根据用户组ID调用用户中心获取用户集合
			for(int i=1001;i<1011;i++){
				CouponUser couponUser = new CouponUser();
				couponUser.setUserId(UniqId.getInstance().getUniqID());//
				couponUser.setCouponId(couponGrantSchedule.getCouponId());
				couponUser.setCouponLineNumber(UniqId.getInstance().getUuid());
				couponUser.setCouponName(couponGrantSchedule.getCouponName());
				couponUser.setCouponType(couponGrantSchedule.getCouponType());
				couponUser.setCouponEffectiveStartData(couponEffectiveStartData);
				couponUser.setCouponEffectiveEndData(couponEffectiveEndData);
				couponUser.setScopeMarketId(couponGrantSchedule.getScopeMarketId());
				couponUser.setScopeMarketShopId(couponGrantSchedule.getScopeMarketShopId());
				couponUser.setCouponStatus(0);
				couponUserList.add(couponUser);
//				couponUserMapper.insert(couponUser);
			}
			insertSum = couponUserExtMapper.insertBatch(couponUserList);
			return insertSum;
		} catch (Exception e) {
			logger.error("优惠券下发至用户失败:{}",e.getMessage());
			return insertSum;
		}
		
	}

	@Override
	public String grantCouponToUser(String userId, String couponId) {
		CouponGrantSchedule couponGrantSchedule = couponGrantScheduleService.selectCouponGrantScheduleById(couponId);
		if(couponGrantSchedule==null){
			return "优惠券不存在!";
		}
		Date startDate = couponGrantSchedule.getGrantStartDate();
		Date endDate = couponGrantSchedule.getGrantEndDate();
		if(startDate.after(new Date())){
			return "此优惠券未发布!";
		}
		if(endDate.before(new Date())){
			return "此优惠券已经结束发布!";
		}
		int checkCoupon = checkCouponGrantSum(couponGrantSchedule,userId);
		if(1==checkCoupon){
			return "超过最大领取数!";
		}else if(2==checkCoupon){
			return "您已经领取过此优惠券!";
		}
		
		int tremType = couponGrantSchedule.getTermType();
		Date couponEffectiveStartData = new Date();
		Date couponEffectiveEndData = new Date();
		if(tremType==0){
			couponEffectiveStartData = couponGrantSchedule.getFixedStartDate();
			couponEffectiveEndData = couponGrantSchedule.getFixedEndDate();
		}else{
			couponEffectiveStartData  = new Date();
			couponEffectiveEndData = DateUtil.getApartDays(new Date(), couponGrantSchedule.getDynamicDate());
		}
		CouponUser couponUser = new CouponUser();
		couponUser.setUserId(userId);//
		couponUser.setCouponId(couponGrantSchedule.getCouponId());
		String couponLineNumber = UniqId.getInstance().getUuid();
		couponUser.setCouponLineNumber(couponLineNumber);
		couponUser.setCouponName(couponGrantSchedule.getCouponName());
		couponUser.setCouponType(couponGrantSchedule.getCouponType());
		couponUser.setCouponEffectiveStartData(couponEffectiveStartData);
		couponUser.setCouponEffectiveEndData(couponEffectiveEndData);
		couponUser.setScopeMarketId(couponGrantSchedule.getScopeMarketId());
		couponUser.setScopeMarketShopId(couponGrantSchedule.getScopeMarketShopId());
		couponUser.setCouponStatus(0);
		couponUserMapper.insert(couponUser);
		
		//更新当前已下发优惠券数量
		couponGrantSchedule.setGrantCurrentSum(couponGrantSchedule.getGrantCurrentSum()+1);
		couponGrantScheduleService.updateCouponGrantSchedule(couponGrantSchedule);
		
		return "优惠券编号:{"+couponId+"}已经下发给用户：{"+couponId+"}!";
	}

	@Override
	public String couponCheck(CouponUser couponUser) {
		CouponUser couponUserInfo =  couponUserMapper.selectByPrimaryKey(couponUser.getCouponLineNumber());
		if(couponUserInfo == null){
			return "此优惠券不存在";
		}
		//如果是只能在指定店铺使用
		if(!CommonUtil.isEmpty(couponUserInfo.getScopeMarketShopId())){
			if(!couponUserInfo.getScopeMarketShopId().equals(couponUser.getMerchantId())){
				return "请在指定店铺使用此优惠券";
			}
		}
		if(couponUserInfo.getCouponStatus()==1){
			return "此优惠券已经使用了";
		}else if(couponUserInfo.getCouponStatus()==2){
			return "此优惠券已经过期";
		}
		Date useDate = new Date();
		if(couponUserInfo.getCouponEffectiveStartData().after(useDate) || couponUserInfo.getCouponEffectiveEndData().before(useDate)){
			return "此优惠券不在有效使用期内";
		}
		//计算优惠金额
		CouponGrantSchedule couponGrantSchedule = couponGrantScheduleService.selectCouponGrantScheduleById(couponUserInfo.getCouponId());
		BigDecimal payAmount = BigDecimal.ZERO;
		BigDecimal fullAmount = couponUser.getFullAmount();
		String couponType = couponGrantSchedule.getCouponType();
		if("0".equals(couponType)){
			BigDecimal discountValue = couponGrantSchedule.getDiscountValue();
			payAmount = fullAmount.multiply(discountValue);
		}else if("1".equals(couponType)){
			payAmount =  couponGrantSchedule.getCashValue();
		}
		
		couponUserInfo.setMerchantId(couponUser.getMerchantId());
		couponUserInfo.setCouponStatus(1);
		couponUserInfo.setFullAmount(fullAmount);
		couponUserInfo.setCouponAmount(couponUser.getFullAmount().subtract(payAmount));
		couponUserInfo.setPayAmount(payAmount);
		couponUserInfo.setUseDate(useDate);
		couponUserMapper.updateByPrimaryKey(couponUserInfo);
		return couponUser.getCouponLineNumber();
	}
	/**
	 * 检查优惠券是否还有余量可领取
	 * @param couponGrantSchedule
	 * @return
	 */
	private int checkCouponGrantSum(CouponGrantSchedule couponGrantSchedule,String userId){
		int result = 0;
		//优惠券可下发总量
		int grantSum = couponGrantSchedule.getGrantSum();
		//当前已下发数量
		int grantCurrent = couponGrantSchedule.getGrantCurrentSum();
		if(grantSum>0 && grantSum <= grantCurrent){
			result = 1;
		}
		int limitcollarSum = couponGrantSchedule.getLimitcollarSum();
		if(limitcollarSum > 0){
			List<CouponUser> couponUserList =  couponUserExtMapper.selectCouponInfoByUserId(userId);
			int userCouponSum = couponUserList.size();
			if(limitcollarSum<=userCouponSum){
				result = 2;
			}
		}
		return result;
		
	}

	@Override
	public int updateUserCouponStatus() {
		return couponUserExtMapper.updateUserCouponStatus();
	}
}
