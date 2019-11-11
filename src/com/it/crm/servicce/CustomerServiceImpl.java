/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.servicce.CustomerServiceImpl.java
 * 创建者：@author bjx
 */
package com.it.crm.servicce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.crm.mapper.CustomerDao;
import com.it.crm.pojo.Customer;
import com.it.crm.pojo.QueryVo;
import com.it.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	//通过四个条件查询分页对象
	public Page<Customer> queryPageByQueryVo(QueryVo vo){
		
		Page<Customer> page = new Page<Customer>();
		//设置默认每页显示5条记录
		page.setSize(5);
		vo.setSize(5);
		//判断vo对象是否为空
		if(vo != null) {
			//判断当前页
			if(null!=vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			//判断客户名称
			if( null!=vo.getCustName() && !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			//判断客户来源
			if(null !=vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}
			//判断所属行业
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			//判断客户级别
			if(null !=vo.getCustLevel() && !"".equals(vo.getCustLevel().trim()) ) {
				vo.setCustLevel((vo.getCustLevel().trim()));
			}
			
			//设置总条数
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			page.setRows(customerDao.queryCustomerListByQueryVo(vo));
		}
		return page;
	}

	@Override
	public Customer findCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerById(id);
	}

	@Override
	public void updCustomerById(Customer customer) {
	
		customerDao.updCustomerById(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(id);
	}

}
