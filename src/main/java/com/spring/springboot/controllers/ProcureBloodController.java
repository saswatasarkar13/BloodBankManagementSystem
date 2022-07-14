package com.spring.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.common.Constants;
import com.spring.springboot.models.ProcureBlood;
import com.spring.springboot.services.ProcureBloodService;

@Controller
public class ProcureBloodController {

    @Autowired
    private ProcureBloodService procureBloodService;

    @RequestMapping(value = "/procure", method = RequestMethod.GET)
    public String procureBloodHandler(Model model) {

        ProcureBlood obj = new ProcureBlood();
        model.addAttribute("blood_groups", Constants.BLOOD_GROUPS);
        model.addAttribute("procure", obj);
        return "/procure/form";
    }

    @RequestMapping(value = "/procure/add", method = RequestMethod.POST)
    public String addBloodHandler(ProcureBlood pb, Model model) {
        ProcureBlood obj = this.procureBloodService.save(pb);

        if(obj == null){
            model.addAttribute("errorMessage", "Sorry, Something went wrong!");
            return "/procure";
        }

        return "redirect:/procure/success";
    }
}
