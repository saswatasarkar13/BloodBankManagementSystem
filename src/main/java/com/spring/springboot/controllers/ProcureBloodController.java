package com.spring.springboot.controllers;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.common.Constants;
import com.spring.springboot.helpers.BloodTable;
import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.models.ProcureBlood;
import com.spring.springboot.services.BloodAvailableService;
import com.spring.springboot.services.ProcureBloodService;

@Controller
public class ProcureBloodController {

    @Autowired
    private ProcureBloodService procureBloodService;

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @RequestMapping(value = "/procure", method = RequestMethod.GET)
    public String procureBloodHandler(Model model) {

        ProcureBlood obj = new ProcureBlood();

        model.addAttribute("bloodGroups", Constants.BLOOD_GROUPS);
        model.addAttribute("procure", obj);   
        return "/procure/form";
    }

    @RequestMapping(value = "/procure/add", method = RequestMethod.POST)
    public String addBloodHandler(ProcureBlood pb, Model model) {
        String city = pb.getCity();
        int quantity = pb.getQuantity();
        BloodTable helper = new BloodTable();

        ProcureBlood obj1 = new ProcureBlood();

        model.addAttribute("bloodGroups", Constants.BLOOD_GROUPS);
        model.addAttribute("procure", obj1);

        BloodAvailable su = this.bloodAvailableService.findByCity(city);
        System.out.println(su);

        if (su==null)
        {
            model.addAttribute("error", "The city is not serviceable");
            return "/procure/form";
        }

        TreeMap <String,Integer> list = helper.getBloodQuantityList(su.getBlood_groups());
        int availableQuantity = list.get(pb.getBlood_group());
        if (quantity > availableQuantity)
        {
            model.addAttribute("error", "The requsted blood quatity is not available");
            return "/procure/form";
        }
        
        pb.setStatus("pending");

        ProcureBlood obj = this.procureBloodService.save(pb);

        if(obj == null){
            model.addAttribute("errorMessage", "Sorry, Something went wrong!");
            return "/procure/form";
        }

        return "redirect:/procure/success";
    }

    @RequestMapping (value = "/procure/success")
    public String procureSuccessHandler()
    {
        return "/procure/success";
    }
    

}
