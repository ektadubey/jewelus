package com.jewelus.service.impl;

import com.jewelus.dtos.UserDto;
import com.jewelus.entity.Cart;
import com.jewelus.entity.User;
import com.jewelus.repositories.CartRepository;
import com.jewelus.repositories.UserRepository;
import com.jewelus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CartRepository cartRepository;


    @Override
    public UserDto saveUser(UserDto userDto) {

        User user = castToUserEntity(userDto);
        user = userRepository.save(user);

        Cart savedCart = cartRepository.save(new Cart(user));
        user.setCart(savedCart);

        return castToUserDTO(userRepository.save(user));
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return castToUserDTO(userRepository.findByEmail(email));
    }

    private User castToUserEntity(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setActive(userDto.isActive());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setRole(userDto.getRole());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return user;

    }

    private UserDto castToUserDTO(User userEntity){
        return new UserDto.UserBuilder()
                .withEmail(userEntity.getEmail())
                .withName(userEntity.getName())
                .withPhone(userEntity.getPhone())
                .withAddress(userEntity.getAddress())
                .withRole(userEntity.getRole())
                .isActive(userEntity.isActive())
                .build();
    }
}
