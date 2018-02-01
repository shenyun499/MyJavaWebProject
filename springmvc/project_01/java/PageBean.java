package com.base.demo.pagebean;

import java.util.List;

public class PageBean<T> {
	/*
	 * ��ǰҳ
	 */
	private int currentPage;
	
	/*
	 * ÿҳ��ʾ�ļ�¼��
	 */
	
	private int pageSize;
	
	/*
	 * ��ҳ��
	 */
	private int totalPage;
	
	
	
	/*
	 * �ܵļ�¼��
	 */
	private int totalRecord;
	
	private List<T> results;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public void setTotalPage(int totalRecord, int pageSize ) {
		if (totalRecord % pageSize == 0) {
			this.totalPage = totalRecord / pageSize;
		} else {
			this.totalPage = totalRecord /pageSize +1;
		}
	}



	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
	}



	public List<T> getResults() {
		return results;
	}



	public void setResults(List<T> results) {
		this.results = results;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public int getPageSize() {
		return pageSize;
	}



	public int getTotalPage() {
		return totalPage;
	}



	public int getTotalRecord() {
		return totalRecord;
	}
	
	
	
}
