package com.api.app.service.impl;

import com.api.app.entity.User;
import com.api.app.repository.UserRepository;
import com.api.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return null;
    }
}
