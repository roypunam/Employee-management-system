package com.employee.management.emp_manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.employee.management.emp_manager.entity.RoleEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * <b>Employee DTO</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDtoResponse {
	String empId;
	String empName;
	String email;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	Date empDob;
	Long empSalary;
	List<RoleEntity> roleList = new ArrayList<>();
}
