package com.employee.management.emp_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.emp_manager.dto.RoleDto;
import com.employee.management.emp_manager.entity.RoleEntity;
import com.employee.management.emp_manager.exception.RoleExistException;
import com.employee.management.emp_manager.repository.RoleRepo;
import com.employee.management.emp_manager.service.RoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * <b>Role Service Implementation: It's provides implementation of all the role
 * related API's</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepo roleRepo;

//	@Autowired
//	private EmployeeRepo employeeRepo;

	@Override
	public RoleDto createRole(RoleDto roleDto) throws RoleExistException {
		log.info("createRole service impl called.");
		RoleEntity existRole = roleRepo.findById(roleDto.getRoleId()).orElse(null);
		if (existRole == null) {
			RoleEntity role = RoleDto.getRole(roleDto);
			RoleEntity newRole = roleRepo.save(role);
			RoleDto savedRole = RoleEntity.getRoleDto(newRole);
			return savedRole;
		} else {
			throw new RoleExistException("Role already exist with this role id: " + existRole.getRoleId());
		}
	}

//	@Override
//	public RoleDto changeRole(RoleDto roleDto,String id) {
//		EmployeeEntity employee = employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee", "empId", id));
//		RoleEntity role = roleRepo.findById(Integer.valueOf(RoleEnum.ADMIN.getValue())).get();
//		employee.setRoleList();
//		return null;
//	}

}
