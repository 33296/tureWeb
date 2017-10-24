package com.shop.bean;

import java.util.List;

public class Page {
	private int curPage = 1;		//当前页
	private int pageCount;			//总页数
	private int startIndex;			//起始下标
	private int pageSize = 1;		//页面大小
	private int count;				//总条数
	private Object[] objs;			//传递的参数
	private List objList;			//查到的对象集合
	
	//当前页
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
		
		//计算起始下标
//		this.startIndex = (curPage-1)*pageSize;
	}
	
	//总页数
	public int getPageCount() {
		return pageCount;
	}
	
	//起始下标
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int pageSize) {
		this.startIndex = (curPage-1)*pageSize;		//根据页面大小计算起始下标
	}
	
	//页面大小
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//总条数
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		
		//计算总页数
		this.pageCount = count%pageSize == 0 ? count/pageSize:count/pageSize+1;
	}
	
	//传递的参数
	public Object[] getObjs() {
		return objs;
	}
	public void setObjs(Object[] objs) {
		this.objs = objs;
	}
	
	//查到的对象集合
	public List getObjList() {
		return objList;
	}
	public void setObjList(List objList) {
		this.objList = objList;
	}
	
}
