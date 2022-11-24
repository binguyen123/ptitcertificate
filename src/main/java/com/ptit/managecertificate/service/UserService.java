package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.User;

import java.util.List;

public interface UserService {
	void saveUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	User getUserById(Long id);
	User getUserByUserName(String userName);
    boolean checkUserInDatabase(User user);
	List<User> listUser();
}
