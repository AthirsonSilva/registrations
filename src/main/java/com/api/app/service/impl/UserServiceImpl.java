package com.api.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.app.entity.User;
import com.api.app.exception.EmailAlreadyExistsException;
import com.api.app.exception.ResourceNotFoundException;
import com.api.app.mapper.AutoUserMapper;
import com.api.app.payload.UserPayload;
import com.api.app.repository.UserRepository;
import com.api.app.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public UserPayload findById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("user", "id", id));

		return AutoUserMapper.map.toUserPayload(user);
	}

	@Override
	public List<UserPayload> findAll() {
		List<User> users = userRepository.findAll();

		return users.stream().map(user -> AutoUserMapper.map.toUserPayload(user)).toList();
	}

	@Override
	public UserPayload create(UserPayload request) {
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException("A user with this email already exists. Please use another email.");
		}

		User savedUser = userRepository.save(AutoUserMapper.map.toUserEntity(request));

		return AutoUserMapper.map.toUserPayload(savedUser);
	}

	@Override
	public UserPayload update(UserPayload user, Long id) {
		User userToUpdate = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("user", "id", id));

		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());

		userRepository.save(userToUpdate);

		return AutoUserMapper.map.toUserPayload(userToUpdate);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
}
