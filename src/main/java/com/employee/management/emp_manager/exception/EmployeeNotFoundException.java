package com.employee.management.emp_manager.exception;

import lombok.Getter;
import lombok.Setter;
/**
 * <b>Employee Not Found Exception</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Getter
@Setter
public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5063697235277892701L;

	public EmployeeNotFoundException(String entityName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s: %s", entityName, fieldName, fieldValue));
	}
}
