package com.rad.rduserportal.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class RDUserPortalInterceptorConfigurer implements WebMvcConfigurer {


	@Autowired
	private RDUserPortalInterceptor rdUserPortalInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
				.addInterceptor(rdUserPortalInterceptor)
				.excludePathPatterns("/userportal/visitor/registerUser");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry
				.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
