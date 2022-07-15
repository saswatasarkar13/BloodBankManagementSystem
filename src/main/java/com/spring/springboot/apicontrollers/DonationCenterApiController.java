package com.spring.springboot.apicontrollers;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.models.DonationCenter;
import com.spring.springboot.services.BloodAvailableService;
import com.spring.springboot.services.DonationCenterService;

@RestController
@RequestMapping (value = "/api/donation/center")
public class DonationCenterApiController {

    @Autowired
    private DonationCenterService donationCenterService;

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @RequestMapping (value = "/", method = RequestMethod.POST)
    public Map<String, Object> addDonationCenter(@RequestBody Map <String, String> body){
        String city =body.get("city");
        String name= body.get("name");
        HashMap<String, Object> map = new HashMap<>();

        BloodAvailable cityB = this.bloodAvailableService.findByCity(city);
        DonationCenter donationCenter = new DonationCenter(name, cityB);
        DonationCenter dcStatus = this.donationCenterService.save(donationCenter);  
        if (dcStatus == null)
        {
            map.put("success", false);
            return map;
        }
        map.put("success", true);
        return map;
    } 
   
}
