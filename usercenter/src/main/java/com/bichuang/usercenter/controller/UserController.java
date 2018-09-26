package com.bichuang.usercenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bichuang.platform.common.base.RespCode;
import com.bichuang.platform.common.base.RespEntity;
import com.bichuang.platform.common.util.SystemInletEnum;
import com.bichuang.platform.common.vo.ComContractVo;
import com.bichuang.platform.common.vo.UserInfo;
import com.bichuang.platform.common.vo.UserVoB;
import com.bichuang.usercenter.repository.model.BizType;
import com.bichuang.usercenter.repository.model.SysUserIdentity;
import com.bichuang.usercenter.repository.model.UserPopulousProB;
import com.bichuang.usercenter.service.UserService;


@RestController("/usercenter")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/canLogin")
	public RespEntity canLogin(String tel, String password) {
		try {
			logger.info("  userCenter method canLogin param: {tel:{},password:{}}", tel, password);
			Map<String, Object> result = userService.canLogin(tel, password);
			if (null != result) {
				SysUserIdentity user = (SysUserIdentity) result.get("user");
				if (null != user) {
					boolean flag = userService.isBelongToAdSys(user.getId(), SystemInletEnum.AD.getId());
					if (flag) {
						UserPopulousProB userB = (UserPopulousProB) result.get("userB");
						UserInfo userInfo = new UserInfo();
						userInfo.setId(user.getId());
						userInfo.setTel(user.getLoginName());
						userInfo.setUserType(user.getType() ? 1 : 0);
						userInfo.setLastLoginTime(user.getLastLoginTime());
						userInfo.setQualificationsType(userB==null?null:userB.getQualificationsType());
						return RespEntity.getRespEntitySuc(userInfo);
					} else {
						return RespEntity.getRespEntityFail("璇ョ敤鎴蜂笉鏄箍鍛婄郴缁熺敤鎴�");
					}
				}else {
					return RespEntity.getRespEntityFail("鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒");
				}
			} else {
				return RespEntity.getRespEntityFail("璇ョ敤鎴蜂笉瀛樺湪");
			}
		} catch (Exception e) {
			logger.error(" userCenter method canLogin error:" + e.getMessage());
			return RespEntity.getRespEntityError("绯荤粺閿欒" + e.getMessage());
		}
	}

	@GetMapping("/getAgentById")
	public RespEntity getAgentById(Integer agentId) {
		RespEntity baseData;
		try {
			String agentCompanyName = userService.getAgentById(agentId);
			baseData = new RespEntity(RespCode.SUCCESS, agentCompanyName);
		} catch (Exception e) {
			logger.error(" userCenter method canLogin error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
			;
		}
		return baseData;
	}

	@GetMapping("/logout")
	public RespEntity logout(String tel) {
		RespEntity baseData;
		try {
			Boolean isLogout = userService.logout(tel);
			baseData = new RespEntity(RespCode.SUCCESS, isLogout);
		} catch (Exception e) {
			logger.error(" userCenter method canLogin error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
		}
		return baseData;
	}

	@GetMapping("/getAgentMap")
	public RespEntity getAgentMap() {
		RespEntity baseData;
		try {
			Map<String, String> agentCompanyNames = userService.getAgentMap();
			baseData = new RespEntity(RespCode.SUCCESS, agentCompanyNames);
		} catch (Exception e) {
			logger.error(" userCenter method canLogin error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
			;
		}
		return baseData;
	}

	/**
	 * 淇濆瓨B绔敤鎴�
	 * 
	 * @param roleVo
	 * @return
	 */
	@PostMapping(value = "/saveUserB")
	public RespEntity saveUserB(@RequestBody UserVoB userVoB) {
		RespEntity addFlagMap = userService.saveUserVoB(userVoB);
		return addFlagMap;
	}

	/**
	 * 淇敼B绔敤鎴�
	 * 
	 * @param userVoB
	 * @return
	 */
	@PostMapping(value = "/updateUserB")
	public RespEntity updateUserB(@RequestBody UserVoB userVoB) {
		Map<String, Integer> addFlagMap = userService.updateUserVoB(userVoB);
		RespEntity baseData = null;
		Integer resultFag = (Integer) addFlagMap.get("code");
		if (resultFag == 1) {
			baseData = new RespEntity(RespCode.SUCCESS);
		} else {
			baseData = new RespEntity(RespCode.ERROR);
		}
		return baseData;
	}

	/**
	 * 鍒犻櫎B绔敤鎴�
	 * 
	 * @param userVoB
	 * @return
	 */
	@PostMapping(value = "/deleteUserById")
	public RespEntity deleteUserById(@RequestBody UserVoB userVoB) {
		RespEntity baseData = userService.deleteUserById(userVoB.getIds());
		return baseData;
	}

	@GetMapping("/getBizTypeList")
	public RespEntity getBizTypeList() {
		try {
			logger.info("  userCenter method getBizTypeList : ");
			List<BizType> bizTypes = userService.getBizTypeList();
			Map<String, String> map = new HashMap<String, String>();
			for (BizType bizType : bizTypes) {
				map.put("id", bizType.getId().toString());
				map.put("bizTypeCode", bizType.getBizTypeCode());
				map.put("bizTypeName", bizType.getBizTypeName());
			}
			return RespEntity.getRespEntitySuc(map);
		} catch (Exception e) {
			logger.error(" userCenter method canLogin error:" + e.getMessage());
			return RespEntity.getRespEntityError(null);
		}
	}

	/**
	 * 鏌ヨB绔敤鎴峰垪琛�
	 * 
	 * @param userVoB
	 * @return
	 */
	@PostMapping(value = "/queryUserListB")
	public RespEntity queryUserListB(@RequestBody UserVoB userVoB) {
		RespEntity baseData = userService.queryUserListB(userVoB);
		return baseData;
	}

	/**
	 * 閲嶇疆鐢ㄦ埛瀵嗙爜
	 * 
	 * @param userVoB
	 * @return
	 */
	@PostMapping(value = "/restPassword")
	public RespEntity restPassword(@RequestBody UserVoB userVoB) {
		RespEntity baseData = userService.restPassword(userVoB);
		return baseData;
	}

	@GetMapping("/getAgentsByNotBinding")
	public RespEntity getAgentsByNotBinding(String userId) {
		RespEntity baseData;
		try {
			Map<String, String> agentCompanyNames = userService.getAgentsByNotBinding(userId);
			baseData = new RespEntity(RespCode.SUCCESS, agentCompanyNames);
		} catch (Exception e) {
			logger.error(" userCenter method canLogin error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
			;
		}
		return baseData;
	}

	@GetMapping("/queryUserBById")
	public RespEntity queryUserBById(Integer id) {
		logger.info("  userCenter method canLogin param: {id:{}}", id);
		if (id == null) {
			return RespEntity.getRespEntityFail("鍙傛暟涓嶈兘涓虹┖");
		}
		RespEntity user = userService.queryUserBById(id);
		return user;
	}

	/**
	 * 淇敼B绔敤鎴�
	 * 
	 * @param roleVo
	 * @return
	 */
	@PostMapping(value = "/editUserB")
	public RespEntity editUserB(@RequestBody UserVoB userVoB) {
		RespEntity entity = userService.editUserB(userVoB);
		return entity;
	}

	/**
	 * 鍒ゆ柇鐢ㄦ埛鏄惁瀛樺湪
	 * 
	 * @param tel
	 * @return
	 */
	@GetMapping("/isExistByTel")
	public RespEntity isExistByTel(String tel,Integer sysId) {
		RespEntity baseData = null;
		try {
			Map<String, Object> map = userService.isExistByTel(tel,sysId);
			baseData = new RespEntity(RespCode.SUCCESS, map);
		} catch (Exception e) {
			logger.error(" userCenter method isExistByTel error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
			;
		}
		return baseData;
	}

	/**
	 * 鑾峰彇涔欐柟鍏徃鍚嶇О鍒楄〃
	 * 
	 * @param comContractVo
	 * @return
	 */
	@PostMapping("/findYfCompanyList")
	public RespEntity findYfCompanyList(@RequestBody ComContractVo comContractVo) {
		RespEntity baseData = null;
		try {
			List<ComContractVo> list = userService.selectYfCompanyList(comContractVo);
			baseData = new RespEntity(RespCode.SUCCESS, list);
		} catch (Exception e) {
			logger.error(" userCenter method findYfCompanyList error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
			;
		}
		return baseData;
	}
	
	/**
	 * 鏍规嵁鍏徃鍚嶇О鏌ヨ鍏蜂綋鐨勪箼鏂瑰叕鍙镐俊鎭�
	 * @param comContractVo
	 * @return
	 */
	@PostMapping("/findYfCompanyVo")
	public RespEntity findYfCompanyVo(@RequestBody ComContractVo comContractVo) {
		RespEntity baseData = null;
		try {
			ComContractVo info = userService.selectYfCompanyVo(comContractVo);
			return RespEntity.getRespEntitySuc(info);
		} catch (Exception e) {
			logger.error(" userCenter method findYfCompanyVo error:" + e.getMessage());
			baseData = new RespEntity(RespCode.ERROR);
			;
		}
		return baseData;
	}
	
}
