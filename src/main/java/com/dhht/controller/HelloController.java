package com.dhht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dhht.entity.DhhtEntity;

@RestController
public class HelloController {
	
	@Value("${content}")
	private String content;
	
	@Autowired
	private DhhtEntity dhhtEntity;
	
	@PostMapping("/hello")
	public  String hello() {
		return "HELLO WORLD:"+content;
	}
	
	@RequestMapping("/dhht")
	public  String dhht() {
		return dhhtEntity.getName()+";"+dhhtEntity.getAge();
	}
	
	//视图
	@RequestMapping("/hello1")
	public ModelAndView showPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
	
	//重定向
	@RequestMapping("/redirect")
	public ModelAndView redirect() {
		ModelAndView mv = new ModelAndView("redirect:/index.jsp");
		return mv;
	}

}
