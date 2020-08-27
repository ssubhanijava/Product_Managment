package com.mar.wfh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.SubCategory;
import java.lang.String;

@Repository
public interface SubCategoryDao extends JpaRepository<SubCategory, Long> {

List<SubCategory> findByProductCategory(String productcategory);
}
