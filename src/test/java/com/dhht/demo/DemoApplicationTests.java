package com.dhht.demo;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dhht.entity.User;
import com.dhht.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
    UserService userService;
	
	@Test
	public void contextLoads() {
		List<User> list =  userService.getList();
		if(list!=null&&list.size()>0) {
			System.out.println("@@@@@"+list.size());
		}
	}

}
