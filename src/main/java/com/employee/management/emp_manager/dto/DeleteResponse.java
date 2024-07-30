package com.employee.management.emp_manager.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
/**
 * <b>Delete API Response</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteResponse {
	String message;
	Boolean success;
}
