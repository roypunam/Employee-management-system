package com.employee.management.emp_manager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.employee.management.emp_manager.entity.EmployeeEntity;
import com.employee.management.emp_manager.entity.RoleEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class EmployeeDtoRequest {
	@NotEmpty(message = "The Emp Id is required.")
	String empId;

	@NotEmpty(message = "The full name is required.")
	@Size(min = 2, max = 100, message = "The length of employee name must be between 2 and 100 characters.")
	String empName;

//	@JsonIgnore
	@NotEmpty(message = "The password is required.")
	@Pattern(regexp = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$", message = "password must be of 8 to 20 length with special characters, numbers, Capital letters, small letters")
	String password;

	@NotEmpty(message = "The email is required.")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Please give a valid email id.")
	String email;

	@NotNull(message = "The date of birth is required.")
	@Past(message = "The date of birth must be in the past.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	Date empDob;

	@NotNull(message = "The employee salary is required.")
	@Positive(message = "The employee salary must be greater than 0.")
	Long empSalary;
	List<RoleEntity> roleList = new ArrayList<>();

	public static EmployeeEntity getEmployee(EmployeeDtoRequest empDto) {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmpId(empDto.getEmpId());
		emp.setEmpName(empDto.getEmpName());
		emp.setEmail(empDto.getEmail());
		emp.setPassword(empDto.getPassword());
		emp.setRoleList(empDto.getRoleList());
		emp.setEmpDob(empDto.getEmpDob());
		emp.setEmpSalary(empDto.getEmpSalary());
		return emp;

	}

}
