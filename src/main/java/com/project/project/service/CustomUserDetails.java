package com.project.project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.project.model.User;
import com.project.project.repository.UserRepository;
@Service
public class CustomUserDetails implements UserDetailsService{

	private UserRepository userRepository;
	public CustomUserDetails(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByusername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found with given username");
		}
		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
	}

}
