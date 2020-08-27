package com.mar.wfh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mar.wfh.modal.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
	
 public	Role findByRoleName(String role);

}
