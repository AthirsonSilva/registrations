package com.api.app.service;

import java.util.List;

import com.api.app.payload.UserPayload;

public interface UserService {
	UserPayload create(UserPayload user);

	UserPayload findById(Long id);

	List<UserPayload> findAll();

	UserPayload update(UserPayload user, Long id);

	void delete(Long id);
}
