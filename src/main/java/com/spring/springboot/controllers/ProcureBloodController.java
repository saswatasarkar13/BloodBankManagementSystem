package com.spring.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springboot.common.Constants;
import com.spring.springboot.models.ProcureBlood;
import com.spring.springboot.services.ProcureBloodService;

@Controller
public class ProcureBloodController {
    @Autowired
    private ProcureBloodService procureBloodService;

    @RequestMapping(value = "/procure")
    public String procureBloodHandler (Model model)
    {
        
        ProcureBlood obj = new ProcureBlood();
        model.addAttribute("bloodGroups", Constants.BLOOD_GROUPS);
        model.addAttribute("procure", obj);   
        return "/procure/form";
    }    
}
