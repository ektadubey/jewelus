package com.jewelus.shopapi;

import com.jewelus.dtos.UserDto;
import com.jewelus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public UserDto registerUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping("/users/{email}")
    public UserDto findUser(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }

}
