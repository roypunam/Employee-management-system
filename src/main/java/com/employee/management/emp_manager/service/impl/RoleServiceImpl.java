package com.employee.management.emp_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.emp_manager.entity.RoleEntity;
import com.employee.management.emp_manager.repository.RoleRepo;
import com.employee.management.emp_manager.service.RoleService;

import lombok.extern.slf4j.Slf4j;


/**
 * <b>Role Service Implementation: It's provides implementation of 
 *  all the role related API's</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public RoleEntity createRole(RoleEntity role) {
		log.info("createRole service impl called.");
		RoleEntity newRole = roleRepo.save(role);
		return newRole;
	}

}
