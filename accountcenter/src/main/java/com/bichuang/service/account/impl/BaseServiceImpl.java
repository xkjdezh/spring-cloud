package com.bichuang.service.account.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bichuang.repository.mapper.account.BaseMapper;
import com.bichuang.service.account.BaseService;
import com.github.pagehelper.PageInfo;

public abstract class BaseServiceImpl<T, PK> implements BaseService<T, PK> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected static Lock lock = new ReentrantLock();
	
	protected BaseMapper<T, PK> baseMapper;

	public void setBaseMapper(BaseMapper<T, PK> baseMapper) {
		this.baseMapper = baseMapper;
	}

	public int selectMaxId() {  
		return baseMapper.selectMaxId();
	}

	public T selectById(PK id) {
		return baseMapper.selectById(id);
	}

	public T selectByPrimaryKey(T record) {
		return baseMapper.selectByPrimaryKey(record);
	}

	public int insert(T record) {
		return baseMapper.insert(record);
	}

	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByIdSelective(T record) {
		return baseMapper.updateByIdSelective(record);
	}

	public int deleteById(PK id) {
		return baseMapper.deleteById(id);
	}

	public PageInfo<T> selectAll(T record, RowBounds rowBounds) {
		return baseMapper.selectAll(record, rowBounds);
	}
}
