package com.example.springsecurityjwt;

import com.example.springsecurityjwt.entity.UserEntity;
import com.example.springsecurityjwt.repository.UserRepository;
import com.example.springsecurityjwt.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJwtApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new UserEntity("sachin", "pass1234", true, "admin"));
		userRepository.save(new UserEntity("thakur", "thakur", true, "admin"));

	}
}
