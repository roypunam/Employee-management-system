package com.employee.management.emp_manager.exception;

public class EmployeeExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1867669419723037513L;

	public EmployeeExistException(String errorMessage) {
		super(errorMessage);
	}
}
