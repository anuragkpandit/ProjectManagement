package com.example.ProjectManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableAspectJAutoProxy(proxyTargetClass = true)
@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
