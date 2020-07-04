package com.doaa.springdemo.dao;

import java.util.List;

import com.doaa.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
