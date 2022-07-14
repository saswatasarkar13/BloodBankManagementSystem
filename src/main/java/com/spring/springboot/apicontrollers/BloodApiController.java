package com.spring.springboot.apicontrollers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.models.BloodGroupAvailable;
import com.spring.springboot.services.BloodAvailableService;
import com.spring.springboot.services.BloodGroupAvaliableService;

@RestController
@RequestMapping(value = "/api/blood")
public class BloodApiController {

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @Autowired
    private BloodGroupAvaliableService bloodGroupAvaliableService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BloodAvailable addNewCity(@RequestBody BloodAvailable ob) {
        try {
            return bloodAvailableService.save(ob);

        } catch (Exception e) {
            BloodAvailable res = new BloodAvailable();
            return res;
        }
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public String addBloodGroup(@RequestBody Map<String, String> payload) {

        try {
            String city = (String) payload.get("city");
            String blood_group = (String) payload.get("bloodGroup");
            Integer quantity = Integer.parseInt(payload.get("quantity"));

            BloodAvailable ob = this.bloodAvailableService.findByCity(city);

            BloodGroupAvailable obj = new BloodGroupAvailable(blood_group, quantity, ob);

            BloodGroupAvailable result = bloodGroupAvaliableService.save(obj);
            if (result!=null)
                return "Successfull";
            else
                return "Unsucessfull";
        } catch (Exception e) {
            return "Unsucessfull";
        }
    }
}
