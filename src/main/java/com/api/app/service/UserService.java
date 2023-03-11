package com.api.app.service;

import com.api.app.entity.User;

public interface UserService  {
    User get(Long id);
    User create(User user);
}
