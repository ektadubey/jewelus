package com.jewelus.shopapi;

import com.jewelus.dtos.UserDto;
import com.jewelus.entity.User;
import com.jewelus.repositories.UserRepository;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@RestController
public class TestController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/register")
    public User saveUser(@RequestBody User user){
        BlockingQueue<Integer> b = new LinkedBlockingQueue<>();
        return userRepository.save(user);
    }

    @GetMapping("/users/{email}")
    public UserDto getUser(@PathVariable("email") String email){
        return castToUserDTO(userRepository.findByEmail(email));
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
