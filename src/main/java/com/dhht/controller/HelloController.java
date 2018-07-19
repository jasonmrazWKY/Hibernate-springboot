package com.dhht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhht.entity.DhhtEntity;

@RestController
public class HelloController {
	
	@Value("${content}")
	private String content;
	
	@Autowired
	private DhhtEntity dhhtEntity;
	
	@RequestMapping("/hello")
	public  String hello() {
		return "HELLO WORLD:"+content;
	}
	
	@RequestMapping("/dhht")
	public  String dhht() {
		return dhhtEntity.getName()+";"+dhhtEntity.getAge();
	}

}
