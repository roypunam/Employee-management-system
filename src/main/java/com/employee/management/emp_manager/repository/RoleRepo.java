package com.employee.management.emp_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.emp_manager.entity.RoleEntity;
/**
 * <b>JPA Role Repository</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

}
