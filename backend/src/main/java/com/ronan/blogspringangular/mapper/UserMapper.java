package com.ronan.blogspringangular.mapper;

import com.ronan.blogspringangular.domain.User;
import com.ronan.blogspringangular.dto.RegisterRequest;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(RegisterRequest registerRequest);
}
