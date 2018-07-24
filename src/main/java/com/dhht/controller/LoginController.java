package com.dhht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dhht.common.AccessResult;
import com.dhht.entity.User;
import com.dhht.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginservice;
   
	@RequestMapping("login")
	public String checkLogin(User user){
		System.out.println(user.getName()+"\t"+user.getPassword());
		AccessResult ac = loginservice.login(user.getName(), user.getPassword());
		if(ac.isSuccess()) {
			return "success";
		}
		return "index";
	}
}
