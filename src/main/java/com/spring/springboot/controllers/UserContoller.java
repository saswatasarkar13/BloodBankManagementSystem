package com.spring.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.common.Constants;
import com.spring.springboot.models.User;
import com.spring.springboot.services.UserService;

@Controller
public class UserContoller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/form", method = RequestMethod.GET)
    public String userRegister(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("bloodGroups", Constants.BLOOD_GROUPS);

        return "/user/form";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> list = userService.getAllUsers();

        model.addAttribute("users", list);

        return "/user/list";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(User user) {
        this.userService.save(user);

        return "redirect:/home";
    }
}
