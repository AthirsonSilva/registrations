package com.api.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.app.entity.User;
import com.api.app.mapper.UserMapper;
import com.api.app.payload.UserPayload;
import com.api.app.repository.UserRepository;
import com.api.app.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public UserPayload create(UserPayload request) {
		User savedUser = userRepository.save(UserMapper.mapToEntity(request));

		return UserMapper.mapToPayload(savedUser);
	}

	@Override
	public UserPayload findById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		return UserMapper.mapToPayload(user);
	}

	@Override
	public UserPayload update(UserPayload user, Long id) {
		User userToUpdate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());

		userRepository.save(userToUpdate);

		return UserMapper.mapToPayload(userToUpdate);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserPayload> findAll() {
		List<User> users = userRepository.findAll();

		return users.stream().map(UserMapper::mapToPayload).toList();
	}
}
