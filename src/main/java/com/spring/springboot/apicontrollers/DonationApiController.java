package com.spring.springboot.apicontrollers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.springboot.models.Donation;
import com.spring.springboot.services.DonationService;

@RestController
@RequestMapping (value= "/api/donation")
public class DonationApiController {
    
    @Autowired
    private DonationService donationService;

    @RequestMapping (value = "/status", method = RequestMethod.PUT)
    public Map<String, Object> setStatus (@RequestBody Map <String, String> body){
        String dId = body.get("id");
        String dStatus = body.get("status");
        HashMap <String, Object> map = new HashMap<>();
        Donation donation = this.donationService.findById(Long.parseLong(dId));
        donation.setStatus(dStatus);
        Donation donationBloodStatus = this.donationService.save(donation);
        if (donationBloodStatus == null)
        {
            map.put("success", false);
            return map;
        }
        else
        {
            map.put("success", true);
            return map;
        }

    }
}
