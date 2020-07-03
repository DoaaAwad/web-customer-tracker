package com.doaa.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doaa.springdemo.dao.CustomerDAO;
import com.doaa.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from dao
		List<Customer> customers=customerDAO.getCustomers();
		
		//add customers to the model
		model.addAttribute("customers" ,customers);
		
		return "list-customers";
	}

}
