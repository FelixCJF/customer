package com.itheima.customer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.customer.domain.Customer;
import com.itheima.customer.domain.PageBean;
import com.itheima.customer.service.CustomerService;

public class CustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收当前页数:
		String page = request.getParameter("currPage");
		int currPage = 0;
		if(page != null){
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}else{
			currPage=1;
		}
		
		String name = request.getParameter("name");
		CustomerService customerService = new CustomerService();
		PageBean<Customer> pageBean = customerService.findByPage(name,currPage);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
