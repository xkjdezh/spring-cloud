package com.bichuang.repository.mapper.account;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.PageInfo;
  

/**
 * 
 * @类描述 mapper 的基础类，提供一些可继承的公用方法
 * @作者 meidf
 * @创建时间 2018.3.23
 */
public interface BaseMapper<T, PK> {
	
	int selectMaxId();
	
	T selectById(PK id);
	
	T selectByPrimaryKey(T record);
	
	int insert(T record);
	
	int insertSelective(T record);
	
	int updateByPrimaryKey(T record);
	
	int updateByPrimaryKeySelective(T record);
	
	int updateByIdSelective(T record);
	
	int deleteById(PK id);
	
	int deleteByPrimaryKey(PK id);
	
	PageInfo<T> selectAll(T record, RowBounds rowBounds);
  
}  
