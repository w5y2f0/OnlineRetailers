package com.mr.utils;

public class Page {
	// ��ǰҳ
	private Integer page = 1;
	// ÿҳ����
	private Integer rows = 5;
	
	//������ֶ���
	private String sort;
	//����ʽ
	private String order = "desc";

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}	
	

}
