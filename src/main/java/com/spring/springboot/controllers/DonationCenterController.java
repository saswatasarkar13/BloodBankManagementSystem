package com.spring.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.models.DonationCenter;
import com.spring.springboot.services.DonationCenterService;

@Controller
public class DonationCenterController {

    @Autowired
    private DonationCenterService donationCenterService;

    @RequestMapping(value = "/donation/center/form", method = RequestMethod.GET)
    public String donationCenter(Model model) {

        DonationCenter obj = new DonationCenter();

        model.addAttribute("donationCenter", obj);
        model.addAttribute("cityList", this.donationCenterService.findAllCentres());

        return "/donationCenter/form";
    }

    @RequestMapping(value = "/donation/center/add", method = RequestMethod.POST)
    public String donationCenter(DonationCenter donationCenter, Model model) {
        boolean err = false;

        try {
            DonationCenter res = this.donationCenterService.save(donationCenter);

            if (res == null)
                err = true;

        } catch (Exception e) {
            e.printStackTrace();
            err = true;
        }

        if (err) {
            DonationCenter obj = new DonationCenter();

            model.addAttribute("donationCenter", obj);
            model.addAttribute("cityList", this.donationCenterService.findAllCentres());
            model.addAttribute("error", "Something went wrong!");

            return "/donationCenter/form";
        }

        return "redirect:/donation/center/list";
    }

    @RequestMapping(value = "/donation/center/list")
    public String donationCenterHandler(Model model) {

        model.addAttribute("list", this.donationCenterService.findAllCentres());

        return "/donationCenter/list";
    }
}
