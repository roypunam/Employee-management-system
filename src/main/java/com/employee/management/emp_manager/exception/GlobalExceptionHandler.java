package com.employee.management.emp_manager.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.management.emp_manager.dto.ExceptionResponse;
import com.employee.management.emp_manager.utils.StringUtils;


/**
 * <b>Global Exception Handler</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> ExceptionHandler(Exception ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				StringUtils.INTERNAL_SERVER_ERROR, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> employeeNotFoundExceptionHandler(EmployeeNotFoundException ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				StringUtils.EMPLOYEE_NOT_FOUND, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				StringUtils.METHOD_ARGUMENT_NOT_VALID_EXCEPTION, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeExistException.class)
	public ResponseEntity<ExceptionResponse> EmployeeExistExceptionHandler(EmployeeExistException ex) {
		String message = ex.getMessage();
		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.BAD_REQUEST.value(),
				StringUtils.EMPLOYEE_EXIST_EXCEPTION, message);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}


}
