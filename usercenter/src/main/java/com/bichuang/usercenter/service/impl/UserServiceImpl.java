package com.bichuang.usercenter.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bichuang.platform.common.base.RespCode;
import com.bichuang.platform.common.base.RespEntity;
import com.bichuang.platform.common.vo.ComContractVo;
import com.bichuang.platform.common.vo.RoleVo;
import com.bichuang.platform.common.vo.UserVoB;
import com.bichuang.usercenter.repository.mapper.SysUserIdentityMapper;
import com.bichuang.usercenter.repository.mapper.UserBExtendAgentMapper;
import com.bichuang.usercenter.repository.mapper.UserPopulousProBMapper;
import com.bichuang.usercenter.repository.mapper.UserSystemInletRefMapper;
import com.bichuang.usercenter.repository.mapper.ext.BizTypeExtMapper;
import com.bichuang.usercenter.repository.mapper.ext.SysUserIdentityExtMapper;
import com.bichuang.usercenter.repository.mapper.ext.UserBExtendAgentExtMapper;
import com.bichuang.usercenter.repository.mapper.ext.UserPopulousProBExtMapper;
import com.bichuang.usercenter.repository.model.BizType;
import com.bichuang.usercenter.repository.model.SysUserIdentity;
import com.bichuang.usercenter.repository.model.UserBExtendAgent;
import com.bichuang.usercenter.repository.model.UserPopulousProB;
import com.bichuang.usercenter.repository.model.UserSystemInletRef;
import com.bichuang.usercenter.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class UserServiceImpl implements UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SysUserIdentityMapper sysUserIdentityMapper;
	
	@Autowired
	private SysUserIdentityExtMapper sysUserIdentityExtMapper;

	@Autowired
	private UserPopulousProBMapper userPopulousProBMapper;

	@Autowired
	private UserPopulousProBExtMapper userPopulousProBExtMapper;
	
	@Autowired
	private UserSystemInletRefMapper userSystemInletRefMapper;
	
	@Autowired
    private BizTypeExtMapper bizTypeExtMapper;
	
	@Autowired
	private UserBExtendAgentExtMapper userBExtendAgentExtMapper;
	
	@Autowired
	private UserBExtendAgentMapper userBExtendAgentMapper;

	public SysUserIdentity getById(int id) {
		return sysUserIdentityMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> canLogin(String tel, String password) {
		Map<String, Object> result=new HashMap<>();
		if (tel != null && password != null) {
			SysUserIdentity user = sysUserIdentityExtMapper.selectByMobile(tel,password);
			if(null != user){
				SysUserIdentity sysUserIdentity = new SysUserIdentity();
				sysUserIdentity.setId(user.getId());
				sysUserIdentity.setLastLoginTime(new Date());
				sysUserIdentityMapper.updateByPrimaryKeySelective(sysUserIdentity);
				UserPopulousProB userB = userPopulousProBMapper.selectByPrimaryKey(user.getId());
				result.put("user", user);
				result.put("userB", userB);
				return result;
			}
		}
		return null;
	}

	@Override
	public String getAgentById(Integer agentId) {
		if (agentId != null && agentId.intValue() > 0) {
			UserPopulousProB userPopulousProB = userPopulousProBMapper.selectByPrimaryKey(agentId);
			if (userPopulousProB != null) {
				return userPopulousProB.getCompanyName();
			}
		}
		return null;
	}

	@Override
	public Boolean logout(String tel) {
		return null;
	}

	@Override
	public Map<String, String> getAgentMap() {
		List<UserBExtendAgent> allAgent = userBExtendAgentExtMapper.getAllAgent();
		Map<String, String> results = new HashMap<>();
		for (UserBExtendAgent agent : allAgent) {
			results.put(agent.getId() + "", agent.getAgentName());
		}
		return results;
	}

	@Override
	public void saveRoleVo(RoleVo roleVo) {

		userPopulousProBExtMapper.saveRoleVo(roleVo);
	}

	@Override
	@Transactional
	public RespEntity saveUserVoB(UserVoB userVoB) {
		try {
			Date newDate = new Date();
			//是否有存在可用的手机号
			int result = userPopulousProBExtMapper.isExistByUserMobile(userVoB);
			
			if (result != 0) {
				return RespEntity.getRespEntityFail("用户已存在");
			} else {
				
				//系统表
				if(userVoB.getSystemInletId() == 1){//广告系统注册用户
					//判断表里是否有没有被删除该系统数据存在，如果没有则需要插入
					int rsult = sysUserIdentityExtMapper.isExistBySystemInletId(userVoB.getSystemInletId());
					if(rsult == 0){//如果没有数据存在，则插入一条数据
						sysUserIdentityExtMapper.saveSystemInlet(userVoB);
					}
				}
				
				//基本表
				SysUserIdentity sysUserIdentity=new SysUserIdentity();
				sysUserIdentity.setFristRegisteSystemId(userVoB.getSystemInletId());
				sysUserIdentity.setLoginName(userVoB.getLoginName());
				sysUserIdentity.setMobile(userVoB.getMobile());
				sysUserIdentity.setPassword(userVoB.getPassword());
				sysUserIdentity.setRegisteTime(newDate);
				sysUserIdentity.setType(true);
				sysUserIdentityExtMapper.insertSelectiveAndGetId(sysUserIdentity);
				
				//用户&系统关联表
				UserSystemInletRef userSystemInletRef=new UserSystemInletRef();
				userSystemInletRef.setCreateTime(newDate);
				userSystemInletRef.setSystemInletId(userVoB.getSystemInletId());
				userSystemInletRef.setUserId(sysUserIdentity.getId());
				userSystemInletRefMapper.insertSelective(userSystemInletRef);
				
				//B端用户静态数据之社会属性表
				//用户ID
				userVoB.setId(sysUserIdentity.getId());
				userPopulousProBExtMapper.insertUserVoBSelective(userVoB);
				
				//如果是代理商用户，则更新关联关系
				if (userVoB.getBizTypeId()==2) {
					UserBExtendAgent agent=new UserBExtendAgent();
					agent.setId(userVoB.getAgentId());
					agent.setUserId(sysUserIdentity.getId());
					userBExtendAgentMapper.updateByPrimaryKeySelective(agent);
				}
				return RespEntity.getRespEntitySuc(sysUserIdentity.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespEntity.getRespEntityError("系统出错，注册失败");
		}
	}

	@Override
	public Map<String, Integer> updateUserVoB(UserVoB userVoB) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		try {
			userPopulousProBExtMapper.updateBaseUserVo(userVoB);
			userPopulousProBExtMapper.updateUserVoB(userVoB);
			userPopulousProBExtMapper.updateUserAndRoleRelation(userVoB);

			resultMap.put("code", 1);
		} catch (Exception e) {
			logger.error("UserServiceImpl method updateUserVoB error: " + e.getMessage());
			resultMap.put("code", 3);
		}
		return resultMap;
	}

	@Override
	public List<BizType> getBizTypeList() {
		List<BizType> bizTypeAll = bizTypeExtMapper.getBizTypeAll();
		return bizTypeAll;
	}
	@Override
	@Transactional
	public RespEntity deleteUserById(String ids) {
		RespEntity resultResp = null;
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("ids", ids);
			//sysUserIdentityExtMapper.deleteUserById(map);
			userPopulousProBExtMapper.deleteUserSystemInletRef(map);
			resultResp = new RespEntity(RespCode.SUCCESS);
		} catch (Exception e) {
			logger.error("UserServiceImpl method deleteUserById error: " + e.getMessage());
			resultResp = new RespEntity(RespCode.ERROR);
		}
		return resultResp;
	}

	@Override
	public RespEntity queryUserListB(UserVoB userVoB) {
		RespEntity respEntity = null;
		try {
			PageHelper.startPage(userVoB.getPageNum(), userVoB.getPageSize());
			
			List<UserVoB> userList = userPopulousProBExtMapper.queryUserListB(userVoB);
			PageInfo<UserVoB> page2 = new PageInfo<UserVoB>(userList);
			respEntity = new RespEntity(RespCode.SUCCESS,page2);
		} catch (Exception e) {
			logger.error("UserServiceImpl method queryUserListB error: " + e.getMessage());
			respEntity = new RespEntity(RespCode.ERROR);
		}
		return respEntity;
	}

	@Override
	public RespEntity restPassword(UserVoB userVoB) {
		RespEntity respEntity = null;
		try {
			int falg = userPopulousProBExtMapper.isExistByMobile(userVoB.getMobile());
			if(falg > 0){
				userPopulousProBExtMapper.restPasswordByUserId(userVoB);
				respEntity = new RespEntity(RespCode.SUCCESS);
			}else{
				respEntity = new RespEntity();
				respEntity.setCode(1);
				respEntity.setMsg("帐号不存在");
			}
		} catch (Exception e) {
			logger.error("UserServiceImpl method restPassword error: " + e.getMessage());
			respEntity = new RespEntity(RespCode.ERROR);
		}
		return respEntity;
	}

	@Override
	public Map<String, String> getAgentsByNotBinding(String userId) {
		List<UserBExtendAgent> agents = userBExtendAgentExtMapper.getAgentListByNotBinding(userId);
		Map<String, String> results = new HashMap<>();
		for (UserBExtendAgent agent : agents) {
			results.put(agent.getId() + "", agent.getAgentName());
		}
		return results;
	}

	@Override
	public RespEntity queryUserBById(Integer id) {
		try {
			UserVoB userVoB = userPopulousProBExtMapper.queryUserBById(id);
			if (userVoB==null) {
				return RespEntity.getRespEntityFail("找不到用户,请刷新重试");
			}
			return RespEntity.getRespEntitySuc(userVoB);
		} catch (Exception e) {
			logger.error("UserServiceImpl method queryUserBById error: " + e.getMessage());
			return RespEntity.getRespEntityError("系统错误，请联系系统管理员");
		}
	}

	@Override
	@Transactional
	public RespEntity editUserB(UserVoB userVoB) {
		try {
			//基本表
			SysUserIdentity sysUserIdentity=new SysUserIdentity();
			sysUserIdentity.setId(userVoB.getId());
			sysUserIdentity.setFristRegisteSystemId(userVoB.getSystemInletId());
//			sysUserIdentity.setLoginName(userVoB.getLoginName());
//			sysUserIdentity.setMobile(userVoB.getMobile());
//			sysUserIdentity.setPassword(userVoB.getPassword());
			sysUserIdentity.setType(true);
			sysUserIdentityMapper.updateByPrimaryKeySelective(sysUserIdentity);
			//B端用户静态数据之社会属性表
			userPopulousProBExtMapper.updateUserVoBByPrimaryKeySelective(userVoB);
			
			//如果是代理商用户，则更新关联关系
			if (userVoB.getBizTypeId()==2) {
				UserBExtendAgent agent=new UserBExtendAgent();
				agent.setId(userVoB.getAgentId());
				agent.setUserId(sysUserIdentity.getId());
				userBExtendAgentMapper.updateByPrimaryKeySelective(agent);
			}
			return RespEntity.getRespEntitySuc(sysUserIdentity.getId());
		} catch (Exception e) {
			logger.error("UserServiceImpl method editUserB error: " + e.getMessage());
			return RespEntity.getRespEntityError("系统出错，注册失败");
		}
	}

	@Override
	public Map<String, Object> isExistByTel(String tel,Integer sysId) {
		Map<String,Object> reslut = new HashMap<String,Object>();
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("mobile", tel);
			param.put("systemInletId", sysId);
			int result = userPopulousProBExtMapper.isExistByTel(param);
			if(result > 0){
				reslut.put("code", "0");
				reslut.put("msg", "帐号存在");
			}else{
				reslut.put("code", "1");
				reslut.put("msg", "帐号不存在");
			}
			
		} catch (Exception e) {
			logger.error("UserServiceImpl method isExistByTel error: " + e.getMessage());
		}
		return reslut;
	}

	@Override
	public Boolean isBelongToAdSys(Integer userId, int sysId) {
		boolean flag = false;
		Map<String,Object> parm = new HashMap<String,Object>();
		parm.put("userId", userId);
		parm.put("sysId", sysId);
		try {
			int result = userPopulousProBExtMapper.isBelongToAdSys(parm);
			if(result > 0){
				flag = true; 
			}
		} catch (Exception e) {
			logger.error("UserServiceImpl method isBelongToAdSys error: " + e.getMessage());
		}
		return flag;
	}

	@Override
	public int queryUserIdByTel(String tel) {
		return userPopulousProBExtMapper.queryUserIdByTel(tel);
	}

	@Override
	public List<ComContractVo> selectYfCompanyList(ComContractVo comContractVo) {
		return userPopulousProBExtMapper.selectYfCompanyList(comContractVo);
	}

	@Override
	public ComContractVo selectYfCompanyVo(ComContractVo comContractVo) {
		return userPopulousProBExtMapper.selectYfCompanyVo(comContractVo);
	}

}
