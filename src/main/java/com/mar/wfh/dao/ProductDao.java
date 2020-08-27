package com.mar.wfh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mar.wfh.modal.product;

public interface ProductDao extends JpaRepository<product, Integer> {

}
