package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("count-users")
    public String getCountUsers(){
        long numberUsers = userRepository.count();
        return "hello-world";
    }

    @RequestMapping("add-user")
    public String addUser(){
        User user = new User();
        user.setFirstName("Render");
        user.setLastName("Spring Boot");
        userRepository.save(user);
        return "User added successfully";
    }
}
