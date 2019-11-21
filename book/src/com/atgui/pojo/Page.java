package com.atgui.pojo;

import java.util.List;

public class Page<T> {
	public static final Integer PAGE_SIZE = 4;
	private Integer pageNo;
	private Integer pageTotal;
	private Integer pageTotalCount;
	private List<T> Items;
	private Integer pageSize=PAGE_SIZE;
	private String pageUrl;
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public Page(Integer pageNo, Integer pageTotal, Integer pageTotalCount, List<T> items, Integer pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageTotal = pageTotal;
		this.pageTotalCount = pageTotalCount;
		Items = items;
		this.pageSize = pageSize;
	}
	public Page() {
		super();
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		if(pageNo<=0) {
			this.pageNo=1;
		}else if(pageNo>this.pageTotal) {
			this.pageNo=this.pageTotal;
		}else {
			this.pageNo = pageNo;
		}
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<T> getItems() {
		return Items;
	}
	public void setItems(List<T> items) {
		Items = items;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageTotalCount=" + pageTotalCount + ", Items="
				+ Items + ", pageSize=" + pageSize + ", pageUrl=" + pageUrl + "]";
	}
	

}
