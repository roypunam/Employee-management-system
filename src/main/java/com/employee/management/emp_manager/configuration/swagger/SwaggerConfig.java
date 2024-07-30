package com.employee.management.emp_manager.configuration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * <b>Swagger Configuration</b>
 *
 * @author Punam Pal
 * @since 1.0.0
 */
@OpenAPIDefinition(info = @Info(
		title = "Employee Management System", 
		description = "Basic project structure with Role based JWT authentation and authorization with Swagger and log implemented.", 
		summary = "Security Impletation Skeleton.", 
		termsOfService = "https://www.linkedin.com/in/punam-roy/", 
		version = "1.0.0", 
		contact = @Contact(name = "@Punam Pal", email = "roypunam96@gmail.com", url = "https://www.linkedin.com/in/punam-roy/")), 
		security = @SecurityRequirement(name = "authBearer"))

@SecurityScheme(name = "authBearer", in = SecuritySchemeIn.HEADER, type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class SwaggerConfig {

}