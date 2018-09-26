package com.bichuang.platform.common.base;

/**
 * 基础信息
 *
 * @author liuzh
 * @since 2016-01-31 21:42
 */

public class BaseEntity {
	
    private Integer pageNum  = 1;

    private Integer pageSize = 15;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
