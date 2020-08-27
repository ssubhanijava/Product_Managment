package com.mar.wfh.custometrSecuritDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mar.wfh.dao.CustomerDao;
import com.mar.wfh.modal.Customer;
import com.mar.wfh.modal.Role;
import com.mar.wfh.services.CustomerService;

public class CustomerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CustomerService customerService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer customer = customerDao.findByCEmail(username);

		if (customer == null) {

			throw new UsernameNotFoundException("could not find customer");

		}

		/*
		 * List<GrantedAuthority> authorities = getUserAuthority(customer.getRoles());
		 * return buildUserForAuthentication(customer, authorities);
		 */

		return new MyCustomerDetails(customer);

	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(Customer customer, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(customer.getcName(), customer.getcPassWord(),
				customer.iscStatus(), true, true, true, authorities);
	}
}
