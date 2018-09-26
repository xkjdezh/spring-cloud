package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SystemInlet;

public interface SystemInletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemInlet record);

    int insertSelective(SystemInlet record);

    SystemInlet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemInlet record);

    int updateByPrimaryKey(SystemInlet record);
}