package com.bichuang.usercenter.repository.mapper.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bichuang.platform.common.vo.ComContractVo;
import com.bichuang.platform.common.vo.RoleVo;
import com.bichuang.platform.common.vo.UserVoB;
import com.bichuang.usercenter.repository.model.UserPopulousProB;


public interface UserPopulousProBExtMapper {

	List<UserPopulousProB> getAgents();

	void saveRoleVo(RoleVo roleVo);

	int isExistByRoleName(UserVoB userVoB);

	void saveBaseUserVo(UserVoB userVoB);

	void saveUserVoB(UserVoB userVoB);

	int isExistByUserMobile(UserVoB userVoB);

	void updateUserVoB(UserVoB userVoB);

	void saveUserAndRoleRelation(UserVoB userVoB);

	void updateBaseUserVo(UserVoB userVoB);

	void updateUserAndRoleRelation(UserVoB userVoB);

	void deleteUserVoById(Map<String,String> map);

	List<UserVoB> queryUserListB(UserVoB userVoB);

	void restPasswordByUserId(UserVoB userVoB);

	int isExistByMobile(String mobile);
	/**
	 * 鏍规嵁瀛楁鏄惁涓虹┖鎻掑叆B绔敤鎴�
	 * @author ZhangZeBiao
	 * @createTime 2018骞�3鏈�7鏃ヤ笂鍗�9:53:46
	 * @description 
	 * @param userVoB
	 * @return
	 */
	int insertUserVoBSelective(UserVoB userVoB);

	/**
	 * 鏍规嵁ID鑾峰彇鐢ㄦ埛
	 * @author ZhangZeBiao
	 * @createTime 2018骞�3鏈�7鏃ヤ笅鍗�4:45:20
	 * @description 
	 * @param id
	 * @return
	 */
	UserVoB queryUserBById(@Param("id") Integer id);

	/**
	 * 鏍规嵁涓婚敭鏇存柊鍚勪釜瀛楁
	 * @author ZhangZeBiao
	 * @createTime 2018骞�3鏈�7鏃ヤ笅鍗�7:58:18
	 * @description 
	 * @param userVoB
	 * @return
	 */
	int updateUserVoBByPrimaryKeySelective(UserVoB userVoB);
	
	/**
	 * 鏍规嵁鎵嬫満鍙峰垽鏂敤鎴锋槸鍚﹀瓨鍦�
	 * @param tel
	 * @return
	 */
	int isExistByTel(Map<String, Object> param);

	/**
	 * 鍒ゆ柇璇ョ敤鎴锋槸鍚﹀睘浜庡箍鍛婄郴缁�
	 * @param parm
	 * @return
	 */
	int isBelongToAdSys(Map<String, Object> parm);

	/**
	 * 鍒犻櫎鐢ㄦ埛绯荤粺鍏宠仈琛ㄦ暟鎹�
	 * @param ids
	 */
	void deleteUserSystemInletRef(Map<String, Object> parm);

	/**
	 * 鏌ヨ鐢ㄦ埛id
	 * @param tel
	 * @return
	 */
	int queryUserIdByTel(String tel);

	/**
	 * 鏌ヨ涔欐柟鍏徃鍚嶇О鍒楄〃
	 * @param comContractVo
	 * @return
	 */
	List<ComContractVo> selectYfCompanyList(ComContractVo comContractVo);

	/**
	 * 鏍规嵁鍏徃鍚嶇О鏌ヨ涔欐柟鍏徃鍏蜂綋淇℃伅
	 * @param comContractVo
	 * @return
	 */
	ComContractVo selectYfCompanyVo(ComContractVo comContractVo);
}