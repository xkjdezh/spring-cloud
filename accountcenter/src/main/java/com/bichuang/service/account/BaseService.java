package com.bichuang.service.account;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @description service 层基础类，提供增删改查的基本方法
 * @author meidf
 * @since 2018/03/26
 */

public interface BaseService<T, PK> {
	
	void setBaseMapper();

	/**
	 * 获取表自增列的 maxid 值
	 *  
	 * @return maxid
	 */
	int selectMaxId();

	/**
	 * 通过唯一序号 id 查询记录
	 * @param id 唯一序号，数据类型 Integer
	 * @return 得到实体类 entity
	 *  
	 */
	T selectById(PK id);
	
	/**
	 * 查询数据，by 主键
	 * @param record 包含主键数据的 实体类
	 * @return 实体类完整信息
	 *  
	 */
	T selectByPrimaryKey(T record);
	
	/**
	 * 插入数据
	 * @param record 完整的实体类 entity
	 * @return 影响的行数，1：表示插入成功
	 *  
	 */
	int insert(T record);

	/**
	 * 选择字段进行插入数据操作
	 * @param record 实体类 entity，可以是完整的或值包含部分field
	 * @return 影响的行数，1：表示插入成功
	 *  
	 */
	int insertSelective(T record);

	/**
	 * 更新数据，by 主键，选择性的更新部分 field
	 * @param record 实体类 entity
	 * @return 影响的行数，1：表示更新成功
	 * 
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * 更新数据，by 主键
	 * @param record 实体类 entity
	 * @return 影响的行数，1：表示更新成功
	 *  
	 */
	int updateByPrimaryKey(T record);

	/**
	 * 更新数据，by 唯一序号 id
	 * @param record 实体类 entity
	 * @return 影响的行数，1：表示更新成功
	 *  
	 */
	int updateByIdSelective(T record);

	/**
	 * 删除数据，by 序号 id
	 * @param id 唯一序号 id
	 * @return 影响行数，1：表示删除成功
	 * 
	 */
	int deleteById(PK id);

	/**
	 * 查询数据，对实体类 field 进行查询，并根据 rowBounds 参数进行分页
	 * @param record 实体类
	 * @param rowBounds 用户对数据进行物理分页，如：new RowBounds(1, 10) 表示第1页，每页10条数据
	 * @return List 数据
	 *  
	 */
	PageInfo<T> selectAll(T record, RowBounds rowBounds);	
}
