package com.spring.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.common.Constants;
import com.spring.springboot.helpers.Encryption;
import com.spring.springboot.models.Donation;
import com.spring.springboot.models.User;
import com.spring.springboot.services.DonationService;
import com.spring.springboot.services.ProcureBloodService;
import com.spring.springboot.services.UserService;

@Controller
public class UserContoller {

    @Autowired
    private UserService userService;

    private Encryption encryption;
    @Autowired
    private DonationService donationService;
    @Autowired
    private ProcureBloodService procureBloodService;

    UserContoller() {
        encryption = new Encryption();
    }

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

        // hashing the password and storing
        String plainPassword = user.getPassword();
        String passwordHash = encryption.getEncryptedPassword(plainPassword);
        user.setPassword(passwordHash);

        this.userService.save(user);

        return "redirect:/home";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilehandler(Model model, @CookieValue(name = "userid", defaultValue = "") String id) {
        try {
            if (!id.equals("")) {
                Long userId = Long.parseLong(id);
                System.out.println(id);
                User user = this.userService.findById(userId);
                model.addAttribute("user", user);
                
                System.out.println(user.getDonations());
                 
                model.addAttribute("donations", user.getDonations());

                model.addAttribute("procureBloods", user.getProcureBlood());

                return "/user/profile";
            } else {
                return "redirect:/home";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }
}
