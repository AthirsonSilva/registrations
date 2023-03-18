package com.api.app.mapper;

import org.springframework.beans.BeanUtils;

import com.api.app.entity.User;
import com.api.app.payload.UserPayload;

public class UserMapper {
	public static UserPayload mapToPayload(User user) {
		UserPayload userPayload = new UserPayload();

		BeanUtils.copyProperties(user, userPayload);

		return userPayload;
	}

	public static User mapToEntity(UserPayload userPayload) {
		User user = new User();

		BeanUtils.copyProperties(userPayload, user);

		return user;
	}
}
