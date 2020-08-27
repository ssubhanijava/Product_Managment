package com.mar.wfh.custometrSecuritDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mar.wfh.modal.Customer;
import com.mar.wfh.modal.Role;

public class MyCustomerDetails implements UserDetails {

	private Customer customer;

	public MyCustomerDetails(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Role roles = customer.getRoles();
		List<SimpleGrantedAuthority> authorites = new ArrayList<>();

		/*
		 * for(Role role:roles) { authorites.add(new
		 * SimpleGrantedAuthority(role.getRoleName())); }
		 */

		authorites.add(new SimpleGrantedAuthority(roles.getRoleName()));
		return authorites;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getcPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getcName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return customer.iscStatus();
	}

}
