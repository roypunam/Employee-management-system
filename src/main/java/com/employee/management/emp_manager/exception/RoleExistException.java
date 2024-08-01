package com.employee.management.emp_manager.exception;

public class RoleExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleExistException(String errorMessage) {
		super(errorMessage);
	}
}
