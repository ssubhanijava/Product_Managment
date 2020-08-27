package com.mar.wfh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.wfh.dao.AddressDao;
import com.mar.wfh.dao.CustomerDao;
import com.mar.wfh.modal.Address;
import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.Customer;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public List<Address> registerCategory(List<Address> addre) {

		return addressDao.save(addre);
	}

	public Address findById(Integer id) {
		// TODO Auto-generated method stub
		return addressDao.findOne(id);
	}

	public Address findBycustomerid(int id) {
		// return addressDao.findByCustomerId(id);
		return null;
	}

	public List<Address> findAll() {
		List<Address> findAll = addressDao.findAll();
		return findAll;
	}

	public Address findByCustomerId(Integer cid) {
		return addressDao.findOne(cid);
	}

	/*
	 * public Address findBycustomerid(Integer id) { return
	 * addressDao.findByCustomerId(id); //return null; }
	 */

	public Address saveAddress(Address address) {

		return addressDao.save(address);
	}

}
