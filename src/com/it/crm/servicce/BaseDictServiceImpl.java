/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.servicce.BaseDictService.java
 * 创建者：@author bjx
 */
package com.it.crm.servicce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.crm.mapper.BaseDictDao;
import com.it.crm.pojo.BaseDict;


@Service
public class BaseDictServiceImpl  implements BaseDictService{

	//注入dao
	@Autowired
	private BaseDictDao baseDictDao;
	
	@Override
	public List<BaseDict> queryBaseDictByCode(String code) {
		return baseDictDao.queryBaseDictByCode(code);
	}


	
	

}
