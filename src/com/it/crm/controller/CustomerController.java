/**
 * 创建时间：2019年8月31日
 * 所在包：com.it.crm.controller.CustomerController.java
 * 创建者：@author bjx
 */
package com.it.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.crm.pojo.BaseDict;
import com.it.crm.pojo.Customer;
import com.it.crm.pojo.QueryVo;
import com.it.crm.servicce.BaseDictService;
import com.it.crm.servicce.CustomerService;
import com.it.crm.utils.Page;

@Controller
public class CustomerController {
	
	//注入service
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	/*
	 *把查询的条件放到properties文件中，解决硬编码问题
	 *把properties文件中的key值作为成员变量注入进来 
	 */
	//注入key值
	@Value("${industryType.code}")
	private String industryTypeCode;
	
	@Value("${fromType.code}")
	private String fromTypeCode;
	
	@Value("${levelType.code}")
	private String levelTypeCode;

	
	//查询
	@RequestMapping(value="/customer/list")
	public String toCustomer(QueryVo vo,Model model) {
		
		List<BaseDict> industryType = baseDictService.queryBaseDictByCode(industryTypeCode);
		List<BaseDict> fromType = baseDictService.queryBaseDictByCode(fromTypeCode);
		List<BaseDict> levelType = baseDictService.queryBaseDictByCode(levelTypeCode);
	
		model.addAttribute("industryType", industryType);
		model.addAttribute("fromType", fromType);
		model.addAttribute("levelType", levelType);
		
		//通过四个条件查询分页对象
		Page<Customer> page = customerService.queryPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}

	//去修改页面
	@ResponseBody
	@RequestMapping(value="/customer/edit.action")
	public Customer edit(Integer id) {
		return customerService.findCustomerById(id);
	}
	
	//修改
	@ResponseBody
	@RequestMapping(value="/customer/update.action")
	public String update(Customer customer) {
		customerService.updCustomerById(customer);
		return "OK";
	}

	//删除
	@ResponseBody
	@RequestMapping(value="/customer/delete.action")
	public String del(Integer id) {
		customerService.deleteCustomer(id);
		return "ok";
	}
	
}
