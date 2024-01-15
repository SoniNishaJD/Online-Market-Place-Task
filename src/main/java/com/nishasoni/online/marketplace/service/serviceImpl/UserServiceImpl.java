package com.nishasoni.online.marketplace.service.serviceImpl;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.nishasoni.online.marketplace.dao.UserDAO; 
import com.nishasoni.online.marketplace.entity.User; 
import com.nishasoni.online.marketplace.service.UserService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService { 

@Autowired
 private UserDAO userDao;
 
 @Override 
    public List<User> getAllUser() { 
        return userDao.findAll(); 
    } 

@Override 
  public User loadUserById(Integer id) {
 return userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " Not Found"));
 }

@Override 
    public User createOrUpdateUser(User user) {
return userDao.save(user);
   }

  @Override
 	    public void removeUser(Integer id) {
 	        userDao.deleteById(id);
 	    }

    @Override
	public User getUserByEmailandPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}

	@Override
	public boolean checkEmailExist(String email) {
		return userDao.existsByEmail(email);
	}

    @Override
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
