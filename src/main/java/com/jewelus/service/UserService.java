package com.jewelus.service;

import com.jewelus.dtos.UserDto;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    UserDto findUserByEmail(String email);

}
