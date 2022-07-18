package com.spring.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.common.Constants;
import com.spring.springboot.helpers.Achievement;
import com.spring.springboot.helpers.Encryption;
import com.spring.springboot.models.User;
import com.spring.springboot.services.UserService;

@Controller
public class UserContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private Achievement achievementHelper;

    @Autowired
    private Encryption encryption;

    @RequestMapping(value = "/user/form", method = RequestMethod.GET)
    public String userRegister(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("bloodGroups", Constants.BLOOD_GROUPS);

        return "user/form";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> list = userService.getAllUsers();

        model.addAttribute("users", list);

        return "user/list";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(User user, Model model) {

        boolean err = false;
        String errMsg = "";

        try {
            String email = user.getEmail();

            if (this.userService.findUserByEmail(email) != null) {
                err = true;
                errMsg = "Email already exists";
            } else {

                // hashing the password and storing
                String plainPassword = user.getPassword();
                String passwordHash = encryption.getEncryptedPassword(plainPassword);
                user.setPassword(passwordHash);

                User result = this.userService.save(user);
                if (result == null) {
                    err = true;
                    errMsg = "Something went wrong!";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            err = true;
            errMsg = "Something went wrong!";
        }

        if (err) {
            model.addAttribute("user", new User());
            model.addAttribute("bloodGroups", Constants.BLOOD_GROUPS);

            model.addAttribute("error", errMsg);

            return "user/form";
        }

        return "redirect:/login?register=true";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilehandler(Model model, @CookieValue(name = "userid", defaultValue = "") String id) {
        try {
            if (id.equals(""))
                return "redirect:/home";

            Long userId = Long.parseLong(id);

            User user = this.userService.findById(userId);

            model.addAttribute("user", user);
            model.addAttribute("donations", user.getDonations());
            model.addAttribute("procureBloods", user.getProcureBlood());
            model.addAttribute("achievements", this.achievementHelper.getAchievements(user));

            return "user/profile";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }
    }
}
