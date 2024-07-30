package com.employee.management.emp_manager.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.management.emp_manager.entity.EmployeeEntity;
import com.employee.management.emp_manager.exception.EmployeeNotFoundException;
import com.employee.management.emp_manager.repository.EmployeeRepo;
/**
 * <b>Custom User Detail Service</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	 private EmployeeRepo employeeRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmployeeEntity user=this.employeeRepo.findById(username).orElseThrow(()->new EmployeeNotFoundException("Employee", "empId", username));
		return user;
	}

}
