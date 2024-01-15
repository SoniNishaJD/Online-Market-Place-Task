package com.nishasoni.online.marketplace.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.nishasoni.online.marketplace.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> { 

    User findByEmailAndPassword(String email, String password);

	boolean existsByEmail(String email);

    User findByEmail(String email);

} 
