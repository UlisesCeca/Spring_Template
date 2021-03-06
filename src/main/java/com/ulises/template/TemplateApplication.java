package com.ulises.template;

import com.ulises.template.rest.endpoints.UserEndpoint;
import com.ulises.template.rest.exceptionsmappers.InternalServerErrorMapper;
import com.ulises.template.rest.exceptionsmappers.NotFoundMapper;
import com.ulises.template.rest.exceptionsmappers.UserNotFoundExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}


	@Bean
	public ResourceConfig jerseyConfig() {
		final ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(UserEndpoint.class);
		resourceConfig.register(UserNotFoundExceptionMapper.class);
		resourceConfig.register(NotFoundMapper.class);
		resourceConfig.register(InternalServerErrorMapper.class);
		return resourceConfig;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
