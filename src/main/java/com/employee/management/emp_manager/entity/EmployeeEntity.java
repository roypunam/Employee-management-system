package com.employee.management.emp_manager.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.employee.management.emp_manager.dto.EmployeeDtoResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
/**
 * <b>Employee Entity</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employee")
public class EmployeeEntity implements UserDetails {
	
	private static final long serialVersionUID = -2323937019915011561L;
	
	@Id
	@Column(name = "employee_id")
	String empId;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "employee_name")
	String empName;
	
	@Column(name = "email")
	String email;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date_of_birth")
	Date empDob;
	
	@Column(name = "salary")
	Long empSalary;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "empId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	List<RoleEntity> roleList = new ArrayList<>();

	public static EmployeeDtoResponse getEmployeeDtoResponse(EmployeeEntity emp) {
		EmployeeDtoResponse dto = new EmployeeDtoResponse();
		dto.setEmpId(emp.getEmpId());
		dto.setEmpName(emp.getEmpName());
		dto.setEmail(emp.getEmail());
		dto.setRoleList(emp.getRoleList());
		dto.setEmpDob(emp.getEmpDob());
		dto.setEmpSalary(emp.getEmpSalary());
		return dto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roleList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.empId;
	}
	
}
