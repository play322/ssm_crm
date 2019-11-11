/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.mapper.BaseDictDao.java
 * 创建者：@author bjx
 */
package com.it.crm.mapper;

import java.util.List;

import com.it.crm.pojo.BaseDict;

public interface BaseDictDao {
	
	//查询
	public List<BaseDict> queryBaseDictByCode(String code);

}
