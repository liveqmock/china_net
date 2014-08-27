package com.neusoft.util;

import java.io.Serializable;

public class Page implements Serializable {
	/** ��ǰҳ */
	private int currentPage;
	/** ÿҳ��ʾ������ */
	private int pageSize;
	/** �ܵļ�¼�� */
	private int totalSize;
	/** �ܵ�ҳ�� */
	private int totalPage;
	/** �Ƿ��е�һҳ */
	private boolean hasFirst;
	/** �Ƿ�����һҳ */
	private boolean hasPrevious;
	/** �Ƿ�����һҳ */
	private boolean hasNext;
	/** �Ƿ������һҳ */
	private boolean hasLast;

	public Page() {

	}
    //��ʼ��
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
	 * �õ��ܵ�ҳ��
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
	 * �Ƿ��е�һҳ �����ǰҳ���Ѿ��ǵ�һҳ. ��ҳ���оͲ�����ʾ"��ҳ"��ʶ.
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
	 * �Ƿ�����һҳ �����ǰҳ���ǵ�һҳ. ����"��һҳ"��ʶ,��ʾ����.
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
	 * �Ƿ�����һҳ
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
	 * �Ƿ������һҳ �����ǰҳ�����ܵ�ҳ����ͬ,˵�������һҳ. ��ʱ"βҳ"��ǩ�ǲ���ʾ��
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
