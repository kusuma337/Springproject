package com.project.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.project.model.User;
import com.project.project.repository.UserRepository;

@Service
public class UserService {
	private  final UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	public void registerUser(String username,String password) 
	{
	User user=new User();
	user.setUsername(username);
	user.setPassword(passwordEncoder.encode(password));
	user.setRole("USER");
	userRepository.save(user);
	}
	}
