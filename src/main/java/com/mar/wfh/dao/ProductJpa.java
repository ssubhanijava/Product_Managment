package com.mar.wfh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mar.wfh.modal.product;



public interface ProductJpa extends JpaRepository<product, Integer> {

//	List<ProductMaster> findProductsBySubCategory(String subCategories);
	List<product> findBypSubCat(String pSubCat);

	product findByPid(Integer id);

	product findBypName(String pro);

}