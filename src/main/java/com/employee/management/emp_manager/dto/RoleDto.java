package com.employee.management.emp_manager.dto;

import com.employee.management.emp_manager.entity.RoleEntity;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDto {

	Integer roleId;
	String name;

	public static RoleEntity getRole(RoleDto roleDto) {
		RoleEntity role = new RoleEntity();
		role.setRoleId(roleDto.getRoleId());
		role.setName(roleDto.getName());
		return role;
	}
}
