/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.pojo.QueryVo.java
 * 创建者：@author bjx
 */
package com.it.crm.pojo;

//页面主题属性的包装类
public class QueryVo {
	
	//客户名称
	private String custName;
	//客户来源
	private String custSource;
	//客户级别
	private String custLevel;
	//所属行业
	private String custIndustry;
	
	//当前页
	private Integer page;
	//每页数
	private Integer size;
	
	//开始行
	private Integer startRow = 0;
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	
	

}
