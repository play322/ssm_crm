/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.servicce.CustomerService.java
 * 创建者：@author bjx
 */
package com.it.crm.servicce;

import com.it.crm.pojo.Customer;
import com.it.crm.pojo.QueryVo;
import com.it.crm.utils.Page;

public interface CustomerService {
	
	public Page<Customer> queryPageByQueryVo(QueryVo vo);

	public Customer findCustomerById(Integer id);
	
	//根据id修改客户
	public void updCustomerById(Customer customer);
	
	//删除客户
	public void deleteCustomer(Integer id);
}
