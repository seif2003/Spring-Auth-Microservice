package com.seif.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seif.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}