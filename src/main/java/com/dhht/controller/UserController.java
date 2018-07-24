package com.dhht.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dhht.common.AccessResult;
import com.dhht.entity.User;
import com.dhht.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public  List<User> getUsers(){
		return userService.getList();
	}
	
	@GetMapping("/saveUser")
	public AccessResult saveUser(@RequestParam(value="name",required=true) String name,@RequestParam(value="age") Integer age) {
		User u = new User();
		u.setName(name);
		u.setAge(age);
		AccessResult ac = userService.saveUser(u);
		return ac; 
	}
	
	@RequestMapping("gologin")
	public ModelAndView gologin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
}
