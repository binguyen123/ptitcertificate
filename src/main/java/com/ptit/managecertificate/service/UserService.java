package com.ptit.managecertificate.service;

import com.ptit.managecertificate.entity.User;

public interface UserService {
	void saveUser(User user);
	void updateUser(User user);
	User getUserByUserName(String userName);
    boolean checkUserInDatabase(User user);
}
