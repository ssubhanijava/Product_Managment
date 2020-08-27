package com.mar.wfh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mar.wfh.modal.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

/*	@Query(value="select d.aId, d.adresss,d.city, d.district,d.State, d.pincode FROM Customer c INNER JOIN Address d ON c.cid = d.Customer_id")
	public Address findByCustomerId(int id);*/

}
