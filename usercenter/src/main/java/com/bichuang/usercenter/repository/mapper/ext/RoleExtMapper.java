package com.bichuang.usercenter.repository.mapper.ext;

import java.util.Map;

import com.bichuang.platform.common.vo.RoleVo;



public interface RoleExtMapper {

	void saveRoleVo(RoleVo roleVo);

	int updateRoleVo(RoleVo roleVo);

	int isExistByRoleName(RoleVo roleVo);

	void saveAuth(Map<String, Object> param);

	void deleteRoleAndAuthInfo(String id);

	void deleteAuth(String valueOf);

}
