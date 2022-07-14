package com.spring.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.springboot.models.Donation;
import com.spring.springboot.models.User;
import com.spring.springboot.services.DonationCenterService;
import com.spring.springboot.services.DonationService;
import com.spring.springboot.services.UserService;

@Controller
public class DonationController {
    @Autowired
    private DonationCenterService donationCenterService;

    @Autowired
    private UserService userService;

    @Autowired
    private DonationService donationService;

    @RequestMapping(value = "/donation", method = RequestMethod.GET)
    public String donationPage(Model model) {
        Donation obj = new Donation();

        model.addAttribute("donation", obj);
        model.addAttribute("donation_centers", this.donationCenterService.findAllCentres());
        return "/donation/form";
    }

    @RequestMapping(value = "/donation/add", method = RequestMethod.POST)
    public String addDonation(Donation donation, @CookieValue(name = "userid", defaultValue = "") String userId) {
        User user = this.userService.findById(Long.parseLong(userId));
        donation.setUserId(user);
        donation.setBlood_group(user.getBlood_group());
        this.donationService.save(donation);
        return "redirect:/donation/success";
    }

    @RequestMapping(value = "/donation/success")
    public String donationSuccessHandler()
    {
        return "/donation/success";
    }

}
