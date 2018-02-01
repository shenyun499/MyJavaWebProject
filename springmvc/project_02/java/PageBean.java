package com.bbs.pagebean;

import java.util.List;

/**
 * 
 * @author ����ѧ
 *���ܣ�ʵ��һ����ҳ��
 */
public class PageBean<T> {
	/*
	 * ��ǰҳ
	 */
	private int currentPage;
	
	/*
	 * ҳ��
	 */
	private int pageSize;
	
	/*
	 * �ܼ�¼��
	 */
	private int totalRecord;
	
	/*
	 * ��ҳ��
	 */
	private int totalPage;
	
	private List<T> result;

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

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalRecord, int pageSize) {
		int totalPage = totalRecord / pageSize;
		this.totalPage = (totalRecord % pageSize) == 0 ? totalPage : totalPage + 1;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	

}
