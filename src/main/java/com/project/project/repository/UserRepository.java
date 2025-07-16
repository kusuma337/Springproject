package com.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.project.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByusername(String username);

}
