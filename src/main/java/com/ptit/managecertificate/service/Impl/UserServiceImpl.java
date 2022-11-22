package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.managecertificate.dao.UserDAO;
import com.ptit.managecertificate.entity.User;



@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	public void saveUser(User user) {
		userDao.save(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	public boolean checkUserInDatabase(User user) {
		return userDao.checkUserInDatabase(user);
	}
}
