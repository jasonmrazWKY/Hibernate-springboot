package com.dhht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dhht.entity.User;

@Controller
public class LoginController {
   
	@RequestMapping("login")
	public String checkLogin(User user){
		System.out.println(user.getName()+"\t"+user.getPassword());
		return "hello";
	}
}
