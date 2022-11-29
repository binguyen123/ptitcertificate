package com.ptit.managecertificate.service.Impl;

import com.ptit.managecertificate.dao.UserDAO;
import com.ptit.managecertificate.entity.User;
import com.ptit.managecertificate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void saveUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.findById(id);
    }

    public User getUserByUserName(String userName) {
        return userDAO.getUserByUserName(userName);
    }

    public boolean checkUserInDatabase(User user) {
        return userDAO.checkUserInDatabase(user);
    }

    @Override
    public List<User> listUser() {
        return userDAO.findAll();
    }

    @Override
    public List<User> listUser(Pageable page) {
        return userDAO.findByPageable(page);
    }

    @Override
    public long getTotalUser() {
        return userDAO.getTotalUser();
    }


}
