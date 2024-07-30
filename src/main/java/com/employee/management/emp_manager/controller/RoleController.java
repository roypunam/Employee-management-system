package com.employee.management.emp_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.emp_manager.entity.RoleEntity;
import com.employee.management.emp_manager.service.RoleService;

import lombok.extern.slf4j.Slf4j;


/**
 * <b>Role Controller: It's contains all the role related API's.</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/add")
	public ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity role) {
		log.info("createRole API called.");
		RoleEntity createdRole = roleService.createRole(role);
		return new ResponseEntity<RoleEntity>(createdRole, HttpStatus.OK);
	}

	
}
