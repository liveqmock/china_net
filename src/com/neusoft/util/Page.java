package com.neusoft.util;

import java.io.Serializable;

public class Page implements Serializable {
	/** 当前页 */
	private int currentPage;
	/** 每页显示的数据 */
	private int pageSize;
	/** 总的记录数 */
	private int totalSize;
	/** 总的页数 */
	private int totalPage;
	/** 是否有第一页 */
	private boolean hasFirst;
	/** 是否有上一页 */
	private boolean hasPrevious;
	/** 是否有下一页 */
	private boolean hasNext;
	/** 是否有最后一页 */
	private boolean hasLast;

	public Page() {

	}
    //初始化
	public Page(int currentPage, int pageSize, int totalSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 得到总的页数
	 */
	public int getTotalPage() {
		totalPage = totalSize / pageSize;
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 是否有第一页 如果当前页面已经是第一页. 在页面中就不再显示"首页"标识.
	 * @return
	 */
	public boolean isHasFirst() {
		if (currentPage == 1) {
			return false;
		}
		return true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	/**
	 * 是否有上一页 如果当前页不是第一页. 就让"上一页"标识,显示出来.
	 * @return
	 */
	public boolean isHasPrevious() {
		if (isHasFirst()) {
			return true;
		}
		return false;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	/**
	 * 是否有下一页
	 * @param hasNext
	 */
	public boolean isHasNext() {
		if (isHasLast()) {
			return true;
		}
		return false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	/**
	 * 是否有最后一页 如果当前页数和总的页面相同,说明是最后一页. 这时"尾页"标签是不显示的
	 * @return
	 */
	public boolean isHasLast() {
		if (currentPage == getTotalPage()) {
			return false;
		}
		return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}
