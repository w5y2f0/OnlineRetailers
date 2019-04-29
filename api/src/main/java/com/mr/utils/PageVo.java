package com.mr.utils;

import java.util.List;

public class PageVo<T> {
	// ������
	private Long total;
	// ����
	private List<T> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public PageVo(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public PageVo() {
		super();
	}
	

}
