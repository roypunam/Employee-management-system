package com.employee.management.emp_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.emp_manager.dto.RoleDto;
import com.employee.management.emp_manager.exception.RoleExistException;
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
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) throws RoleExistException {
		log.info("createRole API called.");
		RoleDto createdRole = roleService.createRole(roleDto);
		return new ResponseEntity<RoleDto>(createdRole, HttpStatus.OK);
	}
	
//	@PostMapping("/change/role")
//	@PreAuthorize("hasAuthority('ADMIN')")
//	public ResponseEntity<RoleDto> changeRole(@RequestBody RoleDto roleDto, String id){
//		log.info("changeRole API called.");
//		RoleDto updatedRole=roleService.changeRole(roleDto,id);
//		return new ResponseEntity<RoleDto>(updatedRole,HttpStatus.OK);
//		
//	}
	

	
}
