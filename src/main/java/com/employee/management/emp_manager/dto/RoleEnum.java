package com.employee.management.emp_manager.dto;
/**
 * <b>Role Enum</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
public enum RoleEnum {
	USER("1"), ADMIN("2");
	
	private String value; 
	
	private RoleEnum(String value) 
	{ 
		this.value = value; 
	} 

    public String getValue() 
    { 
        return this.value; 
    } 
  
}
