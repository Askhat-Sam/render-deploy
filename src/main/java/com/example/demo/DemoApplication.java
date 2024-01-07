package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/users")
public class DemoApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

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
