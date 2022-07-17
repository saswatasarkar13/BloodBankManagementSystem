package com.spring.springboot.controllers;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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
    public String goToLogin(Model model, @CookieValue(name = "userid", defaultValue = "") String userId) {

        if (!userId.equals("")) {
            // user already logged-in
            return "redirect:/home";
        }

        model.addAttribute("user", new User());

        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutHandler(HttpServletResponse sResponse) {

        Cookie cookie1 = new Cookie("userid", "");
        cookie1.setPath("/");
        cookie1.setMaxAge(0);

        Cookie cookie2 = new Cookie("username", "");
        cookie2.setPath("/");
        cookie2.setMaxAge(0);

        Cookie cookie3 = new Cookie("role", "");
        cookie3.setPath("/");
        cookie3.setMaxAge(0);

        sResponse.addCookie(cookie1);
        sResponse.addCookie(cookie2);
        sResponse.addCookie(cookie3);

        return "redirect:/home";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public String loginHandler(User u, Model model, HttpServletResponse sResponse) {
        String email = u.getEmail();
        String password = u.getPassword();

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
        String name = "";

        try {
            name = URLEncoder.encode(user.getName(), "UTF-8");
        } catch (Exception e) {
            System.out.println(e);
        }

        Cookie cookie1 = new Cookie("userid", userid);
        cookie1.setPath("/");

        Cookie cookie2 = new Cookie("username", name);
        cookie2.setPath("/");

        String role = "user";
        if (user.isAdmin())
            role = "admin";

        Cookie cookie3 = new Cookie("role", role);
        cookie3.setPath("/");

        sResponse.addCookie(cookie1);
        sResponse.addCookie(cookie2);
        sResponse.addCookie(cookie3);

        if (role.equals("admin"))
            return "redirect:/dashboard";

        return "redirect:/home";
    }

}
