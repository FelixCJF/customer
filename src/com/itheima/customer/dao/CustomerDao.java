package com.itheima.customer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.customer.domain.Customer;
import com.itheima.customer.utils.JDBCUtils;

public class CustomerDao {

	public int findCount(String name) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from customer where 1=1 ";
		List<Object> paramList = new ArrayList<Object>();
		if(name != null){
			sql+=" and name like ?";
			paramList.add("%"+name+"%");
		}
		
		Long num;
		try {
			num = (Long) queryRunner.query(sql, new ScalarHandler(),paramList.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return num.intValue();
	}

	public List<Customer> findByPage(String name,int begin, int pageSize) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from customer where 1=1";
		List<Object> paramList = new ArrayList<Object>();
		if(name != null){
			sql += " and name like ? ";
			paramList.add("%"+name+"%");
		}
		sql += " limit ?,?";
		paramList.add(begin);
		paramList.add(pageSize);
		List<Customer> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class), paramList.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

}
