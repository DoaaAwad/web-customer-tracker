package com.doaa.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.doaa.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject the sessionFactory to this Class 
	@Autowired
	private SessionFactory sessionFactory;		//sessionFactory is the bean id in config file

	@Override
	//@Transactional		//Automatically begin, commit transaction
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create query to get result list
		Query<Customer> query= currentSession.createQuery("from Customer order by firstName" ,Customer.class);
		
		//execute query and get result list
		List<Customer> customersList=query.getResultList();
		
		return customersList;
	}

	@Override		//@Transactional inside CustomerServiceImpl
	public void saveCustomer(Customer customer) {
		
		//get current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save customer
		currentSession.save(customer);
	}

	
}
