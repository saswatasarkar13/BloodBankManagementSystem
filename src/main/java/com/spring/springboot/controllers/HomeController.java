package com.spring.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.services.BloodAvailableService;

@Controller
public class HomeController {

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @RequestMapping("/")
    public String index(Model model) {
        List<BloodAvailable> list = bloodAvailableService.getAll();
        model.addAttribute("blood_list", list);

        return "/home";
    }
}
