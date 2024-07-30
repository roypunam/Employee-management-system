package com.employee.management.emp_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
/**
 * <b>Role Entity</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "role")
public class RoleEntity {

	@Id
	Integer roleId;
	String name;
//	For Creating foreign key reference 
//	@ManyToMany(mappedBy = "roleList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Employee> employeeList = new ArrayList<>(); 

}
