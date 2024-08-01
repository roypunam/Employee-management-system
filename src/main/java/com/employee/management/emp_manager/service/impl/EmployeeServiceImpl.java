package com.employee.management.emp_manager.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.management.emp_manager.dto.DeleteResponse;
import com.employee.management.emp_manager.dto.EmployeeDtoRequest;
import com.employee.management.emp_manager.dto.EmployeeDtoResponse;
import com.employee.management.emp_manager.dto.LoginRequest;
import com.employee.management.emp_manager.dto.RoleEnum;
import com.employee.management.emp_manager.entity.EmployeeEntity;
import com.employee.management.emp_manager.entity.RoleEntity;
import com.employee.management.emp_manager.exception.EmployeeExistException;
import com.employee.management.emp_manager.exception.EmployeeNotFoundException;
import com.employee.management.emp_manager.repository.EmployeeRepo;
import com.employee.management.emp_manager.repository.RoleRepo;
import com.employee.management.emp_manager.service.EmployeeService;
import com.employee.management.emp_manager.service.JwtService;

import lombok.extern.slf4j.Slf4j;

/**
 * <b>Employee Service Implementation: It's provides implementation of all the
 * employee related API's</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public EmployeeDtoResponse registerEmployee(EmployeeDtoRequest empDto) throws EmployeeExistException {

		log.info("registerEmployee service impl called.");
		// Check user already exists
		EmployeeEntity oldEmployee = employeeRepo.findById(empDto.getEmpId()).orElse(null);
		if (oldEmployee == null) {
			// DTO to EmployeeEntity conversion
			EmployeeEntity emp = EmployeeDtoRequest.getEmployee(empDto);
			emp.setPassword(passwordEncoder.encode(empDto.getPassword()));

			// Database called
			RoleEntity role = roleRepo.findById(Integer.valueOf(RoleEnum.ADMIN.getValue())).get();
			emp.getRoleList().add(role);

			// saved to database
			EmployeeEntity newEmployee = employeeRepo.save(emp);
			return EmployeeEntity.getEmployeeDtoResponse(newEmployee);
		} else {
			throw new EmployeeExistException("Employee already exist with this employee id: " + oldEmployee.getEmpId());
		}
	}

	@Override
	public String login(LoginRequest loginRequest) {
		
		//Authenticate credentials
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmpId(), loginRequest.getPassword()));

			return jwtService.generateToken(loginRequest.getEmpId());
		} catch (Exception e) {
			log.error("Error in login method:" + e.getMessage());
			throw new EmployeeNotFoundException("Employee", "Employee ID", loginRequest.getEmpId());
		}
	}

	@Override
	public EmployeeDtoResponse updateEmployeeDetails(EmployeeDtoRequest empDto, String id) {
		log.info("updateEmployeeDetails service impl called.");

		// Database called

		EmployeeEntity employee = employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee", "empId", id));
		employee.setEmpId(empDto.getEmpId());
		employee.setEmpName(empDto.getEmpName());
		employee.setEmpDob(empDto.getEmpDob());
		employee.setEmpSalary(empDto.getEmpSalary());
		employee.setPassword(passwordEncoder.encode(empDto.getPassword()));
		// Update details saved
		EmployeeEntity updateInfo = employeeRepo.save(employee);

		// EmployeeEntity to DTO conversion
		EmployeeDtoResponse response = EmployeeEntity.getEmployeeDtoResponse(updateInfo);
		return response;
	}

	@Override
	public List<EmployeeDtoResponse> getAllEmployee() {
		log.info("getAllEmployee service impl called.");

		// Database called
		List<EmployeeEntity> list = employeeRepo.findAll();

		// EmployeeEntity to DTO conversion
		List<EmployeeDtoResponse> response = new ArrayList<>();
		for (EmployeeEntity getEmp : list) {
			EmployeeDtoResponse dto = EmployeeEntity.getEmployeeDtoResponse(getEmp);
			response.add(dto);
		}
		return response;
	}

	@Override
	public EmployeeDtoResponse getEmployee(String id) {
		log.info("getEmployee service impl called.");

		// Database called
		EmployeeEntity employee = employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee", "empId", id));

		// EmployeeEntity to DTO conversion
		EmployeeDtoResponse response = EmployeeEntity.getEmployeeDtoResponse(employee);
		return response;
	}

	@Override
	public DeleteResponse deleteEmployee(String id) {
		log.info("deleteEmployee service impl called.");

		// Database called to find employee
		EmployeeEntity emp = employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee", "empId", id));

		// Database called to delete employee
		employeeRepo.delete(emp);
		return new DeleteResponse("Record of the employee deleted successfully", true);
	}

}
