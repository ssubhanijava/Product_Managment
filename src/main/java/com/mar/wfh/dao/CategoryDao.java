package com.mar.wfh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mar.wfh.modal.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

}
