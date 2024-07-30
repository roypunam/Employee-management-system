package com.employee.management.emp_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.emp_manager.entity.EmployeeEntity;

/**
 * <b>JPA Employee Repository</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {

//	@Query(value = "SELECT date_of_birth, salary, email FROM employee where email = ?0", nativeQuery = true)
//	List<CustomDto> findByName(Integer salary, String email);
	
}
