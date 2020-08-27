package com.mar.wfh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mar.wfh.dao.CategoryDao;
import com.mar.wfh.modal.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public Category registerCategory(Category category) {

		return categoryDao.save(category);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	public Category findById(long id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}

	public void delete(Category category) {
	categoryDao.delete(category);
		
	}

}
