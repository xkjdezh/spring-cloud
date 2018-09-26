package com.bichuang.usercenter.service;

import java.util.List;
import java.util.Map;

import com.bichuang.platform.common.base.RespEntity;
import com.bichuang.platform.common.vo.ComContractVo;
import com.bichuang.platform.common.vo.RoleVo;
import com.bichuang.platform.common.vo.UserVoB;
import com.bichuang.usercenter.repository.model.BizType;
import com.bichuang.usercenter.repository.model.SysUserIdentity;

public interface UserService {

    public  SysUserIdentity  getById(int id);

    public Map<String, Object> canLogin(String tel, String password) ;

    public String getAgentById(Integer agentId);

    public Boolean  logout(String tel);

    public Map<String,String>  getAgentMap();

	public void saveRoleVo(RoleVo roleVo);

	public RespEntity saveUserVoB(UserVoB userVoB);

	public Map<String, Integer> updateUserVoB(UserVoB userVoB);
	
	public List<BizType> getBizTypeList();

	public RespEntity deleteUserById(String ids);

	public RespEntity queryUserListB(UserVoB userVoB);

	public RespEntity restPassword(UserVoB userVoB);
	
	public Map<String, String> getAgentsByNotBinding(String userId);
	
	public RespEntity queryUserBById(Integer id);

	public RespEntity editUserB(UserVoB userVoB);

	public Map<String, Object> isExistByTel(String tel,Integer sysId);

	public Boolean isBelongToAdSys(Integer userId, int sysId);

	public int queryUserIdByTel(String tel);

	public List<ComContractVo> selectYfCompanyList(ComContractVo comContractVo);

	public ComContractVo selectYfCompanyVo(ComContractVo comContractVo);

}
