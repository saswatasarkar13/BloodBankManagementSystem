package com.spring.springboot.apicontrollers;

import java.util.HashMap;
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
    public Map<String, Object> addBloodGroup(@RequestBody Map<String, String> payload) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            String city = (String) payload.get("city");
            String blood_group = (String) payload.get("bloodGroup");
            Integer quantity = Integer.parseInt(payload.get("quantity"));

            BloodAvailable ob = this.bloodAvailableService.findByCity(city);

            BloodGroupAvailable obj = new BloodGroupAvailable(blood_group, quantity, ob);

            BloodGroupAvailable result = bloodGroupAvaliableService.save(obj);
            if (result != null) {
                map.put("success", true);
                return map;
            } else {
                map.put("success", false);
                return map;
            }
        } catch (Exception e) {
            map.put("success", false);
            return map;
        }
    }

    @RequestMapping(value = "/group", method = RequestMethod.PUT)
    public Map<String, Object> updateBloodGroup(@RequestBody Map<String, String> payload) {
        HashMap<String, Object> map = new HashMap<>();
        try {

            String city = (String) payload.get("city");
            String bloodGroup = (String) payload.get("bloodGroup");
            Integer quantity = Integer.parseInt(payload.get("quantity"));

            BloodAvailable ob = this.bloodAvailableService.findByCity(city);

            BloodGroupAvailable obj = this.bloodGroupAvaliableService.findByCityAndBloodGroup(ob.getId(), bloodGroup);

            System.out.println(obj);
            obj.setQuantity(quantity);


            BloodGroupAvailable result = bloodGroupAvaliableService.save(obj);

            if (result != null) {
                map.put("success", true);
                return map;
            }

            map.put("success", false);
            return map;

        } catch (Exception e) {
            map.put("success", false);
            return map;
        }
    }
}
