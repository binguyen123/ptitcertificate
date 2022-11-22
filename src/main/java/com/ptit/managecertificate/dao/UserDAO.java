package com.ptit.managecertificate.dao;

import java.util.List;

import com.ptit.managecertificate.entity.User;


public interface UserDAO {
	public void save(User user);
	public void update(User user);
	public User findById(int id);
	public void delete(User user);
	public List<User> findAll();
	public User getUserByUserName(String userName);
	public boolean checkUserInDatabase(User user);
}
