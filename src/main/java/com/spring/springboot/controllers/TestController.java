package com.spring.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// import com.spring.springboot.helpers.Encryption;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        
        // Encryption obj = new Encryption();
        // String s = obj.getEncryptedPassword("password");
        // System.out.println(s);

        return "This is a test page";
    }
}
