package com.nishasoni.online.marketplace.controller;

import com.nishasoni.online.marketplace.entity.User; 
import com.nishasoni.online.marketplace.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List; 

import com.nishasoni.online.marketplace.util.Helper;
@Controller 
@RequestMapping(value = "admin/user") 
public class UserController { 
 private UserService userService; 
    public UserController(UserService userService) { 
        this.userService = userService; 
    }
 
    @GetMapping(value = "/index") 
    public String users(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<User> users = userService.getAllUser(); 
        model.addAttribute("listUsers", users); 
        model.addAttribute("keyword", keyword); 
        return "admin/list/users_list"; 
    }
 
  @GetMapping(value = "/create") 
    public String formUsers(Model model) {
        model.addAttribute("user", new User()); 
        return "admin/entry/user_entry"; 
    } 
    @GetMapping(value = "/delete/{id}") 
    public String deleteUser(@PathVariable(value = "id") Integer id, String keyword, HttpSession session) {
        userService.removeUser(id); 
        return "redirect:/admin/user/index?keyword=" + keyword; 
    }
 
    @GetMapping(value = "/update/{id}") 
    public String updateUser(@PathVariable(value = "id") Integer id, Model model) {
        User user = userService.loadUserById(id); 
        model.addAttribute("user", user); 
        return "admin/edit/user_edit"; 
    }
 
    @PostMapping(value = "/save") 
    public String save(User user,  HttpSession session) {
       String msg = "inserted";
		if(user.getId() != null && user.getId() != 0) {
			msg = "updated";
		}
		User obj = userService.createOrUpdateUser(user);
		if(obj != null) {
			session.setAttribute("msg", "inserted");
		}else {
			session.setAttribute("error","error");
		}
		return "redirect:/admin/user/index";
    }
 
} 
