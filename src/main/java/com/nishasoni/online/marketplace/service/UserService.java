package com.nishasoni.online.marketplace.service;

import com.nishasoni.online.marketplace.entity.User;
import java.util.List;

public interface UserService { 

  List<User> getAllUser();

   User loadUserById(Integer id );

   User createOrUpdateUser(User user);

   void removeUser(Integer id);

    User getUserByEmailandPassword(String email, String password);

    boolean checkEmailExist(String email);

    User getUserByEmail(String email);

} 
