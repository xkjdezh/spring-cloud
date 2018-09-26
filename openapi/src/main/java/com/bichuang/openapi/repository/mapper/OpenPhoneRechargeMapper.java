package com.bichuang.openapi.repository.mapper;

import com.bichuang.openapi.repository.model.OpenPhoneRecharge;
import com.bichuang.openapi.repository.model.OpenPhoneRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenPhoneRechargeMapper {
    long countByExample(OpenPhoneRechargeExample example);

    int deleteByExample(OpenPhoneRechargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenPhoneRecharge record);

    int insertSelective(OpenPhoneRecharge record);

    List<OpenPhoneRecharge> selectByExample(OpenPhoneRechargeExample example);

    OpenPhoneRecharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenPhoneRecharge record, @Param("example") OpenPhoneRechargeExample example);

    int updateByExample(@Param("record") OpenPhoneRecharge record, @Param("example") OpenPhoneRechargeExample example);

    int updateByPrimaryKeySelective(OpenPhoneRecharge record);

    int updateByPrimaryKey(OpenPhoneRecharge record);
}