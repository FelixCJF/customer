package com.itheima.customer.service;

import java.util.List;

import com.itheima.customer.dao.CustomerDao;
import com.itheima.customer.domain.Customer;
import com.itheima.customer.domain.PageBean;

public class CustomerService {

	public PageBean<Customer> findByPage(String name,int currPage) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setCurrPage(currPage);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		CustomerDao customerDao = new CustomerDao();
		int totalCount = customerDao.findCount(name);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize );
		pageBean.setTotalPage(num.intValue());
		int begin = (currPage -1)*pageSize;
		List<Customer> list = customerDao.findByPage(name,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

}
