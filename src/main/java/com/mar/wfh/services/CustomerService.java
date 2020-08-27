package com.mar.wfh.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mar.wfh.dao.CustomerDao;
import com.mar.wfh.dao.RoleDao;
import com.mar.wfh.modal.Customer;
import com.mar.wfh.modal.Role;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private RoleDao roleDao;

	
	public Customer findByEmail(String email) {
		return customerDao.findByCEmail(email);
	}
	
	public Customer findByCname(String name) {
		
	return	customerDao.getCustomerBycName(name);
	}
	
	
	
	public Customer registerCustomer(Customer customer) {
		
		Set<Role> roles=new HashSet<>();
		Role role= new Role();
		role.setRoleName("USER");
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String getcPassWord = customer.getcPassWord();
		String encodePassword = encoder.encode(getcPassWord);

		customer.setcPassWord(encodePassword);
		customer.setcStatus(true);
		//role.setRoleName("USER");
		customer.setRoles(role);
		
	/*	Role customerRole = roleDao.findByRoleName("ADMIN");
		customer.setRoles(new HashSet<Role>(Arrays.asList(customerRole)));*/

		return customerDao.save(customer);
	}

	public List<Customer> findAll() {

		return customerDao.findAll();
	}

	public Customer getCustomerOnId(Integer id) {

		return customerDao.findOne(id);
	}

	public Customer findById(int id) {
		return customerDao.findOne(id);

	}

	public void deleteCustomer(Integer id) {

		customerDao.delete(id);

	}

	public void saveAddress(Customer customer) {
		
		customerDao.save(customer);
		
	}

}
