package com.employee.management.emp_manager.service;

import com.employee.management.emp_manager.dto.RoleDto;
import com.employee.management.emp_manager.exception.RoleExistException;

/**
 * <b>Role Service</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
public interface RoleService {

	RoleDto createRole(RoleDto roleDto) throws RoleExistException;


//	RoleDto changeRole(RoleDto roleDto, String id);

}
