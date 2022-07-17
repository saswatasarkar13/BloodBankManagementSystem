package com.spring.springboot.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springboot.common.Constants;
import com.spring.springboot.helpers.BloodTable;
import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.services.BloodAvailableService;
import com.spring.springboot.services.DonationCenterService;
import com.spring.springboot.services.DonationService;
import com.spring.springboot.services.ProcureBloodService;
import com.spring.springboot.services.UserService;

@Controller
public class AdminController {

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @Autowired
    private DonationService donationService;

    @Autowired
    private DonationCenterService donationCenterService;

    @Autowired
    private ProcureBloodService procureBloodService;

    @Autowired
    private UserService userService;

    @Autowired
    private BloodTable helpers;

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model) {

        List<BloodAvailable> list = bloodAvailableService.getAll();

        model.addAttribute("blood_groups", Constants.BLOOD_GROUPS);
        model.addAttribute("blood_list", this.helpers.getList(list));

        HashMap<String, Long> stats = new HashMap<>();

        stats.put("donations", this.donationService.getCount());
        stats.put("procures", this.procureBloodService.getCount());
        stats.put("centers", this.donationCenterService.getCount());
        stats.put("activeDonors", this.userService.getActiveDonorsCount());
        stats.put("Total Users", this.userService.getCount());

        model.addAttribute("stats", stats);

        return "/admin/dashboard";
    }
}
