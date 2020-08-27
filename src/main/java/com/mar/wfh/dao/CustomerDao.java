package com.mar.wfh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mar.wfh.modal.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

//	List<Customer> findAllcPassWordAndcEmail();

	
	@Query("SELECT c from Customer c where c.cName=:cname")
	public Customer getCustomerBycName(@Param("cname") String cname);
	
	
	  Customer findByCEmail(String email);
	    Customer findByCName(String userName);
	
	
}
