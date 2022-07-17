package com.spring.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springboot.common.Constants;
import com.spring.springboot.helpers.BloodTable;
import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.models.User;
import com.spring.springboot.services.BloodAvailableService;
import com.spring.springboot.services.UserService;

@Controller
public class HomeController {

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @Autowired
    private UserService userService;

    @Autowired
    private BloodTable helpers;

    @RequestMapping(value = { "/", "/home" })
    public String index(Model model, @CookieValue(name = "userid", defaultValue = "") String userId) {
        List<BloodAvailable> list = bloodAvailableService.getAll();

        User user = null;
        if (!userId.equals("")) {
            user = this.userService.findById(Long.parseLong(userId));
        }

        model.addAttribute("user", user);
        model.addAttribute("blood_groups", Constants.BLOOD_GROUPS);
        model.addAttribute("blood_list", this.helpers.getList(list));

        return "/home";
    }
}
