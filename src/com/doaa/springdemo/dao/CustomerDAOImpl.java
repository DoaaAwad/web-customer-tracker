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
	public void saveCustomer(Customer mCustomer) {
		
		//get current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save or update customer
		currentSession.saveOrUpdate(mCustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//retrieve object from database using id
		Customer cust=currentSession.get(Customer.class , id);
		
		return cust;
	}

	@Override
	public void deleteCustomer(int id) {
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//delete customer 
		Query query=currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String sName) {
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query query=null;
		
		//Search if search name!=null
		if(sName!=null && sName.trim().length()>0) {
			query=currentSession.createQuery("from Customer where lower(firstName) like :sName or lower(lastName) like :sName" , Customer.class);
			query.setParameter("sName",  "%" + sName.toLowerCase() + "%");
		}
		
		else
			query=currentSession.createQuery("from Customer" , Customer.class);
		
		return query.getResultList();
	}
	
}