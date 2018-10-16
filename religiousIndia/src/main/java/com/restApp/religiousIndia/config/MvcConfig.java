package com.restApp.religiousIndia.config;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
				.addResourceLocations(new File("E:\\ReligiousIndia\\RI_Static_Resources\\images").toURI().toString());

		registry.addResourceHandler("/videos/**")
				.addResourceLocations(new File("E:\\ReligiousIndia\\RI_Static_Resources\\videos").toURI().toString());
	}
}
