package com.mar.wfh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.wfh.dao.ProductDao;
import com.mar.wfh.dao.ProductJpa;
import com.mar.wfh.dao.SubCategoryDao;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.modal.product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductJpa productJpa;

	public product registerCategory(product product) {

		return productDao.save(product);
	}

	public List<product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	public product findById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.findOne(id);
	}

	public void delete(product product) {
		productDao.delete(product);

	}
	
	
	public List<product> getProductsBySubCat(String subCat) {
		return productJpa.findBypSubCat(subCat);
	}

	public product findProuctById(Integer id) {
		return productJpa.findByPid(id);
		
	}


	public product getProductByName(String pro) {
		return productJpa.findBypName(pro);
		
	}

	

	
	
	

}
