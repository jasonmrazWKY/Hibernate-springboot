package com.dhht.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dhht.interceptor.LoginInterceptor;

@Configuration 
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("addInterceptors");
		//拦截规则：除了login，其他都拦截判断
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/gologin");
		super.addInterceptors(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("addViewControllers");
		 //registry.addViewController("/").setViewName("redirect:/index.jsp");
		 registry.addViewController("/").setViewName("index");
	     registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	     super.addViewControllers(registry);
	}
	
}
