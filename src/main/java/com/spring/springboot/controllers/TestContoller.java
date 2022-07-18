package com.spring.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestContoller {
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "This is a test page";
    }
}
