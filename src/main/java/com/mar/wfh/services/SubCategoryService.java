package com.mar.wfh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.wfh.dao.SubCategoryDao;
import com.mar.wfh.modal.SubCategory;

@Service
public class SubCategoryService {

	@Autowired
	private SubCategoryDao subCategoryDao;

	public SubCategory registerCategory(SubCategory subCategory) {

		return subCategoryDao.save(subCategory);
	}

	public List<SubCategory> findAll() {
		// TODO Auto-generated method stub
		return subCategoryDao.findAll();
	}

	public SubCategory findById(long id) {
		// TODO Auto-generated method stub
		return subCategoryDao.findOne(id);
	}

	public void delete(SubCategory SubCategory) {
		subCategoryDao.delete(SubCategory);

	}

	public List<SubCategory> findByCat(String cat) {
		// TODO Auto-generated method stub
		return subCategoryDao.findByProductCategory(cat);
	}

}
