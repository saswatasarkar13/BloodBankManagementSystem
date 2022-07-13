package com.spring.springboot.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.helpers.Encryption;
import com.spring.springboot.models.User;
import com.spring.springboot.services.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private Encryption encryption;

    AuthController() {
        encryption = new Encryption();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLogin(Model model) {
        model.addAttribute("user", new User());

        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutHandler(HttpServletResponse sResponse) {

        Cookie cookie = new Cookie("userid", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        sResponse.addCookie(cookie);

        return "redirect:/home";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public String loginHandler(User u, Model model, HttpServletResponse sResponse) {
        String email = u.getEmail();
        String password = u.getPassword();

        System.out.println(email + " " + password);

        User user = this.userService.findUserByEmail(email);

        if (user == null) {
            model.addAttribute("loginError", "Email does not exists. Try signing up");
            return "/login";
        }

        boolean isPasswordCorrect = encryption.checkPassword(user.getPassword(), password);

        if (!isPasswordCorrect) {
            model.addAttribute("loginError", "Invalid user or password!");
            return "/login";
        }

        Long id = user.getId();
        String userid = Long.toString(id);

        Cookie cookie = new Cookie("userid", userid);
        cookie.setPath("/");

        sResponse.addCookie(cookie);

        return "redirect:/home";
    }

}
