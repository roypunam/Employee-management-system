package com.employee.management.emp_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.emp_manager.dto.DeleteResponse;
import com.employee.management.emp_manager.dto.EmployeeDtoRequest;
import com.employee.management.emp_manager.dto.EmployeeDtoResponse;
import com.employee.management.emp_manager.dto.LoginRequest;
import com.employee.management.emp_manager.exception.EmployeeExistException;
import com.employee.management.emp_manager.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * <b>Employee Controller: It's contains all the employee related API's</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

	

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		log.info("login API called.");
		
		String response = employeeService.login(loginRequest);
		return response;	
	}

	@PostMapping("/register")
	public ResponseEntity<EmployeeDtoResponse> registerEmployee(@RequestBody @Valid EmployeeDtoRequest empDto) throws EmployeeExistException {
		log.info("registerEmployee API called.");
		EmployeeDtoResponse registeredEmployee = employeeService.registerEmployee(empDto);
		return new ResponseEntity<EmployeeDtoResponse>(registeredEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<EmployeeDtoResponse> updateEmployeeDetails(@RequestBody EmployeeDtoRequest empDto, @PathVariable String id) {
		log.info("updateEmployeeDetails API called.");
		EmployeeDtoResponse updatedEmpDetails = employeeService.updateEmployeeDetails(empDto, id);
		return new ResponseEntity<EmployeeDtoResponse>(updatedEmpDetails, HttpStatus.OK);
	}

	@GetMapping("/list/view")
	public ResponseEntity<List<EmployeeDtoResponse>> getAllEmployee() {
		log.info("getAllEmployee API called.");
		List<EmployeeDtoResponse> getList = employeeService.getAllEmployee();
		return new ResponseEntity<List<EmployeeDtoResponse>>(getList, HttpStatus.OK);

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<EmployeeDtoResponse> getEmployee(@PathVariable String id) {
		log.info("getEmployee API called.");
		EmployeeDtoResponse getEmp = employeeService.getEmployee(id);
		return new ResponseEntity<EmployeeDtoResponse>(getEmp, HttpStatus.OK);
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<DeleteResponse> deleteEmployee(@PathVariable String id) {
		log.info("deleteEmployee API called.");
		DeleteResponse deleteResponse = employeeService.deleteEmployee(id);
		return new ResponseEntity<DeleteResponse>(deleteResponse, HttpStatus.OK);
	}
}
