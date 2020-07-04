package com.doaa.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doaa.springdemo.entity.Customer;
import com.doaa.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from dao
		List<Customer> customers=customerService.getCustomers();
		
		//add customers to the model
		model.addAttribute("customers" ,customers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//Add model attribute to bind form data
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return"redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id , Model model) {
		
		//get customer from customer service by customer id 
		Customer customer=customerService.getCustomer(id);
		
		//set customer as a model attribute to pre-populate form 
		model.addAttribute("customer", customer);
		
		//send customer to form
		return "customer-form";
	}
}
