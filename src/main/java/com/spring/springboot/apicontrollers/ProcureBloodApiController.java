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
import com.spring.springboot.models.ProcureBlood;
import com.spring.springboot.services.BloodAvailableService;
import com.spring.springboot.services.BloodGroupAvaliableService;
import com.spring.springboot.services.ProcureBloodService;

@RestController
@RequestMapping(value = "/api/procure")
public class ProcureBloodApiController {

    @Autowired
    private ProcureBloodService procureBloodService;

    @Autowired
    private BloodAvailableService bloodAvailableService;

    @Autowired
    private BloodGroupAvaliableService bloodGroupAvaliableService;

    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    public Map<String, Object> setStatus(@RequestBody Map<String, String> body) {
        HashMap<String, Object> map = new HashMap<>();

        try {
            String pbid = body.get("id");
            String pbStatus = body.get("status");

            ProcureBlood procureBlood = this.procureBloodService.findById(Long.parseLong(pbid));
            procureBlood.setStatus(pbStatus);

            if (pbStatus.equals("completed")) {
                BloodAvailable ba = this.bloodAvailableService.findByCity(procureBlood.getCity());
                BloodGroupAvailable bga = this.bloodGroupAvaliableService.findByCityAndBloodGroup(ba,
                        procureBlood.getBlood_group());

                if (bga != null) {
                    bga.setQuantity(bga.getQuantity() - procureBlood.getQuantity());
                    this.bloodGroupAvaliableService.save(bga);
                }
            }

            ProcureBlood procureBloodStatus = this.procureBloodService.save(procureBlood);

            if (procureBloodStatus == null)
                map.put("success", false);
            else
                map.put("success", true);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }

        return map;
    }
}
