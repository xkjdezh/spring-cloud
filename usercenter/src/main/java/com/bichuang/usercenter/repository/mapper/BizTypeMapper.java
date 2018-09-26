package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.BizType;

public interface BizTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BizType record);

    int insertSelective(BizType record);

    BizType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizType record);

    int updateByPrimaryKey(BizType record);
}