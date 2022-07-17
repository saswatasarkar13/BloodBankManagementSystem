package com.spring.springboot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("blood_list", this.helpers.getList(list));
        model.addAttribute("blood_groups", Constants.BLOOD_GROUPS);

        HashMap<String, Long> stats = new HashMap<>();

        stats.put("donations", this.donationService.getCount());
        stats.put("procures", this.procureBloodService.getCount());
        stats.put("centers", this.donationCenterService.getCount());
        stats.put("activeDonors", this.userService.getActiveDonorsCount());
        stats.put("Total Users", this.userService.getCount());

        model.addAttribute("stats", stats);

        return "/admin/dashboard";
    }

    @RequestMapping(value = "/donation/list")
    public String donationsHandler(Model model) {

        List<BloodAvailable> list = bloodAvailableService.getAll();
        model.addAttribute("blood_list", this.helpers.getList(list));

        model.addAttribute("list", this.donationService.getAllPendingDonations());

        return "/donation/list";
    }

    @RequestMapping(value = "/procure/list")
    public String procuresHandler(Model model) {

        List<BloodAvailable> list = bloodAvailableService.getAll();
        model.addAttribute("blood_list", this.helpers.getList(list));

        model.addAttribute("list", this.procureBloodService.getAllPendingDonations());

        return "/procure/list";
    }

    @RequestMapping(value = "/blood-availability")
    public String bloodAvailabilityHandler(Model model, @RequestParam String city) {

        List<BloodAvailable> blood_list = bloodAvailableService.getAll();
        model.addAttribute("blood_list", this.helpers.getList(blood_list));

        BloodAvailable obj = this.bloodAvailableService.findByCity(city);
        TreeMap<String, Integer> list = this.helpers.getBloodQuantityList(obj.getBlood_groups());

        model.addAttribute("city", obj.getCity());
        model.addAttribute("list", list);

        return "/admin/bloodTable";
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public String searchUser(@RequestParam(required = false, name = "q") String keyword, Model model) {

        List<BloodAvailable> blood_list = bloodAvailableService.getAll();
        model.addAttribute("blood_list", this.helpers.getList(blood_list));

        if (keyword == null)
            return "/user/list";

        try {
            model.addAttribute("users", this.userService.searchUser(keyword));
            return "/user/list";

        } catch (Exception e) {
            e.printStackTrace();

            return "/user/list";
        }
    }

    @RequestMapping(value = "/city")
    public String addNewCityHandler(Model model) {
        List<BloodAvailable> blood_list = bloodAvailableService.getAll();
        model.addAttribute("blood_list", this.helpers.getList(blood_list));

        return "/admin/addCity";
    }
}
