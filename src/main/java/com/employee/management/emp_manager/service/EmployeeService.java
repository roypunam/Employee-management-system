package com.employee.management.emp_manager.service;

import java.util.List;

import com.employee.management.emp_manager.dto.DeleteResponse;
import com.employee.management.emp_manager.dto.EmployeeDtoRequest;
import com.employee.management.emp_manager.dto.EmployeeDtoResponse;
import com.employee.management.emp_manager.dto.LoginRequest;
import com.employee.management.emp_manager.exception.EmployeeExistException;

/**
 * <b>Role Service</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
public interface EmployeeService {

	public EmployeeDtoResponse registerEmployee(EmployeeDtoRequest empDto) throws EmployeeExistException;
	
	public List<EmployeeDtoResponse> getAllEmployee();
	
	public EmployeeDtoResponse getEmployee(String id);

	public EmployeeDtoResponse updateEmployeeDetails(EmployeeDtoRequest empDto, String id);

	public DeleteResponse deleteEmployee(String id);

	public String login(LoginRequest loginRequest);
	
	public EmployeeDtoResponse changeRole(String id);
}
