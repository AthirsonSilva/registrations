package com.api.app.service;

import com.api.app.entity.User;

import java.util.List;

public interface UserService  {
    User create(User user);
    User findById(Long id);
    List<User> findAll();
    User update(User user, Long id);
    void delete(Long id);
}
