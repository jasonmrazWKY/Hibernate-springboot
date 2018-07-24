package com.dhht.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhht.common.AccessResult;
import com.dhht.dao.BaseDao;
import com.dhht.entity.User;
import com.dhht.utils.DaoUtil;

@Service
public class LoginService {
	
	@Autowired
	private BaseDao<User> userDao;
    
	public AccessResult login(String userName,String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("password", password);
		String hql = DaoUtil.getFindPrefix(User.class)+" where name =:userName and password =:password";
		User user = userDao.get(hql, params);
		if(user!=null) {
			return new AccessResult(true,"success");
		}
		return new AccessResult(false,"false");
	}
}
