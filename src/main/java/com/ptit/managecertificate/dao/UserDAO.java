package com.ptit.managecertificate.dao;

import com.ptit.managecertificate.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserDAO {
    void save(User user);

    void update(User user);

    User findById(Long id);

    void delete(User user);

    List<User> findAll();

    User getUserByUserName(String userName);

    boolean checkUserInDatabase(User user);

    long getTotalUser();

    List<User> findByPageable(Pageable pageable);

}