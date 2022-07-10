package com.spring.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springboot.models.User;
import com.spring.springboot.services.UserService;

@Controller
public class UserContoller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> list = userService.getAllUsers();

        model.addAttribute("users", list);
        model.addAttribute("name", "saswata");

        return "/users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser() {
        // User obj = new User("test account1", "test1@gmail.com");
        // userService.save(obj);
        return "User is added";
    }
}
