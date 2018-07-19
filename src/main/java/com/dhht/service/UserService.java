package com.dhht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dhht.common.AccessResult;
import com.dhht.common.IMoocJSONResult;
import com.dhht.dao.BaseDao;
import com.dhht.entity.User;
import com.dhht.utils.DaoUtil;
import com.dhht.utils.UUIDUtil;

@Service
public class UserService {
	
	@Autowired
	private BaseDao<User> userDao;
	
	public List<User> getList(){
	   return userDao.find(DaoUtil.getFindPrefix(User.class));
	}
	
	public AccessResult saveUser(User u) {
		  u.setId(UUIDUtil.generate());
		  userDao.save(u);
		  return new AccessResult(true,"保存成功");
	}

}
