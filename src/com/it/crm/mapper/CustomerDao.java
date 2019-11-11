/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.mapper.BaseDictDao.java
 * 创建者：@author bjx
 */
package com.it.crm.mapper;

import java.util.List;

import com.it.crm.pojo.Customer;
import com.it.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//查询总记录数
	public Integer customerCountByQueryVo(QueryVo vo);
	
	//查询结果集
	public List<Customer> queryCustomerListByQueryVo(QueryVo vo);
	
	//根据id查询客户
	public Customer findCustomerById(Integer id);
	
	//根据id修改客户
	public void updCustomerById(Customer customer);
	
	//删除客户
	public void deleteCustomer(Integer id);

}
