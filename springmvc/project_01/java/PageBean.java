package com.base.demo.pagebean;

import java.util.List;

public class PageBean<T> {
	/*
	 * 当前页
	 */
	private int currentPage;
	
	/*
	 * 每页显示的记录数
	 */
	
	private int pageSize;
	
	/*
	 * 总页数
	 */
	private int totalPage;
	
	
	
	/*
	 * 总的记录数
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
