package com.api.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.api.app.entity.User;
import com.api.app.payload.UserPayload;

@Mapper
public interface AutoUserMapper {
	AutoUserMapper map = Mappers.getMapper(AutoUserMapper.class);

	@Mapping(source = "id", target = "id")
	UserPayload toUserPayload(User user);

	@Mapping(source = "id", target = "id")
	User toUserEntity(UserPayload userPayload);
}
