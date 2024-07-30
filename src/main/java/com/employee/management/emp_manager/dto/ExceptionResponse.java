package com.employee.management.emp_manager.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * <b>Exception Response</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {
	Date timestamp;
	Integer status;
	String error;
	String message;
}
